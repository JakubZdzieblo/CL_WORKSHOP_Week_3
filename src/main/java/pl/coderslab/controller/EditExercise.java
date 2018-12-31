package pl.coderslab.controller;

import pl.coderslab.model.Exercise;
import pl.coderslab.model.ExerciseDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit-exercise")
public class EditExercise extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        Exercise exercise = new Exercise();

        if (id!=0) {
            exercise = ExerciseDao.getByIndex(id);
        } else {
            exercise.setId(0);
            exercise.setTitle("new exercise");
        }

        req.setAttribute("exercise", exercise);

        req.getRequestDispatcher("WEB-INF/views/panel_admin_edit_exercise.jsp").forward(req, resp);
    }
}
