package uz.team.sabredu.service;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;
import org.jetbrains.annotations.NotNull;
import uz.team.sabredu.configs.ThreadPoolExecutorConfig;
import uz.team.sabredu.dao.FileStorageDao;
import uz.team.sabredu.domains.Upload;
import uz.team.sabredu.dto.UploadDto;
import uz.team.sabredu.util.Utils;

import javax.servlet.http.Part;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.function.Function;

public class FileStorageService extends Service<FileStorageDao> {

    public static final Path rootPath = Paths.get("/home/muhammadqodir/edu/uploads");


    public FileStorageService(FileStorageDao dao) {
        super(dao);
    }


    public void create(Part file, UploadDto dto) {
        ThreadPoolExecutorConfig.submit(() -> copyFile(file, dto.getGeneratedName()));
    }

    private void copyFile(@NotNull Part is, String filename) {
        try {
            Files.copy(is.getInputStream(), rootPath.resolve(filename), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public Upload create(UploadDto uploadsDTO) {
        Upload uploads = toDomain.apply(uploadsDTO);
        dao.persist(uploads);
        return uploads;
    }


    private final Function<UploadDto, Upload> toDomain = Upload::toDomain;


}
