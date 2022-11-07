package uz.team.sabredu.filters.book;

import org.apache.commons.lang3.StringUtils;
import uz.team.sabredu.exceptions.BadRequestException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@WebFilter(value = "/books/add")
public class BookCreateFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String method = ((HttpServletRequest) request).getMethod();
        if ("POST".equalsIgnoreCase(method)) {
            String name = request.getParameter("name");
            String author = request.getParameter("author");
            String pageCountAsString = request.getParameter("pageCount");

            if (StringUtils.isBlank(name))
                throw new BadRequestException("Name can not be null");

            if (StringUtils.isBlank(author))
                throw new BadRequestException("Name can not be null");

            if (!StringUtils.isNumeric(pageCountAsString))
                throw new BadRequestException("Invalid input for page count");
        }
        chain.doFilter(request, response);
    }
}
