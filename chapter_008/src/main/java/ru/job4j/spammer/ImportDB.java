package ru.job4j.spammer;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


/**
 * Class ImportDB
 *
 * Есть файл dump.txt с записями типа Ivan Ivanov;iivanov@gmail.com;
 * Необходимо внести в базу данных PostgreSQL users записи в формате name - Ivan Ivanov, email - iivanov@gmail.com.
 */
public class ImportDB {

    private Properties cfg;
    private String dump;

    /**
     * Instantiates a new Import db.
     *
     * @param cfg  the cfg
     * @param dump the dump
     */
    public ImportDB(Properties cfg, String dump) {
        this.cfg = cfg;
        this.dump = dump;
    }

    /**
     * Load list.
     *
     * @return the list
     * @throws IOException the io exception
     */
    public List<User> load() throws IOException {
        List<User> users = new ArrayList<>();
        try (BufferedReader rd = new BufferedReader(new FileReader(dump))) {
            rd.lines()
                    .map(line -> line.split(";"))
                    .forEach(array -> users.add(new User(array[0], array[1])));
        }
        return users;
    }

    /**
     * Save.
     *
     * @param users the users
     * @throws ClassNotFoundException the class not found exception
     * @throws SQLException           the sql exception
     */
    public void save(List<User> users) throws ClassNotFoundException, SQLException {
        Class.forName(cfg.getProperty("jdbc.driver"));
        try (Connection cnt = DriverManager.getConnection(
                cfg.getProperty("jdbc.url"),
                cfg.getProperty("jdbc.username"),
                cfg.getProperty("jdbc.password")
        )) {
            for (User user : users) {
                try (PreparedStatement ps = cnt.prepareStatement("INSERT INTO users (name, email) VALUES (?, ?);")) {
                    ps.setString(1, user.name);
                    ps.setString(2, user.email);
                    ps.execute();
                }
            }
        }
    }

    private static class User {
        /**
         * The Name.
         */
        String name;
        /**
         * The Email.
         */
        String email;

        /**
         * Instantiates a new User.
         *
         * @param name  the name
         * @param email the email
         */
        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws Exception the exception
     */
    public static void main(String[] args) throws Exception {
        Properties cfg = new Properties();
        try (FileInputStream in = new FileInputStream("./spammer.properties")) {
            cfg.load(in);
        }
        ImportDB db = new ImportDB(cfg, "./dump.txt");
        db.save(db.load());
    }
}