package ru.nlmk_it.edu;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import ru.nlmk_it.edu.entities.User;

public class AllUsersServlet extends HttpServlet {
    
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        Query query = entityManager.createQuery("SELECT u FROM User u");
        
        List<User> userList = query.getResultList();
        
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("/WEB-INF/allUsers.jsp").forward(request, response);
    }
}