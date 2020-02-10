package ru.job4j.generic;

/**
 * Class UserStore
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 10.02.2020
 */

public class UserStore extends AbstractStore<User> {

    public UserStore(int size) {
        super(size);
    }
}

