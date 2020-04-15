package ru.job4j.tracker;

import java.util.List;

public interface ITracker {
    Item add(Item item);
<<<<<<< HEAD
    void replace(String id, Item item);
    void deleteItem(String id);
=======
    boolean replace(String id, Item item);
    boolean deleteItem(String id);
>>>>>>> tracker
    List<Item> findAll();
    List<Item> findByName(String key);
    Item findById(String id);
}