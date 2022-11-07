package uz.team.sabredu.domains;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import uz.team.sabredu.domains.auth.AuthUser;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Entity
public class Course implements Domain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(targetEntity = AuthUser.class)
    private AuthUser teacher;

    @Column(nullable = false)
    private Long price;

    private int discount;

    private int num_lessons;

    @ManyToMany(mappedBy = "courseSet", fetch = FetchType.EAGER)
    private Set<AuthUser> students = new HashSet<>();

    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
    private List<Lesson> lessons;

    @Column(columnDefinition = "bool default false")
    private boolean deleted;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
