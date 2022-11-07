package uz.team.sabredu.dto.answer;

import jakarta.persistence.ManyToOne;
import lombok.*;
import uz.team.sabredu.domains.Lesson;
import uz.team.sabredu.domains.Task;
import uz.team.sabredu.domains.Upload;
import uz.team.sabredu.domains.answer.Answer;
import uz.team.sabredu.domains.auth.AuthUser;
import uz.team.sabredu.dto.lesson.LessonCreateDTO;

import javax.servlet.http.HttpServletRequest;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AnswerCreateDTO {

    private Upload file;

    private AuthUser student;

    private Task task;

}
