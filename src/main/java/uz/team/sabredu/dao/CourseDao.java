package uz.team.sabredu.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import uz.team.sabredu.configs.HibernateConfigurer;
import uz.team.sabredu.domains.Course;
import uz.team.sabredu.domains.auth.AuthUser;

import java.util.List;

public class CourseDao implements Dao<Course> {
    @Override
    public Course persist(Course course) {
        Session session = HibernateConfigurer.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.persist(course);
        transaction.commit();
        session.close();
        return course;
    }

    @Override
    public void delete(Long id) {
        Session session = HibernateConfigurer.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        Query<AuthUser> id1 = session.createQuery("update Course set deleted = true where id = :id", AuthUser.class)
                .setParameter("id", id);
        id1.executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Course course) {
        Session session = HibernateConfigurer.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.merge(course);
        transaction.commit();
        session.close();
    }

    @Override
    public Course findOne(Long id) {
        Session session = HibernateConfigurer.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        Course id1 = session.createQuery("select t from Course t where t.id = :id", Course.class)
                .setParameter("id", id).getSingleResultOrNull();
        transaction.commit();
        session.close();
        return id1;
    }

    @Override
    public List<Course> findAll() {
        Session session = HibernateConfigurer.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        List<Course> list = session.createQuery("select t from Course t", Course.class).getResultList();
        transaction.commit();
        session.close();
        return list;
    }
}
