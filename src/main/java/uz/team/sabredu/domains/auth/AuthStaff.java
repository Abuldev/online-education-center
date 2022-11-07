package uz.team.sabredu.domains.auth;//package uz.team.sabredu.domains.auth;
//
//import jakarta.persistence.*;
//import lombok.*;
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
//import uz.team.sabredu.domains.Course;
//import uz.team.sabredu.domains.Domain;
//import uz.team.sabredu.domains.enums.Gender;
//import uz.team.sabredu.domains.enums.Role;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//@Getter
//@Setter
//@Entity
//public class AuthStaff implements Domain {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Embedded
//    private Fullname fullname;
//
//    @Embedded
//    private Login login;
//
//    @Embedded
//    private Address address;
//
//    private Gender gender;
//
//    @Column(unique = true)
//    private String email;
//
//    @Enumerated(value = EnumType.STRING)
//    private Role role;
//
//    @CreationTimestamp
//    private LocalDateTime createdAt;
//
//    @UpdateTimestamp
//    private LocalDateTime updatedAt;
//
////    @Column(columnDefinition = "set default false")
//    private boolean deleted;
//
////    @Column(columnDefinition = "set default false")
//    private boolean active;
//
//    @OneToMany(mappedBy = "teacher")
//    private List<Course> teacher_courses;
//
//}
