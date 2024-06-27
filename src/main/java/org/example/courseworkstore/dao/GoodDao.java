package org.example.courseworkstore.dao;

import org.example.courseworkstore.Database;
import org.example.courseworkstore.entities.Good;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GoodDao implements GenericDao<Good> {

    Connection connection;

    public GoodDao() {
        this.connection = Database.getConnection();
    }

    public List<Good> getByCategory(String category) {
        List<Good> goods = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM goods WHERE category = '" + category + "'");
            while (rs.next()) {
                goods.add(new Good(rs.getString("name"), rs.getString("description"), rs.getString("producer"), rs.getInt("quantity"), rs.getDouble("price"), rs.getString("category")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return goods;
    }

    public List<Good> getBySearchValue(String searchValue, String category) {
        List<Good> goods = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM goods WHERE name LIKE '%" + searchValue + "%' AND category = '" + category + "'");
            while (rs.next()) {
                goods.add(new Good(rs.getString("name"), rs.getString("description"), rs.getString("producer"), rs.getInt("quantity"), rs.getDouble("price"), rs.getString("category")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return goods;
    }
    public void patchQuantity(String name, int quantity){
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("UPDATE goods SET quantity = " + quantity + " WHERE name = '" + name + "'");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public List<Good> getAll() {
        List<Good> goods = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM goods");
            while (rs.next()) {
                goods.add(new Good(rs.getString("name"), rs.getString("description"), rs.getString("producer"), rs.getInt("quantity"), rs.getDouble("price"), rs.getString("category")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return goods;
    }

    @Override
    public void create(Good entity) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("INSERT INTO goods (name, description, producer, quantity, price, category) VALUES ('" + entity.getName() + "', '" + entity.getDescription() + "', '" + entity.getProducer() + "', " + entity.getQuantity() + ", " + entity.getPrice() + ", '" + entity.getCategory() + "')");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Good read(String name) {
        Good good = null;
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM goods WHERE name = '" + name + "'");
            if (rs.next()) {
                good = new Good(rs.getString("name"), rs.getString("description"), rs.getString("producer"), rs.getInt("quantity"), rs.getDouble("price"), rs.getString("category"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return good;
    }

    @Override
    public void update(Good entity) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("UPDATE goods SET description = '" + entity.getDescription() + "', producer = '" + entity.getProducer() + "', quantity = " + entity.getQuantity() + ", price = " + entity.getPrice() + " WHERE name = '" + entity.getName() + "'");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(String name) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("DELETE FROM goods WHERE name = '" + name + "'");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
