package pl.coderslab.controller;

import pl.coderslab.model.Solution;
import pl.coderslab.model.SolutionDao;
import pl.coderslab.model.User;
import pl.coderslab.model.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/show-user")
public class ShowUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        User user = UserDao.getById(id);

        List<Solution> solutions = SolutionDao.loadAllByUserId(id);

        req.setAttribute("user", user);
        req.setAttribute("solutions", solutions);

        req.getRequestDispatcher("WEB-INF/views/show_user.jsp").forward(req, resp);

    }
}
