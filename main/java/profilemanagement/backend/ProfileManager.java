package profilemanagement.backend;
import database.JsonHandler;
import useraccountmanagement.backend.User;
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
            user.setBio(newBio);
            userHandler.saveAll(userManager.getUsers());
            return true;
        }
        return false;
    }

    public boolean updateProfilePhoto(String userId, String photoPath) {
        Optional<User> userOpt = userManager.getUserById(userId);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            user.setProfilePhotoPath(photoPath);
            userHandler.saveAll(userManager.getUsers());
            return true;
        }
        return false;
    }

    public boolean updateCoverPhoto(String userId, String photoPath) {
        Optional<User> userOpt = userManager.getUserById(userId);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            user.setCoverPhotoPath(photoPath);
            userHandler.saveAll(userManager.getUsers());
            return true;
        }
        return false;
    }

}
 
