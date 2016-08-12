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
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;
    
    @NotNull
    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;
    
    @NotNull
    @Column(name = "EMAIL", nullable = false)
    private String email;
    
    @Column(name = "REG_DATE")
    private java.sql.Date registerDate;
    
    @Column(name = "REG_TIME")
    private java.sql.Time registerTime;
    
    {
        final long currentMoment = new java.util.Date().getTime();
        registerDate = new java.sql.Date(currentMoment);
        registerTime = new java.sql.Time(currentMoment);
    }
    
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
        
        if (firstName != null && firstName.trim().equalsIgnoreCase("")) {
            this.firstName = null;
        } else {
            this.firstName = firstName;
        }
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        if (lastName != null && lastName.trim().equalsIgnoreCase("")) {
            this.lastName = null;
        } else {
            this.lastName = lastName;
        }
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        if (email != null && email.trim().equalsIgnoreCase("")) {
            this.email = null;
        } else {
            this.email = email;
        }
    }
    
    public java.sql.Date getRegisterDate() {
        return registerDate;
    }
    
    public void setRegisterDate(java.sql.Date registerDate) {
        this.registerDate = registerDate;
    }
    
    public java.sql.Time getRegisterTime() {
        return registerTime;
    }
    
    public void setRegisterTime(java.sql.Time registerTime) {
        this.registerTime = registerTime;
    }
    
    @Override
    public String toString() {
        Long localUserId = userId;
        String localFirstName = firstName;
        String localLastName = lastName;
        String localEmail = email;

        if (localUserId == null) {
            localUserId = 0L;
        }

        if (localEmail == null) {
            localEmail = "";
        }

        if (localFirstName == null) {
            localFirstName = "";
        }
        if (localLastName == null) {
            localLastName = "";
        }

        StringBuilder result = new StringBuilder();
        result.append("userId = ").append(localUserId).append("\n")
              .append("firstName = ").append(localFirstName).append("\n")
              .append("lastName = ").append(localLastName).append("\n")
              .append("email = ").append(localEmail);

        return result.toString();
    }
}