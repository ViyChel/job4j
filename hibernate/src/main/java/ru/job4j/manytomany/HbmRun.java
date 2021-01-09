package ru.job4j.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Class HbmRun.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 07.01.2021
 */
public class HbmRun {
    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try (SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
             Session session = sf.openSession()) {
            session.beginTransaction();
            Book book1 = Book.of("Core Java Volume I – Fundamentals");
            Book book2 = Book.of("Effective Java");
            Book book3 = Book.of("Java Concurrency in Practice");

            Author author1 = Author.of("Cay S. Horstmann");
            author1.getBooks().add(book1);
            Author author2 = Author.of("Joshua Bloch");
            author2.getBooks().add(book2);
            author2.getBooks().add(book3);
            Author author3 = Author.of("Brian Goetz with Tim Peierls");
            author3.getBooks().add(book3);

            session.persist(author1);
            session.persist(author2);
            session.persist(author3);
            /*Author author = session.get(Author.class, 2);
            session.remove(author);*/
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
