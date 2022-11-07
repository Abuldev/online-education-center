package uz.team.sabredu.servlets.profile.teacher;

import uz.team.sabredu.container.ApplicationContext;
import uz.team.sabredu.domains.Lesson;
import uz.team.sabredu.service.LessonService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/lessons/add")
@MultipartConfig
public class AddLessonServlet extends HttpServlet {

    private final LessonService lessonService = ApplicationContext.getBean(LessonService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dp = req.getRequestDispatcher("/views/book/add.jsp");
        dp.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        System.out.println("name = " + name);
        String courseid = req.getParameter("courseid");
        System.out.println("courseid = " + courseid);
        lessonService.create(req);
        resp.sendRedirect("/course/lessons?courseid="+courseid);
    }

}
