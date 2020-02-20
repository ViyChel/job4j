package ru.job4j.map;

import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class UserTest {

    /**
     * В консоле будет вывод двух объектов {ru.job4j.map.User@a4fead3b=Vasya, ru.job4j.map.User@a4fead3b=Vasya}
     * "Это вывод с использованием метода toString, который после знака @ выводит a4fead3b. Это строка,сгенеренная
     * в шестнадцатеричной системе, на основе числа полученного из метода hashCode. Т.к. метод hashCode у нас
     * переопределен, для наших объектов он выдает одинаковое число.
     * При одинаковом хешкоде втупает в работу метод equals.
     * Этот метод у нас не переопределен, поэтому используется "родительский" вариант, который сравнивает ссылки на объекты.
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