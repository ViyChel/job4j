package ru.job4j.exam;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Class Analize
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 01.03.2020
 */
public class Analize {

    /**
     * Diff info.
     *
     * @param previous the previous
     * @param current  the current
     * @return the info
     */
    public Info diff(List<User> previous, List<User> current) {
        Info result = new Info();
        Map<Integer, User> map = previous.stream().collect(Collectors.toMap(User::getId, user -> user));
        for (User user : current) {
            if (!map.containsKey(user.getId())) {
                result.added++;
            } else if (!map.get(user.getId()).getName().equals(user.getName())) {
                result.changed++;
                map.remove(user.getId());
            }
            map.remove(user.getId());
        }
        result.deleted = map.size();
        return result;
    }

    /**
     * The type User.
     */
    public static class User {
        private int id;
        private String name;

        /**
         * Instantiates a new User.
         *
         * @param id   the id
         * @param name the name
         */
        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        /**
         * Gets id.
         *
         * @return the id
         */
        public int getId() {
            return id;
        }

        /**
         * Gets name.
         *
         * @return the name
         */
        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return id == user.id
                    && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    /**
     * The type Info.
     */
    public static class Info {
        /**
         * The Added.
         */
        int added;
        /**
         * The Changed.
         */
        int changed;
        /**
         * The Deleted.
         */
        int deleted;
    }
}
