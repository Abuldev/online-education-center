package uz.team.sabredu.domains;

import jakarta.persistence.*;
import lombok.*;
import uz.team.sabredu.dto.lesson.LessonCreateDTO;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Entity
@ToString
public class Lesson implements Domain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String video;

    @ManyToOne(targetEntity = Course.class)
    private Course course;

    @OneToMany(targetEntity = Upload.class)
    private List<Material> materials;

    private String info;

    @Column(columnDefinition = "bool default false")
    private boolean deleted;

    @OneToOne
    private Task task;


}
