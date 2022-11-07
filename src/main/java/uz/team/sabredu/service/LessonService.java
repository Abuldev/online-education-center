package uz.team.sabredu.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import uz.team.sabredu.configs.HibernateConfigurer;
import uz.team.sabredu.container.ApplicationContext;
import uz.team.sabredu.dao.LessonDao;
import uz.team.sabredu.dao.TaskDao;
import uz.team.sabredu.dao.UploadDao;
import uz.team.sabredu.domains.Lesson;
import uz.team.sabredu.domains.Task;
import uz.team.sabredu.domains.Upload;
import uz.team.sabredu.dto.UploadDto;
import uz.team.sabredu.dto.lesson.LessonCreateDTO;
import uz.team.sabredu.dto.task.TaskDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.awt.print.Book;
import java.io.IOException;
import java.util.function.Function;

public class LessonService extends Service<LessonDao> {

    private final static TaskDao taskDao = ApplicationContext.getBean(TaskDao.class);

    public LessonService(LessonDao dao) {
        super(dao);
    }
    private final static FileStorageService fileStorageService = ApplicationContext.getBean(FileStorageService.class);
    public Lesson findByID(Long lessonid) {
        return dao.findOne(lessonid);
    }

    public void delete(Long id) {
        dao.delete(id);
    }

    public void create(HttpServletRequest req) throws ServletException, IOException {

        Part file = req.getPart("task");
        LessonCreateDTO lessonDto = toDTO.apply(req);
        UploadDto uploadsDTO = toUploadsDTO.apply(file);
        Lesson lesson = toLessonDomain.apply(lessonDto);
        fileStorageService.create(file, uploadsDTO);
        Upload uploadedFile = fileStorageService.create(uploadsDTO);
        Task task = TaskDTO.toDomain(uploadedFile);
        Task persist = taskDao.persist(task);
        lesson.setTask(persist);
        dao.persist(lesson);
        System.out.println("file = " + file);
        System.out.println("uploadsDTO.getGeneratedName() = " + uploadsDTO.getGeneratedName());

    }


    private static final Function<HttpServletRequest, LessonCreateDTO> toDTO = LessonCreateDTO::toDTO;
    private static final Function<LessonCreateDTO, Lesson> toLessonDomain = LessonCreateDTO::toDomain;
    private static final Function<Part, UploadDto> toUploadsDTO = UploadDto::toDTO;


}
