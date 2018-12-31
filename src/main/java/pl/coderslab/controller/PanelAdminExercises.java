package pl.coderslab.controller;

import pl.coderslab.model.Exercise;
import pl.coderslab.model.ExerciseDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin-exercises")
public class PanelAdminExercises extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Exercise> exercises = ExerciseDao.loadAll();

        req.setAttribute("exercises", exercises);

        req.getRequestDispatcher("WEB-INF/views/panel_admin_exercises.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        String title = req.getParameter("title");
        String description = req.getParameter("description");

        Exercise exercise = new Exercise();

        exercise.setId(id);
        exercise.setTitle(title);
        exercise.setDescription(description);

        ExerciseDao.save(exercise);

        resp.sendRedirect("/admin");


    }
}
