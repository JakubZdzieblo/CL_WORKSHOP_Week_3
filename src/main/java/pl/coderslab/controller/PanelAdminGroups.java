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

@WebServlet("/admin-groups")
public class PanelAdminGroups extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<UserGroup> userGroups = UserGroupDao.loadAll();

        req.setAttribute("groups", userGroups);

        req.getRequestDispatcher("WEB-INF/views/panel_admin_groups.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserGroup group = new UserGroup(0,"");
        String groupname = req.getParameter("groupname");
        int id = Integer.parseInt(req.getParameter("id"));

        if (id != 0) {
            group = UserGroupDao.getById(id);
        }

        group.setName(groupname);

        UserGroupDao.save(group);

        resp.sendRedirect("/admin");

    }
}
