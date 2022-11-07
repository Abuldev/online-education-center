package uz.team.sabredu.servlets.profile;

import uz.team.sabredu.container.ApplicationContext;
import uz.team.sabredu.domains.Course;
import uz.team.sabredu.domains.auth.AuthUser;
import uz.team.sabredu.domains.enums.Role;
import uz.team.sabredu.service.AuthUserService;
import uz.team.sabredu.service.CourseService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/enter/course")
public class EnterCourseServlet extends HttpServlet {

    AuthUserService authUserService = ApplicationContext.getBean(AuthUserService.class);
    CourseService courseService = ApplicationContext.getBean(CourseService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long courseid = Long.valueOf(req.getParameter("courseid"));
        System.out.println("courseid = " + courseid);
        Course byID = courseService.findByID(courseid);
        System.out.println("byID.getName() = " + byID.getName());
        req.setAttribute("course", byID);
        req.setAttribute("num_of_lessons", byID.getLessons().size());
        HttpSession session = req.getSession();
        Long current_user = (Long) session.getAttribute("current_user");
        AuthUser user = authUserService.findByID(current_user);
        String path = "";

        if (user.getRole() == Role.STUDENT){
            path = "/views/student/course/student_course_page.jsp";
        } else if (user.getRole() == Role.TEACHER){
            path = "/views/teacher/course/teacher_course_page.jsp";
        } else {
            path = "/views/admin/course/admin_course_page.jsp";
        }

        RequestDispatcher dp = req.getRequestDispatcher(path);
        dp.forward(req, resp);

    }
}

