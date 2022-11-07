package uz.team.sabredu.servlets.storage;


import uz.team.sabredu.dao.UploadDao;
import uz.team.sabredu.domains.Upload;
import uz.team.sabredu.exceptions.BadRequestException;
import uz.team.sabredu.service.FileStorageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;

@WebServlet("/download")
public class FileDownloadServlet extends HttpServlet {

    private final static UploadDao uploadDao = new UploadDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filename = req.getParameter("filename");
        Upload upload = uploadDao.findByGeneratedName(filename).orElseThrow(() -> {
            throw new BadRequestException("File not found");
        });
        Path resolvedPath = FileStorageService.rootPath.resolve(filename);
        resp.setContentType(upload.getContentType());
        FileInputStream fileInputStream = new FileInputStream(resolvedPath.toString());
        byte[] bytes = fileInputStream.readAllBytes();
        resp.getOutputStream().write(bytes);

    }
}
