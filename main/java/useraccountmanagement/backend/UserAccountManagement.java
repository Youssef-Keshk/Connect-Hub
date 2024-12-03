package main.java.useraccountmanagement.backend;
import main.java.database.JsonHandler;
import main.java.friendmanagement.backend.Friendship;

import java.util.ArrayList;

public class UserAccountManagement {
    private ArrayList<User> userAccounts;
    private JsonHandler<User> userJsonHandler;

    public UserAccountManagement() {
        String filePath = "D:\\java\\Connect-Hub\\Connect-Hub\\main\\java\\resources\\users.json";
        userJsonHandler = new JsonHandler<User>(filePath, User.class);
        this.userAccounts =userJsonHandler.readAll();
    }

    public ArrayList<User> getUsers() {
        return this.userAccounts;
    }

    public int searchUser(String userid) {
        for (int i = 0; i < userAccounts.size(); i++) {
            if (userAccounts.get(i).getUserId().equals(userid)) {
                return i;
            }
        }
        return -1;
    }

    public void signup(User user) {
     this.userAccounts.add(user);
    }

    public int login(String userid, String password) {
        int index = searchUser(userid);
        if (index == -1) {
            return index;
        }
        else {
             if (userAccounts.get(index).getPassword().equals(userAccounts.get(index).hashPassword(password))) {
                 System.out.println("Password Matched");
                 userAccounts.get(index).setStatus("online");
                 userJsonHandler.saveAll(userAccounts);
                 return 1;
             }else {
                 System.out.println("Wrong password");
                 return 0;
             }
        }
    }

    public void logout(User user) {
        user.setStatus("offline");
    }

}

