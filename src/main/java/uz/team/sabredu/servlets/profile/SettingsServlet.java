package uz.team.sabredu.servlets.profile;

import uz.team.sabredu.container.ApplicationContext;
import uz.team.sabredu.domains.Course;
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
import java.util.List;

@WebServlet("/profile/settings")
public class SettingsServlet extends HttpServlet {

    AuthUserService authUserService = ApplicationContext.getBean(AuthUserService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println(" get is working");
        System.out.println("firstName = " + req.getParameter("firstName"));
        HttpSession session = req.getSession();
        Long current_user = (Long) session.getAttribute("current_user");
        System.out.println("current_user = " + current_user);
        AuthUser user = authUserService.findByID(current_user);

        String path = "";
        if (user.getRole() == Role.STUDENT){
            path = "/views/student/student_settings.jsp";
            System.out.println("user.getRole() = " + user.getRole());

        } else if (user.getRole() == Role.TEACHER){
            path = "/views/teacher/teacher_settings.jsp";
            System.out.println("user.getRole() = " + user.getRole());

        } else {
            path = "/views/admin/admin_settings.jsp";
        }

        req.setAttribute("user", user);
        RequestDispatcher dp = req.getRequestDispatcher(path);
        dp.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(" post is working ");
        String firstName = req.getParameter("firstName");
        System.out.println("firstName = " + firstName);
        resp.sendRedirect("/auth/login");
    }
}
