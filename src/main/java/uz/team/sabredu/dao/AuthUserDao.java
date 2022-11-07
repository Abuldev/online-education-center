package uz.team.sabredu.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import uz.team.sabredu.configs.HibernateConfigurer;
import uz.team.sabredu.domains.auth.AuthUser;

import java.util.List;
import java.util.Optional;

public class AuthUserDao implements Dao<AuthUser> {
    @Override
    public AuthUser persist(AuthUser authUser) {
        Session session = HibernateConfigurer.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.persist(authUser);
        transaction.commit();
        session.close();
        return authUser;
    }

    @Override
    public void delete(Long id) {
        Session session = HibernateConfigurer.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        Query<AuthUser> id1 = session.createQuery("update AuthUser set deleted = true where id = :id", AuthUser.class)
                .setParameter("id", id);
        id1.executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public void update(AuthUser authUser) {
        Session session = HibernateConfigurer.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.merge(authUser);
        transaction.commit();
        session.close();
    }

    @Override
    public AuthUser findOne(Long id) {
        Session session = HibernateConfigurer.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        AuthUser id1 = session.createQuery("select t from AuthUser t where t.id = :id", AuthUser.class)
                .setParameter("id", id).getSingleResultOrNull();
        transaction.commit();
        session.close();
        return id1;
    }

    @Override
    public List<AuthUser> findAll() {
        Session session = HibernateConfigurer.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        List<AuthUser> select_t_from_authUser_t = session.createQuery("select t from AuthUser t", AuthUser.class).getResultList();
        transaction.commit();
        session.close();
        return select_t_from_authUser_t;
    }

    public Optional<AuthUser> findByUsername(String l_phone) {
        Session session = HibernateConfigurer.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        Optional<AuthUser> l_phone1 = Optional.ofNullable(session.createQuery("select t from AuthUser t where t.login.phone_number = :l_phone", AuthUser.class)
                .setParameter("l_phone", l_phone).getSingleResultOrNull());
        transaction.commit();
        session.close();
        return l_phone1;
    }

    public List<AuthUser> findTeachers() {
        Session session = HibernateConfigurer.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        List<AuthUser> resultList = session.createQuery("select t from AuthUser t where t.role = 'TEACHER' ", AuthUser.class).getResultList();
        transaction.commit();
        session.close();
        return resultList;
    }

    public void buyThisCourse(Long user_id, Long course_id) {
        Session session = HibernateConfigurer.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        NativeQuery<AuthUser> nativeQuery = session.createNativeQuery("insert into student_courses(authstudent_id, course_id) values (:uid,:cid);", AuthUser.class)
                .setParameter("uid", user_id).setParameter("cid", course_id);
        nativeQuery.executeUpdate();
        transaction.commit();
        session.close();
    }
}
