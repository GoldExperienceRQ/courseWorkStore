package org.example.courseworkstore.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.*;
import org.example.courseworkstore.dao.GoodDao;

import java.io.IOException;

@WebServlet(name = "AllGoodsServlet", value = "/store/allGoods")
public class AllGoodsServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        GoodDao goodDao = new GoodDao();
        req.setAttribute("goods", goodDao.getAll());

        req.getRequestDispatcher("/WEB-INF/pages/allGoods.jsp").forward(req, res);

    }
}
