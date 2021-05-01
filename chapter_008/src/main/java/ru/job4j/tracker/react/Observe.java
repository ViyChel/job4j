package ru.job4j.tracker.react;

/**
 * Interface Observe.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 01.05.2021
 */
public interface Observe<T> {
    void receive(T model);
}
