package ru.job4j.map;

import java.util.Calendar;
import java.util.Objects;

/**
 * Class User
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 20.02.2020
 */
public class User {
    private String name;
    private int children;
    private Calendar birthday;

    /**
     * Instantiates a new User.
     *
     * @param name     the name
     * @param children the children
     * @param birthday the birthday
     */
    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets children.
     *
     * @return the children
     */
    public int getChildren() {
        return children;
    }

    /**
     * Sets children.
     *
     * @param children the children
     */
    public void setChildren(int children) {
        this.children = children;
    }

    /**
     * Gets birthday.
     *
     * @return the birthday
     */
    public Calendar getBirthday() {
        return birthday;
    }

    /**
     * Sets birthday.
     *
     * @param birthday the birthday
     */
    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
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
        return children == user.children
                && Objects.equals(name, user.name)
                && Objects.equals(birthday, user.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }
}

