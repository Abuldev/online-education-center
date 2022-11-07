package uz.team.sabredu.dto.task;

import lombok.*;
import uz.team.sabredu.domains.Task;
import uz.team.sabredu.domains.Upload;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class TaskDTO {

    private String name;

    private Upload file;


    public static Task toDomain(Upload uploadedFile) {
            return Task.builder()
                    .name(uploadedFile.getOriginalName())
                    .file(uploadedFile)
                    .build();
    }
}
