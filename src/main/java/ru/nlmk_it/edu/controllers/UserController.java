package ru.nlmk_it.edu.controllers;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import ru.nlmk_it.edu.beans.UserDaoBean;
import ru.nlmk_it.edu.entities.User;

@Named
@RequestScoped
public class UserController implements Serializable {
    
    @EJB
    private UserDaoBean userDaoBean;
    
    private User user;
    
    private String firstName;
    private String lastName;
    private String email;
    
    public UserController() {
        user = new User();
    }
    
    public String saveUser() {
        String returnValue = "user_saved";
        
        try {
            populateUser();
            userDaoBean.saveUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            returnValue = "error_saving_user";
        }
        
        return returnValue;
    }
    
    private void populateUser() {
        if (user == null) {
            user = new User();
        }
        user.setFirstName(getFirstName());
        user.setLastName(getLastName());
        user.setEmail(getEmail());
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
}