package uz.team.sabredu.dto.auth;

import lombok.*;
import uz.team.sabredu.domains.auth.Address;
import uz.team.sabredu.domains.auth.Fullname;
import uz.team.sabredu.domains.auth.Login;
import uz.team.sabredu.domains.enums.Gender;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@ToString
public class UserUpdateDTO {

        private Long id;
        private Fullname fullname;
        private Login login;
        private Address address;
        private Gender gender;
        private String email;
        private LocalDateTime updatedAt;

}
