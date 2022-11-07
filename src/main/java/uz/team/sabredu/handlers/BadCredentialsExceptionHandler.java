package uz.team.sabredu.handlers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/400")
public class BadCredentialsExceptionHandler extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Throwable throwable = (Throwable) req.getAttribute("javax.servlet.error.exception");
        String message = throwable.getMessage();
        req.setAttribute("message", message);
        req.getRequestDispatcher("/views/error/400.jsp").forward(req, resp);
    }
}
