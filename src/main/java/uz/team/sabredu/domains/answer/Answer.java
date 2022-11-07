package uz.team.sabredu.domains.answer;

import jakarta.persistence.*;
import lombok.*;
import uz.team.sabredu.domains.Domain;
import uz.team.sabredu.domains.Task;
import uz.team.sabredu.domains.Upload;
import uz.team.sabredu.domains.auth.AuthUser;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Entity
@ToString

public class Answer implements Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Upload file;

    @ManyToOne(targetEntity = AuthUser.class)
    private AuthUser student;

    @ManyToOne(targetEntity = Task.class)
    private Task task;

}
