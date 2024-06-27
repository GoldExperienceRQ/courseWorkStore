package org.example.courseworkstore.dao;

import org.example.courseworkstore.Database;
import org.example.courseworkstore.entities.User;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.util.List;

public class UserDao implements GenericDao<User>{

    Connection connection;

    public UserDao() {
        this.connection = Database.getConnection();
    }

    @Override
    public List<User> getAll() {
        return List.of();
    }

    @Override
    public void create(User entity) {
        try{
            String query = "INSERT INTO users (username, user_password) VALUES (?, ?)";
            var statement = connection.prepareStatement(query);
            statement.setString(1, entity.getUsername());
            statement.setString(2, entity.getPassword());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public User read(String name) {
        User user = null;
        try{
            String query = "SELECT * FROM users WHERE username = ?";
            var statement = connection.prepareStatement(query);
            statement.setString(1, name);
            var resultSet = statement.executeQuery();
            if(resultSet.next()){
                user = new User(resultSet.getString("username"), resultSet.getString("user_password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(String name) {

    }
}
