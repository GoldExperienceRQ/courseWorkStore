package org.example.courseworkstore.dao;

import org.example.courseworkstore.Database;
import org.example.courseworkstore.entities.Category;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao implements GenericDao<Category>{

    Connection connection;

    public CategoryDao() {

        this.connection = Database.getConnection();
    }
    @Override
    public List<Category> getAll() {
        List<Category> categories = new ArrayList<>();
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM categories");
            while(rs.next()){
                categories.add(new Category(rs.getString("name"), rs.getString("description")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public void create(Category entity) {
        try{
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("INSERT INTO categories (name, description) VALUES ('" + entity.getName() + "', '" + entity.getDescription() + "')");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Category read(String name) {
        Category category = null;
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM categories WHERE name = '" + name + "'");
            if(rs.next()){
                category = new Category(rs.getString("name"), rs.getString("description"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return category;
    }

    @Override
    public void update(Category entity) {
        try{
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("UPDATE categories SET description = '" + entity.getDescription() + "' WHERE name = '" + entity.getName() + "'");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(String name) {
        try{
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("DELETE FROM categories WHERE name = '" + name + "'");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
