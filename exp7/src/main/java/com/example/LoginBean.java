package com.example;
import jakarta.ejb.Stateless;
@Stateless
public class LoginBean {
public boolean authenticate(String username, String password) {
// In a real application, you would check against a database
return "admin".equals(username) && "password".equals(password);
}   
}