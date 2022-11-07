package uz.team.sabredu.dto.auth;

import lombok.*;
import uz.team.sabredu.domains.auth.Address;
import uz.team.sabredu.domains.auth.AuthUser;
import uz.team.sabredu.domains.auth.Fullname;
import uz.team.sabredu.domains.auth.Login;
import uz.team.sabredu.domains.enums.Gender;
import uz.team.sabredu.domains.enums.Role;
import uz.team.sabredu.util.Utils;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class RegisterDto {

    private Fullname fullname;
    private Login login;
    private Address address;
    private String confirmPassword;
    private String gender;

    private String birthday;

    private Role role = Role.STUDENT;
    private String email;

    public static RegisterDto toDTO(HttpServletRequest request) {

        Fullname fullname = new Fullname(request.getParameter("first_name"), request.getParameter("last_name"));

        Login login1 = new Login(request.getParameter("phone"), Utils.encodePassword(request.getParameter("password")));

        Address address1 = new Address(request.getParameter("region"), request.getParameter("city"));

        return RegisterDto.builder()
                .fullname(fullname)
                .login(login1)
                .birthday(request.getParameter("birthday"))
                .address(address1)
                .confirmPassword(request.getParameter("confirm"))
                .gender(request.getParameter("gender"))
                .email(request.getParameter("email"))
                .build();
    }

    public AuthUser toDomain() {

        return AuthUser.builder()
                .fullname(this.fullname)
                .login(this.login)
                .birthday(LocalDate.parse(this.birthday, DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .address(this.address)
                .gender(Gender.findByName(this.gender))
                .email(this.email)
                .build();
    }

}
