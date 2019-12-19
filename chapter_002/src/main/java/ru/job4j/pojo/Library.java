package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book book1 = new Book("Code clean", 354);
        Book book2 = new Book("Head First Java", 302);
        Book book3 = new Book("Head First Design Patterns", 285);
        Book book4 = new Book("Effective Java", 403);

        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;

        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println(book.getName() + " - " + book.getCount());
        }

        Book tmp = books[0];
        books[0] = books[3];
        books[3] = tmp;

        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println(book.getName() + " - " + book.getCount());
        }

        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            if (book.getName().equals("Code clean")) {
                System.out.println(book.getName() + " - " + book.getCount());
            }
        }

    }
}
