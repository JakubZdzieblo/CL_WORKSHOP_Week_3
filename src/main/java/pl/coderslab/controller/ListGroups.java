package pl.coderslab.controller;

import pl.coderslab.model.UserGroup;
import pl.coderslab.model.UserGroupDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/listgroups")
public class ListGroups extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<UserGroup> userGroups = UserGroupDao.loadAll();

        req.setAttribute("userGroups", userGroups);

        req.getRequestDispatcher("WEB-INF/views/show_groups.jsp").forward(req, resp);

    }
}
