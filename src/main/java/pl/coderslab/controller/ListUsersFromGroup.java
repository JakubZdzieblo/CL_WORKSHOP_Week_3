package pl.coderslab.controller;

import pl.coderslab.model.User;
import pl.coderslab.model.UserDao;
import pl.coderslab.model.UserGroup;
import pl.coderslab.model.UserGroupDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/users-from-groups")
public class ListUsersFromGroup extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        List<User> users = UserDao.loadAllByGroupId(id);
        UserGroup group = UserGroupDao.getById(id);

        req.setAttribute("users", users);
        req.setAttribute("group", group);

        req.getRequestDispatcher("WEB-INF/views/show_users_from_group.jsp").forward(req, resp);

    }
}
