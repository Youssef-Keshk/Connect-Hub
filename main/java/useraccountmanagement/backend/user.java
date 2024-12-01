package main.java.useraccountmanagement.backend;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.time.LocalDate;

public class user {
    private String userId;
    private String email;
    private String username;
    private String password;
    private String status ;
    private LocalDate dateOfBirth;

    public user(String userId, String email, String username, String password, String status, LocalDate dateOfBirth) {
        this.userId = userId;
        this.email = email;
        this.username = username;
        this.password = password;
        this.status = status;
        this.dateOfBirth = dateOfBirth;
        this.AddUderToFile();
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

    public void AddUderToFile() {
        try {
            String FILE_PATH="users.json";
            File file = new File(FILE_PATH);
            JSONArray usersArray;
            if (file.exists() && file.length() > 0) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                StringBuilder jsonData = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    jsonData.append(line);
                }
                reader.close();
                usersArray = new JSONArray(jsonData.toString());
            } else {
                usersArray = new JSONArray();
            }

            JSONObject newUser = new JSONObject();
            newUser.put("userId", this.userId);
            newUser.put("email", this.email);
            newUser.put("username", this.username);
            newUser.put("password", this.password);
            newUser.put("status", this.status);
            newUser.put("dateOfBirth", this.dateOfBirth.toString());

            usersArray.put(newUser);

            try (FileWriter writer = new FileWriter(file)) {
                writer.write(usersArray.toString(4));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    

}
