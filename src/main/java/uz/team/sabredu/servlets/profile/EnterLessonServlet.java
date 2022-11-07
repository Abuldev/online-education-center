package uz.team.sabredu.servlets.profile;

import uz.team.sabredu.container.ApplicationContext;
import uz.team.sabredu.domains.Course;
import uz.team.sabredu.domains.Lesson;
import uz.team.sabredu.domains.auth.AuthUser;
import uz.team.sabredu.domains.enums.Role;
import uz.team.sabredu.service.AuthUserService;
import uz.team.sabredu.service.CourseService;
import uz.team.sabredu.service.LessonService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/enter/lesson")
public class EnterLessonServlet extends HttpServlet {

    AuthUserService authUserService = ApplicationContext.getBean(AuthUserService.class);
    LessonService lessonService = ApplicationContext.getBean(LessonService.class);
    CourseService courseService = ApplicationContext.getBean(CourseService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Long lessonid = Long.valueOf(req.getParameter("lessonid"));
        System.out.println("lessonid = " + lessonid);
        Lesson lesson = lessonService.findByID(lessonid);
        System.out.println("byID.getName() = " + lesson.getName());
        req.setAttribute("lesson", lesson);
        Course course = courseService.findByID(lesson.getCourse().getId());
        req.setAttribute("course", course);

        HttpSession session = req.getSession();
        Long current_user = (Long) session.getAttribute("current_user");
        AuthUser user = authUserService.findByID(current_user);
        String path = "";

        if (user.getRole() == Role.STUDENT){
            path = "/views/student/lesson/student_lesson_page.jsp";
        } else if (user.getRole() == Role.TEACHER){
            req.setAttribute("answers",lesson.getTask().getAnswers());
            path = "/views/teacher/lesson/teacher_lesson_page.jsp";
        } else {
            path = "/views/admin/lesson/admin_lesson_page.jsp";
        }
        RequestDispatcher dp = req.getRequestDispatcher(path);
        dp.forward(req, resp);
    }
}

