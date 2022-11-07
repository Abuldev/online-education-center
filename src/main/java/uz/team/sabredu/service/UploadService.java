package uz.team.sabredu.service;

import uz.team.sabredu.dao.UploadDao;
import uz.team.sabredu.domains.Upload;

import java.util.List;

public class UploadService extends Service<UploadDao> {
    public UploadService(UploadDao dao) {
        super(dao);
    }

    public Upload persist(Upload upload) {
        return dao.persist(upload);
    }

    public void delete(Long id) {
        dao.delete(id);
    }

    public void update(Upload upload) {
        dao.update(upload);
    }

    public Upload findOne(Long id) {
        return dao.findOne(id);
    }

    public List<Upload> findAll() {
        return dao.findAll();
    }
}
