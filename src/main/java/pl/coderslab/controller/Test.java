package pl.coderslab.controller;

import pl.coderslab.model.SolutionDao;
import pl.coderslab.model.UserGroup;
import pl.coderslab.model.UserGroupDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/test")
public class Test extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<UserGroup> userGroups = UserGroupDao.loadAll();

        for (UserGroup ug : userGroups) {
            resp.getWriter().println(ug);
        }

    }
}
