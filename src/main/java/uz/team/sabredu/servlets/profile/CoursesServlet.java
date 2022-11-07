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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/profile/my_courses")
public class CoursesServlet extends HttpServlet {
    CourseService courseService = ApplicationContext.getBean(CourseService.class);
    AuthUserService authUserService = ApplicationContext.getBean(AuthUserService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        Long current_user = (Long) session.getAttribute("current_user");
        System.out.println("current_user = " + current_user);

        AuthUser user = authUserService.findByID(current_user);
        String path = "";

        List<Course> courses = new ArrayList<>();

        if (user.getRole() == Role.STUDENT){
            path = "/views/student/course/student_courses.jsp";
            System.out.println("user.getRole() = " + user.getRole());
            courses = courseService.getUserCourses(user);

        } else if (user.getRole() == Role.TEACHER){
            path = "/views/teacher/course/teacher_courses.jsp";
            System.out.println("user.getRole() = " + user.getRole());
            courses = courseService.getTeacherCourses(user);

        } else {
            path = "/views/admin/course/admin_courses.jsp";
        }

        req.setAttribute("courses", courses);
        req.setAttribute("num_of_lessons", courses.size());
        RequestDispatcher dp = req.getRequestDispatcher(path);
        dp.forward(req, resp);

    }
}

