package ru.job4j.lazy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
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
        List<Brand> list = new ArrayList<>();
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try (SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
             Session session = sf.openSession()) {
            session.beginTransaction();
            list = session.createQuery(
                    "select distinct c from Brand c join fetch c.models"
            ).list();
            /*Brand bmw = Brand.of("BMW");
            Model model1 = Model.of("BMW X3", bmw);
            Model model2 = Model.of("BMW X6", bmw);
            Model model3 = Model.of("BMW X1", bmw);
            session.save(model1);
            session.save(model2);
            session.save(model3);
            bmw.getModels().add(model1);
            bmw.getModels().add(model2);
            bmw.getModels().add(model3);
            session.save(bmw);*/
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
        for (Model model : list.get(0).getModels()) {
            System.out.println(model);
        }
    }
}
