package ru.nlmk_it.edu.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ru.nlmk_it.edu.entities.User;

@Stateful
@LocalBean
public class UserDaoBean {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public void saveUser(User user) {
        
        if (user.getUserId() == null) {
            saveNewUser(user);
        } else {
            updateUser(user);
        }
    }
    
    public void saveNewUser(User user) {
        entityManager.persist(user);
    }
    
    public void updateUser(User user) {
        entityManager.merge(user);
    }
    
    public User getUser(Long userId) {
        
        return entityManager.find(User.class, userId);
    }
    
    public void deleteUser(User user) {
        entityManager.remove(user);
    }
}