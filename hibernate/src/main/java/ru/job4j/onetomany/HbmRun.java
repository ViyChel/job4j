package ru.job4j.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Arrays;
import java.util.List;

/**
 * Class HbmRun.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 06.01.2021
 */
public class HbmRun {
    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try (SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
             Session session = sf.openSession()) {
            session.beginTransaction();
            List<Model> models = Arrays.asList(
                    Model.of("BMW X3"),
                    Model.of("BMW X6"),
                    Model.of("BMW M5"),
                    Model.of("BMW X1"),
                    Model.of("BMW M4")
            );
            models.forEach(session::save);
            Brand brand = Brand.of("BMW");
            models.forEach(el -> brand.addModel(session.load(Model.class, el.getId())));
            session.save(brand);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
