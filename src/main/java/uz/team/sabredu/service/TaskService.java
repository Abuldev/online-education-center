package uz.team.sabredu.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import uz.team.sabredu.dao.TaskDao;
import uz.team.sabredu.domains.Task;
import uz.team.sabredu.domains.Upload;

import java.util.List;


public class TaskService extends Service<TaskDao> {
    public TaskService(TaskDao dao) {
        super(dao);
    }

    public Task persist(Task task) {
        return dao.persist(task);
    }

    public void delete(Long id) {
        dao.delete(id);
    }

    public void update(Task task) {
        dao.update(task);
    }

    public Task findOne(Long id) {
        return dao.findOne(id);
    }

    public List<Task> findAll() {
        return dao.findAll();
    }


}
