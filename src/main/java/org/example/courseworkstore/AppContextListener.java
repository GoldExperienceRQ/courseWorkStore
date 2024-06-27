package org.example.courseworkstore;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Application started");
        Database.initialize("127.0.0.1:3306/store_schema", "root", "my_sql");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Application stopped");
    }
}
