package uz.team.sabredu.servlets.auth;

import uz.team.sabredu.container.ApplicationContext;
import uz.team.sabredu.service.AuthUserService;
import uz.team.sabredu.util.Utils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(value = "/auth/register")
public class AuthUserRegisterServlet extends HttpServlet {



    AuthUserService authUserService = ApplicationContext.getBean(AuthUserService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        for (int i = 0; i < 14; i++) {
            Utils.cities.put(Utils.regions.get(i), List.of(
                    "Andijan", "Asaka", "Baliqchi", "Boʻston", "Buloqboshi", "Izboskan", "Jalaquduq",
                    "Xoʻjaobod", "Qoʻrgʻontepa", "Marhamat", "Oltinkoʻl", "Paxtaobod", "Shahrixon", "Ulugnor" ));
        }

        req.setAttribute("regions", Utils.regions);
        req.setAttribute("cities", Utils.cities.get(1));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/auth/register.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        authUserService.create(req);
        resp.sendRedirect("/auth/login");
    }
}
