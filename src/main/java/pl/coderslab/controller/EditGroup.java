package pl.coderslab.controller;

import pl.coderslab.model.User;
import pl.coderslab.model.UserGroup;
import pl.coderslab.model.UserGroupDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit-group")
public class EditGroup extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        String name = "";
        if ( id != 0) {
            name = UserGroupDao.getById(id).getName();
        }
        req.setAttribute("id", id);
        req.setAttribute("name", name);

        req.getRequestDispatcher("WEB-INF/views/panel_admin_edit_group.jsp").forward(req, resp);

    }
}
