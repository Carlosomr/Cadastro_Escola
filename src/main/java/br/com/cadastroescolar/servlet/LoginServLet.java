package br.com.cadastroescolar.servlet;

import br.com.cadastroescolar.dao.UserDao;
import br.com.cadastroescolar.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/login")
public class LoginServLet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("login.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = new User(username, password);

        boolean isValidUser = new UserDao().verifyCredentials(user);

        if (isValidUser) {

            req.getSession().setAttribute("loggedUser", username);

            resp.sendRedirect("/find-all-cars");

        } else {

            req.setAttribute("message", "login Invalido");

            req.getRequestDispatcher("login.jsp").forward(req, resp);

        }

    }
}
