package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class Tracker.
 * <p>
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 16.04.2020
 */
public class TrackerSQL implements ITracker, AutoCloseable {
    private static final Logger LOG = LoggerFactory.getLogger(TrackerSQL.class.getName());
    private static final String QUERY_ADD = "INSERT INTO items (name, userid, category, status) "
            + "VALUES (?, ?, ?, ?);";
    private static final String QUERY_FIND_BY_ID = "SELECT * FROM items WHERE id = ?;";
    private static final String QUERY_FIND_BY_NAME = "SELECT * FROM items WHERE name = ?;";
    private static final String QUERY_FIND_ALL = "SELECT * FROM items;";
    private static final String QUERY_DELETE = "DELETE FROM items WHERE id = ?;";
    private static final String QUERY_REPLACE =
            "UPDATE items SET  name = ?, userid = ?, category = ? WHERE id = ?;";
    private static final String QUERY_CREATE_TABLE =
            "CREATE TABLE IF NOT EXISTS items ("
                    + "id serial primary key, "
                    + "name varchar(500), "
                    + "createtime timestamp default now(), "
                    + "closetime timestamp, "
                    + "userid int references users(id), "
                    + "category varchar references categories(category), "
                    + "status varchar references state(status));";

    private Connection connection;

    public TrackerSQL(Connection connection) {
        this.connection = connection;
    }

    /**
     * Method init.
     * Creates a database connection. If the items table is not created, it creates it.
     * <p>
     *
     * @return the boolean
     */
    public boolean init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            this.connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
            createTable();
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return this.connection != null;
    }

    private void createTable() {
        try (PreparedStatement st = this.connection.prepareStatement(QUERY_CREATE_TABLE)) {
            st.executeUpdate();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement st = connection.prepareStatement(QUERY_ADD, Statement.RETURN_GENERATED_KEYS)) {
            st.setString(1, item.getName());
            st.setInt(2, item.getUserId());
            st.setString(3, item.getCategory());
            st.setString(4, "awaiting");
            st.executeUpdate();
            try (ResultSet generateKeys = st.getGeneratedKeys()) {
                if (generateKeys.next()) {
                    item.setId(String.valueOf(generateKeys.getInt(1)));
                }
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return item;
    }

    @Override
    public boolean replace(String id, Item item) {
        boolean result = false;
        try (PreparedStatement st = connection.prepareStatement(QUERY_REPLACE)) {
            st.setString(1, item.getName());
            st.setInt(2, item.getUserId());
            st.setString(3, item.getCategory());
            st.setInt(4, Integer.parseInt(id));
            result = st.executeUpdate() > 0;
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public boolean deleteItem(String id) {
        boolean result = false;
        try (PreparedStatement st = connection.prepareStatement(QUERY_DELETE)) {
            st.setInt(1, Integer.parseInt(id));
            result = st.executeUpdate() > 0;
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * Method deleteAll.
     * Removes all items from a table.
     * <p>
     *
     * @param table the table
     */
    public void deleteAll(String table) {
        try (PreparedStatement st = connection.prepareStatement("DELETE FROM " + table)) {
            st.executeUpdate();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    @Override
    public List<Item> findAll() {
        List<Item> result = new ArrayList<>();
        try (PreparedStatement st = connection.prepareStatement(QUERY_FIND_ALL);
             ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                result.add(createItem(rs));
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public List<Item> findByName(String name) {
        List<Item> result = new ArrayList<>();
        try (PreparedStatement st = connection.prepareStatement(QUERY_FIND_BY_NAME)) {
            st.setString(1, name);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    result.add(createItem(rs));
                }
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public Item findById(String id) {
        Item result = null;
        try (PreparedStatement st = connection.prepareStatement(QUERY_FIND_BY_ID)) {
            st.setInt(1, Integer.parseInt(id));
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    result = createItem(rs);
                }
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * Creates a item.
     *
     * @param rs the rs
     * @return the item
     * @throws SQLException the sql exception
     */
    public Item createItem(ResultSet rs) throws SQLException {
        Item item;
        String idItem = rs.getString("id");
        String nameItem = rs.getString("name");
        Timestamp createTimeItem = rs.getTimestamp("createtime");
        Timestamp closeTimeItem = rs.getTimestamp("closetime");
        Integer userID = rs.getInt("userid");
        String category = rs.getString("category");
        String status = rs.getString("status");
        item = new Item(nameItem, userID, category);
        item.setId(idItem);
        item.setCreateTime(createTimeItem);
        item.setCloseTime(closeTimeItem);
        item.setStatus(status);
        return item;
    }
}
