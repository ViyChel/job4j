package ru.job4j.di;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Store.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 01.02.2021
 */
@Component
@Scope("prototype")
public class Store {
    private List<String> data = new ArrayList<String>();

    public void add(String value) {
        data.add(value);
    }

    public List<String> getAll() {
        return data;
    }
}
