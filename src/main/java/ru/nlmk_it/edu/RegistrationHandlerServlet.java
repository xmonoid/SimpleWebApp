package ru.nlmk_it.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.transaction.UserTransaction;

import ru.nlmk_it.edu.entities.User;

//@WebServlet(name = "RegistrationHandlerServlet", urlPatterns = {"/rhs"})
public class RegistrationHandlerServlet extends HttpServlet {
    
    @PersistenceUnit(name = "simpleWebPersistenceUnit")
    private EntityManagerFactory entityManagerFactory;
    
    @Resource(name = "jdbc/__SimpleWebDBPool")
    private UserTransaction userTransaction;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        User user = new User();
        
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        
        try {
            userTransaction.begin();
        
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            
            entityManager.persist(user);
            
            entityManager.joinTransaction();
            entityManager.flush();
            
            Long id = user.getUserId();
            User sameUser = entityManager.find(User.class, id);
            
            userTransaction.commit();
            
            request.setAttribute("firstName", sameUser.getFirstName());
            request.setAttribute("lastName", sameUser.getLastName());
            request.setAttribute("email", sameUser.getEmail());
            
            request.getRequestDispatcher("/WEB-INF/registration_ok.jsp").forward(request, response);
        } catch (javax.validation.ConstraintViolationException e) {
            request.setAttribute("errorMessage", "Some of required fields did not fill out.");
            request.getRequestDispatcher("/WEB-INF/registration_failed.jsp").forward(request, response);
            
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            
            request.setAttribute("errorMessage", e.getMessage() + "\n" + sw.toString());
            request.getRequestDispatcher("/WEB-INF/registration_failed.jsp").forward(request, response);
        }
    }
}