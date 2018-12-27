package pl.coderslab.controller;

import pl.coderslab.model.Solution;
import pl.coderslab.model.SolutionDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class HomePageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Solution> mostRecentSolutions = SolutionDao.loadFirst(5);
        req.setAttribute("solutions", mostRecentSolutions);
        req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);

    }
}
