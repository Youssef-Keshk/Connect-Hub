package main.java.useraccountmanagement.backend;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;

public class User {
    private static int dynamicnumber=0;
    private  String userId;
    private String email;
    private String username;
    private String password;
    private String status ;
    private LocalDate dateOfBirth;

    public User(String email, String username, String password, String status, LocalDate dateOfBirth) {
        dynamicnumber++;
        this.userId = "A"+dynamicnumber;
        this.email = email;
        this.username = username;
        this.password = hashPassword(password);
        this.status = status;
        this.dateOfBirth = dateOfBirth;
    }
    public User(){
        this.userId = null;
        this.email = null;
        this.username = null;
        this.password = null;
        this.status = null;
        this.dateOfBirth = null;
    }

    public void User1(String email, String username, String hashpassword, String status, LocalDate dateOfBirth) {
        dynamicnumber++;
        this.userId = "A"+dynamicnumber;
        this.email = email;
        this.username = username;
        this.password = hashpassword;
        this.status = status;
        this.dateOfBirth = dateOfBirth;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }



     public String hashPassword(String password) {
         try {
             MessageDigest digest = MessageDigest.getInstance("SHA-256");
             byte[] hashedBytes = digest.digest(password.getBytes());

             StringBuilder hexString = new StringBuilder();
             for (byte b : hashedBytes) {
                 hexString.append(String.format("%02x", b));
             }
             return hexString.toString();
         } catch (NoSuchAlgorithmException e) {
             throw new RuntimeException("SHA-256 algorithm not found", e);
         }
     }
    

}
