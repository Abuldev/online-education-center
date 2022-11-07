package uz.team.sabredu.dto.lesson;

import lombok.*;
import uz.team.sabredu.container.ApplicationContext;
import uz.team.sabredu.dao.CourseDao;
import uz.team.sabredu.dao.LessonDao;
import uz.team.sabredu.domains.Lesson;
import uz.team.sabredu.domains.Material;
import uz.team.sabredu.domains.Task;
import uz.team.sabredu.domains.Upload;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class LessonCreateDTO {

    private String name;
    private String video;
    private Long course_id;
    private Upload material;
    private String info;
    private Task task;

    public static LessonCreateDTO toDTO(HttpServletRequest request) {
        return LessonCreateDTO.builder()
                .name(request.getParameter("name"))
                .video(request.getParameter("video"))
                .course_id(Long.valueOf(request.getParameter("courseid")))
                .info(request.getParameter("info"))
                .build();
    }

    public  Lesson toDomain() {

        CourseDao courseDao = ApplicationContext.getBean(CourseDao.class);

        return Lesson.builder()
                .name(this.name)
                .course(courseDao.findOne(this.course_id))
                .video(this.video)
                .info(this.info)
                .task(this.task)
                .build();
    }

}
