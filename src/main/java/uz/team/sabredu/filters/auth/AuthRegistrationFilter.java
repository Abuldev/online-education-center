package uz.team.sabredu.filters.auth;

import org.apache.commons.lang3.StringUtils;
import uz.team.sabredu.domains.auth.Address;
import uz.team.sabredu.domains.auth.Fullname;
import uz.team.sabredu.domains.auth.Login;
import uz.team.sabredu.exceptions.BadRequestException;
import uz.team.sabredu.util.Utils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Objects;

@WebFilter(value = "/auth/register")
public class AuthRegistrationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        String method = ((HttpServletRequest) servletRequest).getMethod();
        if ("POST".equalsIgnoreCase(method)) {

            String first_name = servletRequest.getParameter("first_name");
            System.out.println("first_name = " + first_name);

            String phone = servletRequest.getParameter("phone");
            System.out.println("phone = " + phone);

            String password = servletRequest.getParameter("password");
            System.out.println("password = " + password);

            String confirm = servletRequest.getParameter("confirm");
            System.out.println("confirm = " + confirm);

            if (StringUtils.isBlank(first_name))
                throw new BadRequestException("First name can not be null");

            if (StringUtils.isBlank(phone))
                throw new BadRequestException("Phone number can not be null");

            Utils.checkForValidNumber(phone);

            if (!StringUtils.isNumeric(password))
                throw new BadRequestException("Password can not be null");

            if (!Objects.equals(password,confirm)) {
                throw new BadRequestException("Passwords not matched");
            }

        }
        filterChain.doFilter(servletRequest,servletResponse);


    }

    @Override
    public void destroy() {
    }
}
