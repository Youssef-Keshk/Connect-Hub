package profilemanagement.backend;

import database.JsonHandler;
import useraccountmanagement.backend.*;
import java.util.Optional;

public class ProfileManager {
    private final JsonHandler<User> userHandler = new JsonHandler<>("users.json", User.class);
    private final UserAccountManagement userManager;

    public ProfileManager(UserAccountManagement userManager) {
        this.userManager = userManager;
    }

    public boolean updateBio(String userId, String newBio) {
        User user = userManager.getUser(userId);
        if (user != null) {
            user.profile.setBio(newBio);
            userHandler.saveAll(userManager.getUsers());
            return true;
        }
        return false;
    }

    public boolean updateProfilePhoto(String userId, String photoPath) {
        User user = userManager.getUser(userId);
        if (user != null) {
            user.profile.setProfilePhotoPath(photoPath);
            userHandler.saveAll(userManager.getUsers());
            return true;
        }
        return false;
    }

    public boolean updateCoverPhoto(String userId, String photoPath) {
        User user = userManager.getUser(userId);
        if (user != null) {
            user.profile.setCoverPhotoPath(photoPath);
            userHandler.saveAll(userManager.getUsers());
            return true;
        }
        return false;
    }
    
    public boolean checkPassword(String userId, String oldPass){
       User user = userManager.getUser(userId);
        if (user != null) {          
                if(user.getPassword().equals(oldPass))
                return true;
            }    
        return false;
    }
    
   
    public boolean updatePassword(String userId, String newPass){
       User user = userManager.getUser(userId);
        if (user != null) {          
                user.setPassword(newPass);
                return true;
            }    
        return false;
    }
}