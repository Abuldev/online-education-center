package uz.team.sabredu.dao;

import uz.team.sabredu.domains.Domain;

import java.util.List;

public interface Dao<D extends Domain> {

    D persist(D d);
    void delete(Long id);
    void update(D d);
    D findOne(Long id);
    List<D> findAll();

}
