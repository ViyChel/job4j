package ru.job4j.tracker;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;

public class TrackerSQLTest {

    public Connection init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void createItem() throws SQLException {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("name", 1, "info"));
            assertThat(tracker.findByName("name").size(), is(1));
        }
    }

    @Test
    public void checkConnection() throws SQLException {
        TrackerSQL sql = new TrackerSQL(ConnectionRollback.create(this.init()));
        assertThat(sql.init(), is(true));
        sql.close();
    }

    @Test
    public void whenInsertNewItem() throws SQLException {
        TrackerSQL sql = new TrackerSQL(ConnectionRollback.create(this.init()));
        sql.init();
        Item item = sql.add(new Item("A pass to the company", 1, "access"));
        Item expected = sql.findById(item.getId());
        assertEquals(item.getId(), expected.getId());
        assertEquals(item.getName(), expected.getName());
        sql.close();
    }

    @Test
    public void whenDeleteItem() throws SQLException {
        TrackerSQL sql = new TrackerSQL(ConnectionRollback.create(this.init()));
        sql.init();
        Item item = sql.add(new Item("Removal test", 1, "error"));
        sql.deleteItem(item.getId());
        assertNull(sql.findById(item.getId()));
        sql.close();
    }

    @Test
    public void whenFindByIdItem() throws SQLException {
        TrackerSQL sql = new TrackerSQL(ConnectionRollback.create(this.init()));
        sql.init();
        Item item = sql.add(new Item("Search Testing", 1, "error"));
        Item expected = sql.findById(item.getId());
        assertEquals(item.getId(), expected.getId());
        assertEquals(item.getName(), expected.getName());
        sql.close();
    }

    @Test
    public void whenFindByNameItem() throws SQLException {
        TrackerSQL sql = new TrackerSQL(ConnectionRollback.create(this.init()));
        sql.init();
        Item item1 = sql.add(new Item("Search by name", 1, "info"));
        Item item2 = sql.add(new Item("Search by name", 2, "error"));
        Item item3 = sql.add(new Item("Search by name", 1, "access"));
        List<Item> expected = sql.findByName(item1.getName());
        sql.deleteItem(item1.getId());
        sql.deleteItem(item2.getId());
        sql.deleteItem(item3.getId());
        assertThat(expected.size(), is(3));
        sql.close();
    }

    @Test
    public void whenFindAllItem() throws SQLException {
        TrackerSQL sql = new TrackerSQL(ConnectionRollback.create(this.init()));
        sql.init();
        sql.deleteAll("items");
        Item item1 = sql.add(new Item("Search by all", 1, "info"));
        Item item2 = sql.add(new Item("Search by all", 2, "error"));
        Item item3 = sql.add(new Item("Search by all", 1, "access"));
        Item item4 = sql.add(new Item("Search by all", 1, "error"));
        List<Item> expected = sql.findAll();
        assertThat(expected.size(), is(4));
        sql.close();
    }

    @Test
    public void whenReplaceItem() throws SQLException {
        TrackerSQL sql = new TrackerSQL(ConnectionRollback.create(this.init()));
        sql.init();
        Item item1 = sql.add(new Item("New item", 2, "error"));
        String id = item1.getId();
        Item item2 = new Item("Replacement testing", 1, "info");
        sql.replace(id, item2);
        Item expected = sql.findById(id);
        assertEquals(expected.getName(), "Replacement testing");
        assertEquals(expected.getCategory(), "info");
        sql.close();
    }
}
