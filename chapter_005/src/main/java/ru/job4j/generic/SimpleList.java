package ru.job4j.generic;


public class SimpleList<E> {

    Object[] objects;
    int index = 0;

    public SimpleList(int size) {
        this.objects = new Object[size];
    }

    public <K> K print(K value) {
        System.out.println(value);
        return value;
    }

    public void add(E value) {
        this.objects[index++] = value;
    }

    public E get(int position) {
        return (E) this.objects[position];
    }
}

