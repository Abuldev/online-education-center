package uz.team.sabredu.servlets.profile.student;

import uz.team.sabredu.container.ApplicationContext;
import uz.team.sabredu.dao.TaskDao;
import uz.team.sabredu.domains.auth.AuthUser;
import uz.team.sabredu.dto.answer.AnswerCreateDTO;
import uz.team.sabredu.service.AnswerService;
import uz.team.sabredu.service.AuthUserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/answer/add")
@MultipartConfig
public class AnswerAddServlet extends HttpServlet {

    AnswerService answerService = ApplicationContext.getBean(AnswerService.class);
    AuthUserService authUserService = ApplicationContext.getBean(AuthUserService.class);

    TaskDao taskDao = ApplicationContext.getBean(TaskDao.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Long current_user = (Long) session.getAttribute("current_user");
        AuthUser user = authUserService.findByID(current_user);

        Long task_id = Long.valueOf(req.getParameter("taskid"));

        AnswerCreateDTO build = AnswerCreateDTO.builder()
                .student(user)
                .task(taskDao.findOne(task_id))
                .build();
        Part answer = req.getPart("answer");
        answerService.create(answer,build);
        RequestDispatcher dp = req.getRequestDispatcher("/enter/lesson");
        dp.forward(req, resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        Long current_user = (Long) session.getAttribute("current_user");
        AuthUser user = authUserService.findByID(current_user);

        Long task_id = Long.valueOf(req.getParameter("taskid"));

        AnswerCreateDTO build = AnswerCreateDTO.builder()
                .student(user)
                .task(taskDao.findOne(task_id))
                .build();
        Part answer = req.getPart("answer");
        answerService.create(answer,build);

        RequestDispatcher dp = req.getRequestDispatcher("/enter/lesson");
        dp.forward(req, resp);
    }



}
