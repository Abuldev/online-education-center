package uz.team.sabredu.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import uz.team.sabredu.configs.HibernateConfigurer;
import uz.team.sabredu.domains.Material;
import uz.team.sabredu.domains.Task;

import java.util.List;

public class TaskDao implements Dao<Task>{
    @Override
    public Task persist(Task task) {
        Session session = HibernateConfigurer.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.persist(task);
        transaction.commit();
        session.close();
        return task;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Task task) {
        Session session = HibernateConfigurer.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.merge(task);
        transaction.commit();
        session.close();
    }

    @Override
    public Task findOne(Long id) {
        Session session = HibernateConfigurer.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        Task id1 = session.createQuery("select t from Task t where t.id = :id", Task.class)
                .setParameter("id", id).getSingleResultOrNull();
        transaction.commit();
        session.close();
        return id1;
    }

    @Override
    public List<Task> findAll() {

        Session session = HibernateConfigurer.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        List<Task> list = session.createQuery("select t from Task t", Task.class).getResultList();
        transaction.commit();
        session.close();
        return list;
    }
}
