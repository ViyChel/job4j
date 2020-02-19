package ru.job4j.map;

import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class UserTest {

    /**
     * В консоле будет вывод двух объектов {ru.job4j.map.User@13b6d03=Vasya, ru.job4j.map.User@282ba1e=Vasya}
     * Хотя по бизнес логике это два одинаковых объекта.
     * Т.к. методы hashcode и equals не переопределены, хеши у объектов разные. И объекты будут считаться разными.
     * Поэтому будет вывод двух объектов.
     */

    @Test
    public void whenTest() {
        User first = new User("Vasya", 2, new GregorianCalendar(1998, 12, 12));
        User second = new User("Vasya", 2, new GregorianCalendar(1998, 12, 12));
        Map<User, Object> map = new HashMap<>();
        map.put(first, first.getName());
        map.put(second, first.getName());
        System.out.println(map);
    }
}