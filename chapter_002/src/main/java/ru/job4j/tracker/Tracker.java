package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Random;

public class Tracker implements ITracker {

    private final ArrayList<Item> items = new ArrayList<>();

    /**
     * Метод добавления заявки в хранилище
     *
     * @param item новая заявка
     */
    @Override
    public Item add(Item item) {
        item.setId(this.generateId());
        items.add(item);
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     *
     * @return Уникальный ключ.
     */
    private String generateId() {
        //Реализовать метод генерации.
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }

    /**
     * Метод findAll() возвращает список всех заявок.
     *
     * @return список this.items
     */
    @Override
    public ArrayList<Item> findAll() {
        return this.items;
    }

    /**
     * Метод findByName(String key) для получения списка заявок по имени
     *
     * @param name имя заявки
     * @return список this.items с выборкой по имени заявки
     */
    @Override
    public ArrayList<Item> findByName(String name) {
        ArrayList<Item> result = new ArrayList<>();
        for (Item item : this.items) {
            if (item.getName().equals(name)) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Метод indexOf(String id) ищет индекс списка items, в котором объект с данным id
     *
     * @param id идентификатор объекта Item
     * @return индекс списка items
     */

    private int indexOf(String id) {
        int rsl = -1;
        for (int index = 0; index < this.items.size(); index++) {
            if (items.get(index).getId().equals(id)) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    /**
     * Метод findById(String id) для получения заявки по уникальному ключу (id)
     *
     * @param id уникальный ключ заявки
     * @return заявка с искомым id
     */

    @Override
    public Item findById(String id) {
        Item result = null;
        int index = indexOf(id);
        if (index != -1) {
            result = items.get(index);
        }
        return result;
    }

    @Override
    public void replace(String id, Item item) {
        int index = indexOf(id);
        if (index != -1) {
            item.setId(items.get(index).getId());
            items.set(index, item);
            System.out.println("Item replaced!");
        } else {
            System.out.println("Invalid id of item selected!");
        }
    }

    @Override
    public void deleteItem(String id) {
        int index = indexOf(id);
        if (index != -1) {
            this.items.remove(index);
            System.out.println("=== Item was deleted ====");
        } else {
            System.out.println("Invalid id of item selected!");
        }
    }
}
