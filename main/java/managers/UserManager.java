package managers;

import authenticators.PasswordHasher;
import entities.User;
import statuses.UserStatus;
import databases.UserDatabase;


public class UserManager {
    private final UserDatabase userDataBase = new UserDatabase();
    
    public boolean signup(User user) {
        boolean success = userDataBase.insertRecord(user);
        if(success) {
            user.setStatus(UserStatus.ONLINE);
            return true;
        }
        return false;
    }
    
    public User login(String username, String password) {
        String pass = PasswordHasher.getHashedPassword(password);
        User user = userDataBase.getRecord(username, pass);
        if(user != null) {
            user.setStatus(UserStatus.ONLINE);
            save();
        }        
        return user;
    }
    
    public boolean logout(String userID) {
        userDataBase.refreshRecords();
        User user = userDataBase.getRecord(userID);
        if(user != null) {
            user.setStatus(UserStatus.OFFLINE);
            save();
            return true;
        }
        return false;
    }
    
    public void save() {
        userDataBase.saveRecords();
    }
    

}
