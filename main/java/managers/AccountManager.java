package managers;

import databases.AccountDatabase;
import entities.User;
import java.util.ArrayList;


public class AccountManager implements Manager{
    private static AccountManager instance;
    private final AccountDatabase accountDatabase;
    private final UserManager userManager;
    private final ProfileManager profileManager;
    
    // Singleton
    public static AccountManager getInstance() {
        if(instance == null) {
            instance = new AccountManager();
        }
        return instance;
    }

    private AccountManager() {
        accountDatabase = new AccountDatabase();
        userManager = new UserManager(accountDatabase);
        profileManager = new ProfileManager(accountDatabase);
    }

    @Override
    public void refresh() {
        accountDatabase.refreshRecords();
    }

    @Override
    public void save() {
        accountDatabase.saveRecords();
    }
    
    // Creates a new a ccount and signups user
    public boolean signup(User user) {
        return userManager.signup(user);
    }
    
    // Fetches user to login
    public User login(String username, String password) {
        User user = userManager.login(username, password);
        if(user != null)
            save();
        return user;
    }

    // Switches user state to OFFLINE
    public boolean logout(String userID) {
        boolean success = userManager.logout(userID);
        if(success)
            save();
        return success;
    }
    
    // Updates user profile bio
    public boolean updateBio(String userId, String newBio) {
        boolean success = profileManager.updateBio(userId, newBio);
        if(success)
            save();
        return success;
    }
    
    // Updates user profile photo
    public boolean updateProfilePhoto(String userId, String photoPath) {
        boolean success = profileManager.updateProfilePhoto(userId, photoPath);
        if(success)
            save();
        return success;
    }
    
    // Updates user cover photo
    public boolean updateCoverPhoto(String userId, String photoPath) {
        boolean success = profileManager.updateCoverPhoto(userId, photoPath);
        if(success)
            save();
        return success;
    }
    
    // Updates user password
    public boolean updatePassword(String userId, String oldPassword, String newPassword) {
        boolean success = profileManager.updatePassword(userId, oldPassword, newPassword);
        if(success)
            save();
        return success;
    }
    
    // Fetches user by ID
    public User getRecord(String userId) {
        return accountDatabase.getRecord(userId);
    }
   
    // Fetches username by ID
   public String getUsername(String userId) {
       try {
           return getRecord(userId).getUsername();
       }catch(Exception e) {
           return "";
       }
   }
   
   // Fetches users with matching usernames
   public ArrayList<User> searchUsers(String searchKey) {
       SearcherAbstractionImpl<User> searcher = new SearcherAbstractionImpl<>(new UserSearcher());
       return searcher.search(searchKey);
   }
}
