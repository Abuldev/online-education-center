package uz.team.sabredu.filters.auth;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

@WebFilter(urlPatterns = "/*")
public class AuthenticationFilter implements Filter {
    public static final List<Object> WHITE_LIST = List.of(
            "/auth/login",
            "/auth/register",
            "/",
            "/aboutus",
            "/offline/courses",
            "/online/courses"
    );

    private final static Predicate<String> isSecured = (path) -> !WHITE_LIST.contains(path);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = ((HttpServletRequest) servletRequest);
        HttpSession session = request.getSession();
        Object userId = session.getAttribute("current_user");
        HttpServletResponse response = ((HttpServletResponse) servletResponse);
        String path = request.getRequestURI();

        if (!isSecured.test(path) || !Objects.isNull(userId)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            response.sendRedirect("/auth/login");
        }
    }
}

