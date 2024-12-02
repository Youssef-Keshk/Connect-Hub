package database;

import java.util.ArrayList;


public class ExampleUsageForTheJsonHandler {
    

    public static void main(String[] args) {
    JsonHandler<User> userHandler = new JsonHandler<>("src/main/java/database/users_example.json", User.class);
    
    ArrayList<User> usersToBeSaved = new ArrayList<>();
    User user1 = new User("Jack", "jack@gmail.com", "jack123");
    User user2 = new User("Ben", "ben@gmail.com", "ben875");
    User user3 = new User("TOM", "tom@yahoo.com", "tom45");
    usersToBeSaved.add(user1);
    usersToBeSaved.add(user2);
    usersToBeSaved.add(user3);
    userHandler.saveAll(usersToBeSaved);// Save users from JSON
    
    // Read users from JSON
    ArrayList<User> usersToBeRead = userHandler.readAll();
    for (User user : usersToBeRead) {
        System.out.println(user);
    }
    
}    
    
}


class User {
    private String name;
    private String email;
    private String username;
    
    public User() {
    }
    
    public User(String name, String email, String username) {
        this.name = name;
        this.email = email;
        this.username = username;
    }
    

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", email=" + email + ", username=" + username + '}';
    }
}
