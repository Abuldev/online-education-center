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

@WebServlet("/auth/login")
public class AuthenticationServlet extends HttpServlet {

    AuthUserService authUserService = ApplicationContext.getBean(AuthUserService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/auth/login.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String l_phone = req.getParameter("l_phone");
        String l_password = req.getParameter("l_password");
        AuthUser authUser = authUserService.login(l_phone, l_password);
        HttpSession session = req.getSession();
        session.setAttribute("current_user", authUser.getId());
        resp.sendRedirect("/");
    }
}
