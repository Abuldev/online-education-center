package uz.team.sabredu.domains.auth;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Setter
@Getter
public class Address {
    private String region;
    private String city;
}
