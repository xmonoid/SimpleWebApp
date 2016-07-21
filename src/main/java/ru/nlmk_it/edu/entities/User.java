package ru.nlmk_it.edu.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "USERS")
public class User implements java.io.Serializable {
    
    @Id
    @SequenceGenerator(name="SEQ_GEN", sequenceName="SEQ_USERS", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_GEN")
    @Column(name = "USER_ID")
    private Long userId;
    
    @NotNull
    @Column(name = "FIRST_NAME")
    private String firstName;
    
    @NotNull
    @Column(name = "LAST_NAME")
    private String lastName;
    
    @NotNull
    @Column(name = "EMAIL")
    private String email;
    
    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
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