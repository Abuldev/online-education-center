package uz.team.sabredu.servlets.auth;

import uz.team.sabredu.container.ApplicationContext;
import uz.team.sabredu.domains.auth.AuthUser;
import uz.team.sabredu.domains.enums.Role;
import uz.team.sabredu.service.AuthUserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/my_cabinet")
public class MyCabinetServlet extends HttpServlet {

    AuthUserService authUserService = ApplicationContext.getBean(AuthUserService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        Long current_user = (Long) session.getAttribute("current_user");

        AuthUser byID = authUserService.findByID(current_user);

        RequestDispatcher dispatcher;
        System.out.println("byID.getRole() = " + byID.getRole());

        req.setAttribute("user",byID);

        if (byID.getRole().name().equals(Role.STUDENT.name())){
             dispatcher = req.getRequestDispatcher("/views/student/student_cabinet.jsp");
            req.setAttribute("courses",byID.getCourseSet());
        } else if (byID.getRole().name().equals(Role.TEACHER.name())){
            dispatcher = req.getRequestDispatcher("/views/teacher/teacher_cabinet.jsp");
            req.setAttribute("courses",byID.getTeacher_courses());
        } else {
            dispatcher = req.getRequestDispatcher("/views/auth/admin_cabinet.jsp");
        }
        dispatcher.forward(req, resp);
    }

}
