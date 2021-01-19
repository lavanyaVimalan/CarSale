package com.cg.cars.beans;
/**
 * This is the entity class for user module with getter,setter.
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

 

@Component("user")
@Scope(scopeName="prototype")
@Entity
@Table(name = "users")
public class User{
    
    @Id
    @Column(name = "USER_ID")
    private long userId;
    @Column(name = "USER_NAME" , unique = true)
    private String userName;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "ROLE")
    private String role;
    
    public long getUserId() {
        return userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public User() {
        
    }
    public User(long userId, String userName, String password, String role) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }
    
  
    
    @Override
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", role=" + role + "]";
    }
   /* public User orElseThrow(Object object) {
        return null;
    }*/
     
    
    
    
}