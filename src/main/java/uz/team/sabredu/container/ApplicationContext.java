package uz.team.sabredu.container;


import uz.team.sabredu.dao.*;
import uz.team.sabredu.service.*;

public class ApplicationContext {

    private static final CourseDao courseDao =  new CourseDao();
    private static final CourseService courseService = new CourseService(courseDao);
    private static final FileStorageDao fileStorageDao = new FileStorageDao();
    private static final FileStorageService fileStorageService = new FileStorageService(fileStorageDao);
    private static final AuthUserDao authUserDao =  new AuthUserDao();
    private static final AuthUserService authUserService =  new AuthUserService(authUserDao);
    private static final TaskDao taskDao =  new TaskDao();
    private static final TaskService taskService =  new TaskService(taskDao);
    private static final LessonDao lessonDao =  new LessonDao();
    private static final LessonService lessonService =  new LessonService(lessonDao);
    private static final AnswerDao answerDao =  new AnswerDao();
    private static final AnswerService answerService =  new AnswerService(answerDao);

    @SuppressWarnings("raw_types")
    public static <T> T getBean(Class<T> clazz) {
        return switch (clazz.getSimpleName()) {
            case "CourseDao" -> (T) courseDao;
            case "CourseService" -> (T) courseService;
            case "FileStorageService" -> (T) fileStorageService;
            case "FileStorageDao" -> (T) fileStorageDao;
            case "AuthUserDao" -> (T) authUserDao;
            case "AuthUserService" -> (T) authUserService;
            case "LessonService" -> (T) lessonService;
            case "LessonDao" -> (T) lessonDao;
            case "TaskService" -> (T) taskService;
            case "TaskDao" -> (T) taskDao;
            case "AnswerService" -> (T) answerService;
            case "AnswerDao" -> (T) answerDao;
            default -> throw new RuntimeException("Bean not found");
        };
    }
}
