package uz.team.sabredu.servlets.course;

import uz.team.sabredu.container.ApplicationContext;
import uz.team.sabredu.domains.Course;
import uz.team.sabredu.domains.Lesson;
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

@WebServlet("/buy")
public class BuyCourseServlet extends HttpServlet {

    CourseService courseService = ApplicationContext.getBean(CourseService.class);
    AuthUserService authUserService = ApplicationContext.getBean(AuthUserService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Long course_id = Long.valueOf(req.getParameter("courseid"));
        Course course = courseService.findByID(course_id);


        HttpSession session = req.getSession();
        Long current_user = (Long) session.getAttribute("current_user");
        AuthUser user = authUserService.findByID(current_user);
        authUserService.buyThisCourse(user,course);

        String path = "";

        List<Course> courses = new ArrayList<>();

        if (user.getRole() == Role.STUDENT){
            path = "/views/student/course/student_courses.jsp";
            System.out.println("user.getRole() = " + user.getRole());
            courses = user.getCourseSet();

        } else if (user.getRole() == Role.TEACHER){
            path = "/views/teacher/course/teacher_courses.jsp";
            System.out.println("user.getRole() = " + user.getRole());
            courses = user.getTeacher_courses();
        } else {
            path = "/views/admin/course/admin_courses.jsp";
        }

        req.setAttribute("courses", courses);
        req.setAttribute("num_of_lessons", courses.size());
        RequestDispatcher dp = req.getRequestDispatcher(path);
        dp.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Long course_id = Long.valueOf(req.getParameter("courseid"));
        Course course = courseService.findByID(course_id);

        HttpSession session = req.getSession();
        Long current_user = (Long) session.getAttribute("current_user");
        AuthUser user = authUserService.findByID(current_user);
        authUserService.buyThisCourse(user,course);

        String path = "";

        List<Course> courses = new ArrayList<>();

        if (user.getRole() == Role.STUDENT){
            path = "/views/student/course/student_courses.jsp";
            System.out.println("user.getRole() = " + user.getRole());
            courses = user.getCourseSet();

        } else if (user.getRole() == Role.TEACHER){
            path = "/views/teacher/course/teacher_courses.jsp";
            System.out.println("user.getRole() = " + user.getRole());
            courses = user.getTeacher_courses();
        } else {
            path = "/views/admin/course/admin_courses.jsp";
        }

        req.setAttribute("courses", courses);
        req.setAttribute("num_of_lessons", courses.size());
        RequestDispatcher dp = req.getRequestDispatcher(path);
        dp.forward(req, resp);
    }


}
