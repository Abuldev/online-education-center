package uz.team.sabredu.configs;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import uz.team.sabredu.domains.*;
import uz.team.sabredu.domains.answer.Answer;
import uz.team.sabredu.domains.auth.AuthUser;
;
import java.util.Objects;
import java.util.Properties;


public class HibernateConfigurer {
    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;


    private static Session openSession;


    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

                Properties settings = new Properties();

                settings.put(Environment.DRIVER, "org.postgresql.Driver");
                settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/edudata");
                settings.put(Environment.USER, "postgres");
                settings.put(Environment.PASS, "yusupov2002");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.HBM2DDL_AUTO, "update");
                settings.put(Environment.FORMAT_SQL, "true");


                // HikariCP settings

                // Maximum waiting time for a connection from the pool
                settings.put("hibernate.hikari.connectionTimeout", "20000");
                // Minimum number of ideal connections in the pool
                settings.put("hibernate.hikari.minimumIdle", "10");
                // Maximum number of actual connection in the pool
                settings.put("hibernate.hikari.maximumPoolSize", "20");
                // Maximum time that a connection is allowed to sit ideal in the pool
                settings.put("hibernate.hikari.idleTimeout", "300000");

                // Apply settings
                registryBuilder.applySettings(settings);

                // Create registry
                registry = registryBuilder.build();

                // Create MetadataSources
                MetadataSources sources = new MetadataSources(registry);

                sources.addAnnotatedClass(AuthUser.class);
                sources.addAnnotatedClass(Answer.class);
                sources.addAnnotatedClass(Course.class);
                sources.addAnnotatedClass(Lesson.class);
                sources.addAnnotatedClass(Task.class);
                sources.addAnnotatedClass(Upload.class);

                // Create Metadata
                Metadata metadata = sources.getMetadataBuilder().build();

                // Create SessionFactory
                sessionFactory = metadata.getSessionFactoryBuilder().build();

            } catch (Exception e) {
                e.printStackTrace();
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        return sessionFactory;
    }

    public static void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public static Session getSession() {
        synchronized (HibernateConfigurer.class) {
            if (Objects.isNull(openSession) || !openSession.isOpen()){
                openSession =  getSessionFactory().openSession();
            }
        }
        return openSession;
    }


}
