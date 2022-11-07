package uz.team.sabredu.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import uz.team.sabredu.configs.HibernateConfigurer;
import uz.team.sabredu.domains.Upload;
import uz.team.sabredu.domains.Upload;

import java.util.List;

public class FileStorageDao implements Dao<Upload> {
    @Override
    public Upload persist(Upload upload) {
        Session session = HibernateConfigurer.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.persist(upload);
        transaction.commit();
        session.close();
        return upload;
    }

    @Override
    public void delete(Long id) {

    }


    @Override
    public void update(Upload upload) {
        Session session = HibernateConfigurer.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.merge(upload);
        transaction.commit();
        session.close();
    }

    @Override
    public Upload findOne(Long id) {
        Session session = HibernateConfigurer.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        Upload id1 = session.createQuery("select t from Upload t where t.id = :id", Upload.class)
                .setParameter("id", id).getSingleResultOrNull();
        transaction.commit();
        session.close();
        return id1;
    }

    @Override
    public List<Upload> findAll() {
        Session session = HibernateConfigurer.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        List<Upload> list = session.createQuery("select t from Upload t", Upload.class).getResultList();
        transaction.commit();
        session.close();
        return list;
    }
}
