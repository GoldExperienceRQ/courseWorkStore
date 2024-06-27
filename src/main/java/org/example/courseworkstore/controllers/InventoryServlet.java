package org.example.courseworkstore.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.courseworkstore.dao.GoodDao;
import org.example.courseworkstore.entities.Good;

import java.io.IOException;

@WebServlet(name = "InventoryServlet", value = "/store/inventory")
public class InventoryServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        GoodDao goodDao = new GoodDao();
        req.setAttribute("goods", goodDao.getAll());
        req.getRequestDispatcher("/WEB-INF/pages/inventory.jsp").forward(req, res);
    }
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doPatch(req, res);

    }

    public void doPatch(HttpServletRequest req, HttpServletResponse res) throws IOException {
        GoodDao goodDao = new GoodDao();
        String operation = req.getParameter("operation");
        Good good = goodDao.read(req.getParameter("good"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        int newQuantity = 0;
        if (operation.equals("supply")){
            newQuantity = good.getQuantity() + quantity;
        }
        else if (operation.equals("write-off")){
            newQuantity = good.getQuantity() - quantity;
        }

        if(newQuantity > 0 && newQuantity <= 1000000){
            goodDao.patchQuantity(good.getName(), newQuantity);
            res.sendRedirect("/store/inventory");
        }
        else{
            System.out.println("Invalid quantity");
            res.sendRedirect("/store/inventory");
        }
    }
}
