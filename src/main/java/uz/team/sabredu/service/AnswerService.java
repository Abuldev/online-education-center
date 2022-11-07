package uz.team.sabredu.service;

import uz.team.sabredu.container.ApplicationContext;
import uz.team.sabredu.dao.AnswerDao;
import uz.team.sabredu.domains.Task;
import uz.team.sabredu.domains.Upload;
import uz.team.sabredu.domains.answer.Answer;
import uz.team.sabredu.dto.UploadDto;
import uz.team.sabredu.dto.answer.AnswerCreateDTO;
import uz.team.sabredu.dto.task.TaskDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.function.Function;

public class AnswerService extends Service<AnswerDao>{
    public AnswerService(AnswerDao dao) {
        super(dao);
    }

    private final static FileStorageService fileStorageService = ApplicationContext.getBean(FileStorageService.class);


    public void create(Part file, AnswerCreateDTO createDTO) throws ServletException, IOException {


        UploadDto uploadsDTO = toUploadsDTO.apply(file);


        fileStorageService.create(file, uploadsDTO);
        Upload uploadedFile = fileStorageService.create(uploadsDTO);

        Answer answer = Answer.builder()
                .file(uploadedFile)
                .student(createDTO.getStudent())
                .task(createDTO.getTask())
                .build();

        dao.persist(answer);
        System.out.println("file = " + file);
        System.out.println("uploadsDTO.getGeneratedName() = " + uploadsDTO.getGeneratedName());
    }

    private static final Function<Part, UploadDto> toUploadsDTO = UploadDto::toDTO;



}
