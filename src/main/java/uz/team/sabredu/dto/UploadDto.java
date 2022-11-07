package uz.team.sabredu.dto;

import lombok.*;
import uz.team.sabredu.util.Utils;

import javax.servlet.http.Part;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UploadDto {

    private String originalName;
    private String generatedName;
    private String contentType;
    private long size;
    private long bookId;


    public static UploadDto toDTO(Part part) {
        return UploadDto.builder()
                .originalName(part.getSubmittedFileName())
                .contentType(part.getContentType())
                .size(part.getSize())
                .generatedName(Utils.generateUniqueFileName())
                .build();
    }

}
