package org.example.courseworkstore;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/*")
public class AuthorizationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

        String loginURI = req.getContextPath() + "/store/login";
        String homeURI = req.getContextPath() + "/store";

        boolean loggedIn = session != null && session.getAttribute("user") != null;
        boolean loginRequest = req.getRequestURI().equals(loginURI);
        boolean homeRequest = req.getRequestURI().equals(homeURI);
        boolean isCssRequest = req.getRequestURI().endsWith(".css");

        if(loggedIn || loginRequest || homeRequest || isCssRequest){
            chain.doFilter(request, response);
        } else {
            res.sendRedirect(loginURI);
        }
    }
}
