package ru.job4j.tracker;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ===");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void showAllItems(Input input, Tracker tracker) {
        Item[] result = tracker.findAll();
        System.out.println("All items: ");
        for (Item item : result) {
            System.out.println(item.getId() + " " + item.getName());
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println(" === Update item ===");
        String id = input.askStr("Enter id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            item.setName(input.askStr("Enter a new name of item: "));
            item.setId(id);
            tracker.replace(id, item);
        } else {
            System.out.println("Invalid id of item selected!");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("Delete item");
        String id = input.askStr("Enter Id: ");
        tracker.deleteItem(id);
    }

    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("=== Find item by Id ===");
        String id = input.askStr("Enter Id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("=== Item found by Id: " + id + " ===");
            System.out.println(item.getId() + " " + item.getName());
        } else {
            System.out.println("Item not found!");
        }

    }

    public static void findItemByName(Input input, Tracker tracker) {
        System.out.println("=== Find items by name ===");
        String name = input.askStr("Enter name: ");
        Item[] result = tracker.findByName(name);
        if (result.length > 0) {
            System.out.println("=== Items found by name: " + name + " ===");
            for (Item item : result) {
                System.out.println(item.getId() + " " + item.getName());
            }
        } else {
            System.out.println("Items not found!");
        }

    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.showAllItems(input, tracker);
            } else if (select == 2) {
                StartUI.replaceItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findItemById(input, tracker);
            } else if (select == 5) {
                StartUI.findItemByName(input, tracker);
            } else if (select == 6) {
                run = false;
            } else {
                System.out.println("Choose the correct menu item!");
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}