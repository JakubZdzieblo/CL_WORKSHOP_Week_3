package pl.coderslab.controller;

import pl.coderslab.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/show-solution")
public class ShowSolution extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int sol_id = Integer.parseInt(req.getParameter("id"));
        Solution solution = SolutionDao.getById(sol_id);

        req.setAttribute("solution", solution);

        User user = UserDao.getById(solution.getUserId());

        req.setAttribute("user", user);

        Exercise exercise = ExerciseDao.getByIndex(solution.getExerciseId());

        req.setAttribute("exercise", exercise);

        req.getRequestDispatcher("/WEB-INF/views/show_solution.jsp").forward(req, resp);

    }
}
