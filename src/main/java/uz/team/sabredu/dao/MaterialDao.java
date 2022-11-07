package uz.team.sabredu.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import uz.team.sabredu.configs.HibernateConfigurer;
import uz.team.sabredu.domains.Lesson;
import uz.team.sabredu.domains.Material;

import java.util.List;

public class MaterialDao implements Dao<Material> {
    @Override
    public Material persist(Material material) {
        Session session = HibernateConfigurer.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.persist(material);
        transaction.commit();
        session.close();
        return material;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Material material) {
        Session session = HibernateConfigurer.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.merge(material);
        transaction.commit();
        session.close();
    }

    @Override
    public Material findOne(Long id) {
        Session session = HibernateConfigurer.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        Material id1 = session.createQuery("select t from Material t where t.id = :id", Material.class)
                .setParameter("id", id).getSingleResultOrNull();
        transaction.commit();
        session.close();
        return id1;
    }

    @Override
    public List<Material> findAll() {
        Session session = HibernateConfigurer.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        List<Material> list = session.createQuery("select t from Material t", Material.class).getResultList();
        transaction.commit();
        session.close();
        return list;
    }
}
