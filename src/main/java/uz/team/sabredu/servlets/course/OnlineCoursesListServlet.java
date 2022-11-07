package uz.team.sabredu.servlets.course;
import uz.team.sabredu.container.ApplicationContext;
import uz.team.sabredu.dao.CourseDao;
import uz.team.sabredu.domains.Course;
import uz.team.sabredu.service.CourseService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/online/courses")
public class OnlineCoursesListServlet extends HttpServlet {

    CourseDao courseDao = ApplicationContext.getBean(CourseDao.class);
    CourseService courseService = ApplicationContext.getBean(CourseService.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Course> all = courseService.findAll();
        req.setAttribute("courses", all);
        RequestDispatcher dp = req.getRequestDispatcher("/views/course/online_courses.jsp");
        dp.forward(req, resp);
    }

}
