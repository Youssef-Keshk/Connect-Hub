package profilemanagement.backend;

import database.JsonHandler;
import useraccountmanagement.backend.*;
import java.util.Optional;

public class ProfileManager {
    private final JsonHandler<User> userHandler = new JsonHandler<>("users.json", User.class);
    private final UserManager userManager;

    public ProfileManager(UserManager userManager) {
        this.userManager = userManager;
    }

    public boolean updateBio(String userId, String newBio) {
        Optional<User> userOpt = userManager.getUserById(userId);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            user.profile.setBio(newBio);
            userHandler.saveAll(userManager.getUsers());
            return true;
        }
        return false;
    }

    public boolean updateProfilePhoto(String userId, String photoPath) {
        Optional<User> userOpt = userManager.getUserById(userId);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            user.profile.setProfilePhotoPath(photoPath);
            userHandler.saveAll(userManager.getUsers());
            return true;
        }
        return false;
    }

    public boolean updateCoverPhoto(String userId, String photoPath) {
        Optional<User> userOpt = userManager.getUserById(userId);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            user.profile.setCoverPhotoPath(photoPath);
            userHandler.saveAll(userManager.getUsers());
            return true;
        }
        return false;
    }
    
    public boolean updatePassword(String userId, String oldPass, String newPass){
        Optional<User> userOpt = userManager.getUserById(userId);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if(user.getPassword().equals(oldPass)){
                user.setPassword(newPass);
                return true;
            }
            else return false;
        }    
        return false;
    }
}