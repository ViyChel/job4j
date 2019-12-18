package ru.job4j.condition;

import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

public class Point {

    /**
     * Это поле объекта. Оно доступно только кокретному объекту.
     */
    private int x;

    /**
     * И это поле объекта. Оно доступно только кокретному объекту.
     */
    private int y;

    /**
     * И это поле объекта. Оно доступно только кокретному объекту.
     */
    private int z;

    /**
     * Конструтор, который принимает начальное состояние объекта "точка"
     *
     * @param first  координата x
     * @param second координата y
     */
    public Point(int first, int second) {
        this.x = first;
        this.y = second;
    }

    /**
     * Конструтор, который принимает начальное состояние объекта "точка"
     *
     * @param x координата x
     * @param y координата y
     * @param z координата z
     */
    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Метод distance3d подсчетывает расстояние между двумя точками
     * @param that объект точки для вычисления
     * @return double расстояние
     */

    public double distance(Point that) {
        return sqrt(pow(this.x - that.x, 2) + pow(this.y - that.y, 2));
    }

    /**
     * Метод distance3d подсчетывает расстояние между двумя точками в трех мерном пространстве
     * @param that объект точки для вычисления
     * @return double расстояние
     */

    public double distance3d(Point that) {

        return sqrt(pow(this.x - that.x, 2) + pow(this.y - that.y, 2) + pow(this.z - that.z, 2));
    }

    public void info() {
        System.out.println(String.format("Point[%s, %s]", this.x, this.y));
    }
}