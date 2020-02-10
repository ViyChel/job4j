package ru.job4j.generic;

import java.util.Iterator;

/**
 * Abstract class AbstractStore
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 10.02.2020
 */

public abstract class AbstractStore<T extends Base> implements Store<T> {
    private SimpleArray<T> list;

    protected AbstractStore(int size) {
        this.list = new SimpleArray<>(size);
    }

    @Override
    public void add(T model) {
        this.list.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        boolean result = false;
        Iterator<T> iterator = list.iterator();
        int idx = 0;
        while (iterator.hasNext()) {
            if (iterator.next().getId().equals(id)) {
                list.set(idx, model);
                result = true;
                break;
            }
            idx++;
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        Iterator<T> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId().equals(id)) {
                iterator.remove();
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public T findById(String id) {
        T result = null;
        for (T element : list) {
            if (element.getId().equals(id)) {
                result = element;
                break;
            }
        }
        return result;
    }
}

