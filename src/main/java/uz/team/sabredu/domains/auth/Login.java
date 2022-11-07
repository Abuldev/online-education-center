package uz.team.sabredu.domains.auth;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Login {

    @Column(unique = true)
    private String phone_number;

    @Column(nullable = false)
    private String password;
}