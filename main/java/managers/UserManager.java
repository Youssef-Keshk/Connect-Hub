package managers;

import authenticators.PasswordHasher;
import entities.User;
import enums.UserStatus;
import databases.AccountDatabase;


 class UserManager{
    private static UserManager instance;
    private final AccountDatabase accountDatabase;
    
    // Singleton
    public static UserManager getInstance(AccountDatabase userDataBase) {
        if(instance == null) {
            instance = new UserManager(userDataBase);
        }
        return instance;
    }

    public UserManager(AccountDatabase userDataBase) {
        this.accountDatabase = userDataBase;
    }
    
    public boolean signup(User user) {
        boolean success = accountDatabase.insertRecord(user);
        if(success) {
            user.setStatus(UserStatus.ONLINE);
            return true;
        }
        return false;
    }
    
    public User login(String username, String password) {
        String pass = PasswordHasher.getHashedPassword(password);
        User user = accountDatabase.getRecord(username, pass);
        if(user != null)
            user.setStatus(UserStatus.ONLINE); 
        return user;
    }
    
    public boolean logout(String userID) {
        accountDatabase.refreshRecords();
        User user = accountDatabase.getRecord(userID);
        if(user != null) {
            user.setStatus(UserStatus.OFFLINE);
            return true;
        }
        return false;
    }


}
