package uz.team.sabredu.servlets;

import uz.team.sabredu.configs.ThreadPoolExecutorConfig;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;


public class HomeServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        ThreadPoolExecutorConfig.run();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dp = req.getRequestDispatcher("views/main.jsp");
        boolean loggedIn = Objects.isNull(req.getSession().getAttribute("current_user"));
        req.setAttribute("loggedIn", loggedIn);
        dp.forward(req, resp);
    }


    @Override
    public void destroy() {
        // ThreadPoolExecutorConfig.shutDown();
    }
}
