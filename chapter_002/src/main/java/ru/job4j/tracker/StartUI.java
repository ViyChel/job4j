package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = input.askInt("");
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = input.askStr("");
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                Item[] result = tracker.findAll();
                System.out.println("All items: ");
                for (Item item : result) {
                    System.out.println(item.getId() + " " + item.getName());
                }
            } else if (select == 2) {
                System.out.println("Edit item");
                System.out.print("Enter Id: ");
                String id = input.askStr("");
                System.out.print("Enter new name: ");
                String newName = input.askStr("");
                tracker.findById(id).setName(newName);
                System.out.println("=== Item was edited ====");
            } else if (select == 3) {
                System.out.println("Delete item");
                System.out.print("Enter Id: ");
                String id = input.askStr("");
                tracker.deleteItem(id);
                System.out.println("=== Item was deleted ====");
            } else if (select == 4) {
                System.out.println("=== Find item by Id ====");
                System.out.print("Enter Id: ");
                String id = input.askStr("");
                System.out.println("=== Item found by Id: " + id + " ====");
                System.out.println(tracker.findById(id).getId() + " " + tracker.findById(id).getName());
            } else if (select == 5) {
                System.out.println("=== Find items by name ====");
                System.out.print("Enter name: ");
                String name = input.askStr("");
                Item[] result = tracker.findByName(name);
                System.out.println("=== Items found by name:  ====");
                for (Item item : result) {
                    System.out.println(item.getId() + " " + item.getName());
                }

            } else if (select == 6) {
                run = false;
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