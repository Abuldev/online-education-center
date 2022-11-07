package uz.team.sabredu.domains;

import jakarta.persistence.*;
import lombok.*;
import uz.team.sabredu.dto.UploadDto;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Entity
@ToString
public class Upload implements Domain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String originalName;
    private String generatedName;
    private String contentType;
    private long size;

    public static Upload toDomain(UploadDto dto) {
        return Upload.builder()
                .originalName(dto.getOriginalName())
                .generatedName(dto.getGeneratedName())
                .contentType(dto.getContentType())
                .size(dto.getSize())
                .build();
    }
}
