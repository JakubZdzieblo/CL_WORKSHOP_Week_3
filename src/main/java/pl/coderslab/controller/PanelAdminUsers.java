package pl.coderslab.controller;

import pl.coderslab.model.User;
import pl.coderslab.model.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin-users")
public class PanelAdminUsers extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<User> users = UserDao.loadAll();

        req.setAttribute("users", users);

        req.getRequestDispatcher("WEB-INF/views/panel_admin_users.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        int id = Integer.parseInt(req.getParameter("id"));
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        int groupid = Integer.parseInt(req.getParameter("groupid"));

        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setUserGroupId(groupid);

        UserDao.save(user);

        resp.sendRedirect("/admin");


    }
}
