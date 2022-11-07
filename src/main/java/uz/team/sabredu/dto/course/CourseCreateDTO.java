package uz.team.sabredu.dto.course;


import lombok.*;
import uz.team.sabredu.domains.auth.AuthUser;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@ToString
public class CourseCreateDTO {
        private String name;
        private AuthUser teacher;
        private Long price;
        private int discount;



}
