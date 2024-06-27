package org.example.courseworkstore.controllers.category;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.*;
import org.example.courseworkstore.dao.CategoryDao;
import org.example.courseworkstore.entities.Category;

import java.io.IOException;

@WebServlet(name = "CategoryServlet", value = "/store/category/*")
public class CategoryServlet extends HttpServlet {


    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        System.out.println("CategoryServlet doGet");

        String path = req.getPathInfo();
        String command = path.substring(1);
        if(command.equals("delete")){
            doDelete(req, res);
        }
        else if(command.equals("update")){
            CategoryDao categoryDao = new CategoryDao();
            req.setAttribute("category", categoryDao.read(req.getParameter("category")));
            req.getRequestDispatcher("/WEB-INF/pages/updateCategory.jsp").forward(req, res);
        }
        else if(command.equals("add")){
            System.out.println("AddCategoryServlet doGet");
            req.getRequestDispatcher("/WEB-INF/pages/addCategory.jsp").forward(req, res);
        }
        else{
            CategoryDao categoryDao = new CategoryDao();
            req.setAttribute("categories", categoryDao.getAll());
            req.getRequestDispatcher("/WEB-INF/pages/categories.jsp").forward(req, res);
        }
    }
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        System.out.println("CategoryServlet doPost");
        String method = req.getParameter("_method");
        if(method != null && method.equals("PUT")){
            doPut(req, res);
        }
        else{
            CategoryDao categoryDao = new CategoryDao();
            categoryDao.create(new Category(req.getParameter("name"), req.getParameter("description")));
            res.sendRedirect("/store/category/all");
        }

    }
    public void doPut(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("CategoryServlet doPut");
        CategoryDao categoryDao = new CategoryDao();

        categoryDao.update(new Category(req.getParameter("name"), req.getParameter("description")));
        res.sendRedirect("/store/category/all");
    }
    public void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("CategoryServlet doDelete");
        CategoryDao categoryDao = new CategoryDao();
        categoryDao.delete(req.getParameter("category"));
        res.sendRedirect("/store/category/all");
    }
}
