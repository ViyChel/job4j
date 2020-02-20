package ru.job4j.map;

import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class UserTest {

    /**
     * В консоли будет вывод одного объекта {ru.job4j.map.User@a4fead3b=Vasya} .
     * Т.к. мы переопределили методы hashCode() и equals() согласно полям наших объектов
     * метод hashCode() вернет одинаковые числа. В этом случае в работу вступает equals().
     * Он сравнивает в нашем случае три поля children, name, birthday. Т.к. они одинаковые
     * объекты считаются идентичными. Поэтому в map объект second не запишется (т.к. объект
     * использутся как ключ в map. А в map ключи должны быть уникальными).
     * Поэтому будет вывод одного объекта.
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