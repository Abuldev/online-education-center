package uz.team.sabredu.service;

import uz.team.sabredu.dao.MaterialDao;
import uz.team.sabredu.domains.Material;

import java.util.List;

public class MaterialService extends Service<MaterialDao>{
    public MaterialService(MaterialDao dao) {
        super(dao);
    }

    public Material persist(Material material){
        return dao.persist(material);
    }

    public void delete(Long id){
        dao.delete(id);
    }

    public void update(Material material){
        dao.update(material);
    }

    public Material findOne(Long id){
        return dao.findOne(id);
    }

    public List<Material> findAll(){
        return findAll();
    }
}
