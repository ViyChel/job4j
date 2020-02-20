package ru.job4j.map;

import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class UserTest {

    /**
     * В консоли будет вывод двух объектов {ru.job4j.map.User@13b6d03=Vasya, ru.job4j.map.User@282ba1e=Vasya}
     * Это вывод с использованием метода toString, который после знака @ выводит 13b6d03. Это строка,сгенеренная
     * в шестнадцатеричной системе, на основе числа полученного из метода hashCode. Т.к. метод hashCode у нас
     * не переопределен, для наших объектов он выдает разные числа.
     * До выполнения метода equals не дойдет. Т.к. сначала объекты сравниваются по хешкоду.
     * Они у нас разные, поэтому объекты считаются разными.
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