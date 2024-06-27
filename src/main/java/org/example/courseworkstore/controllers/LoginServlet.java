package org.example.courseworkstore.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.courseworkstore.dao.GoodDao;
import org.example.courseworkstore.dao.UserDao;
import org.example.courseworkstore.entities.User;
import org.example.courseworkstore.utils.PasswordUtil;


import java.io.IOException;
import java.security.Key;

@WebServlet(name = "LoginServlet", value = "/store/login")
public class LoginServlet extends HttpServlet {


    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        boolean isValid = isValidLogin(username, password);

        if(isValid){
            User user = new User(username, password);
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            res.sendRedirect("/store");
        } else {
            req.setAttribute("error", "Invalid username or password");
            req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, res);
        }
    }

    private boolean isValidLogin(String username, String password) {

        UserDao userDao = new UserDao();
        User user = userDao.read(username);

        if(user == null){
            return false;
        }

        return PasswordUtil.veifyPassword(password, user.getPassword());
    }
}
