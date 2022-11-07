package uz.team.sabredu.domains;

import jakarta.persistence.*;
import lombok.*;
import uz.team.sabredu.domains.answer.Answer;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Entity
@ToString

public class Task implements Domain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne
    private Upload file;

    @OneToMany(mappedBy = "task", fetch = FetchType.EAGER)
    private List<Answer> answers;

}
