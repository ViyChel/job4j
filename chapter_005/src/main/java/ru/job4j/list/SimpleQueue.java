package ru.job4j.list;

import java.util.NoSuchElementException;

/**
 * Class SimpleQueue
 *
 * @param <T> the type parameter
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 18.02.2020
 */

public class SimpleQueue<T> {
    private SimpleStack<T> stack = new SimpleStack();
    private SimpleStack<T> queue = new SimpleStack();

    public T poll() {
        while (this.stack.getSize() > 0) {
            this.queue.push(this.stack.poll());
        }
        return this.queue.poll();
    }

    public void push(T value) {
        this.stack.push(value);
    }
}
