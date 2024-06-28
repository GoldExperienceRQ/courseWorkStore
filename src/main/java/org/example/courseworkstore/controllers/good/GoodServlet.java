package org.example.courseworkstore.controllers.good;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.*;
import org.example.courseworkstore.dao.CategoryDao;
import org.example.courseworkstore.dao.GoodDao;
import org.example.courseworkstore.entities.Good;

import java.io.IOException;

@WebServlet(name = "GoodServlet", value = "/store/category/goods/*")
public class GoodServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        System.out.println("GoodServlet doGet");

        String path = req.getPathInfo();
        String[] parts = path.split("/");

        if (parts.length < 2) {
            // Handle error: the path should have at least two parts
            return;
        }

        String categoryName = parts[1];
        String command = parts.length > 2 ? parts[2] : "";

        if (command.equals("delete")) {
            doDelete(req, res);
        }
        else if (command.equals("update")){
            GoodDao goodDao = new GoodDao();
            req.setAttribute("good", goodDao.read(req.getParameter("good")));
            req.getRequestDispatcher("/WEB-INF/pages/updateGood.jsp").forward(req, res);
        }
        else if (command.equals("add")){
            System.out.println("GoodServlet doGet");
            req.setAttribute("category", categoryName);
            System.out.println(categoryName);
            req.getRequestDispatcher("/WEB-INF/pages/addGood.jsp").forward(req, res);
        }
        else if(command.equals("lookup")){
            GoodDao goodDao = new GoodDao();
            req.setAttribute("category", categoryName);
            req.setAttribute("searchValue", req.getParameter("search"));
            req.setAttribute("goods", goodDao.getBySearchValue(req.getParameter("search"), categoryName));
            req.getRequestDispatcher("/WEB-INF/pages/goodLookup.jsp").forward(req, res);
        }
        else {
            GoodDao goodDao = new GoodDao();
            req.setAttribute("category", categoryName);
            req.setAttribute("goods", goodDao.getByCategory(categoryName));

            req.getRequestDispatcher("/WEB-INF/pages/goods.jsp").forward(req, res);
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        System.out.println("GoodServlet doPost");
        System.out.println(req.getParameter("category"));
        String method = req.getParameter("_method");
        System.out.println("What");


        if (method != null && method.equals("PUT")) {
            doPut(req, res);
        } else {
            GoodDao goodDao = new GoodDao();
            goodDao.create(new Good(req.getParameter("name"), req.getParameter("description"), req.getParameter("producer"), Integer.parseInt(req.getParameter("quantity")), Double.parseDouble(req.getParameter("price")), req.getParameter("category")));
            res.sendRedirect("/store/category/goods/" + req.getParameter("category"));
        }
    }

    public void doPut(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("GoodServlet doPut");
        GoodDao goodDao = new GoodDao();
        Good current = goodDao.read(req.getParameter("name"));
        goodDao.update(new Good(req.getParameter("name"), req.getParameter("description"), req.getParameter("producer"), Integer.parseInt(req.getParameter("quantity")), Double.parseDouble(req.getParameter("price")), req.getParameter("category")));
        res.sendRedirect("/store/category/goods/" + current.getCategory());
    }

    public void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("GoodServlet doDelete");
        GoodDao goodDao = new GoodDao();
        Good current = goodDao.read(req.getParameter("good"));
        goodDao.delete(req.getParameter("good"));
        res.sendRedirect("/store/category/goods/" + current.getCategory());
    }
}
