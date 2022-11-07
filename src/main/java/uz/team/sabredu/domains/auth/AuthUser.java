package uz.team.sabredu.domains.auth;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import uz.team.sabredu.domains.Course;
import uz.team.sabredu.domains.Domain;
import uz.team.sabredu.domains.Upload;
import uz.team.sabredu.domains.enums.Gender;
import uz.team.sabredu.domains.enums.Role;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Entity
@ToString
public class AuthUser implements Domain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Fullname fullname;

    @Embedded
    private Login login;


    private LocalDate birthday;

    @Embedded
    private Address address;

    private Gender gender;

    @Column(unique = true)
    private String email;

    @Builder.Default
    @Enumerated(value = EnumType.STRING)
    private Role role = Role.STUDENT;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToOne
    private Upload image;

    @Column(columnDefinition = "bool default false")
    private boolean deleted;

    @Column(columnDefinition = "bool default false")
    private boolean active;

    @OneToMany(mappedBy = "teacher", fetch = FetchType.EAGER)
    private List<Course> teacher_courses;

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(
            name = "Student_courses",
            joinColumns = { @JoinColumn(name = "authstudent_id") },
            inverseJoinColumns = { @JoinColumn(name = "course_id") }
    )
    List<Course> courseSet = new ArrayList<>();

}
