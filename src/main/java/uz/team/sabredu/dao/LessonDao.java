package uz.team.sabredu.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import uz.team.sabredu.configs.HibernateConfigurer;
import uz.team.sabredu.domains.Lesson;

import java.util.List;

public class LessonDao implements Dao<Lesson> {
    @Override
    public Lesson persist(Lesson lesson) {
        Session session = HibernateConfigurer.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.persist(lesson);
        transaction.commit();
        session.close();
        return lesson;
    }

    @Override
    public void delete(Long id) {
        Session session = HibernateConfigurer.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        Query<Lesson> id1 = session.createQuery("update Lesson set deleted = true where id = :id", Lesson.class)
                .setParameter("id", id);
        id1.executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Lesson lesson) {
        Session session = HibernateConfigurer.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.merge(lesson);
        transaction.commit();
        session.close();
    }

    @Override
    public Lesson findOne(Long id) {
        Session session = HibernateConfigurer.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        Lesson id1 = session.createQuery("select t from Lesson t where t.id = :id", Lesson.class)
                .setParameter("id", id).getSingleResultOrNull();
        transaction.commit();
        session.close();
        return id1;
    }

    @Override
    public List<Lesson> findAll() {
        Session session = HibernateConfigurer.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        List<Lesson> list = session.createQuery("select t from Lesson t", Lesson.class).getResultList();
        transaction.commit();
        session.close();
        return list;
    }
}
