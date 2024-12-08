package managers;

import authenticators.Validator;
import authenticators.PasswordHasher;
import entities.Profile;
import databases.UserDatabase;
import entities.User;


public class ProfileManager {
    private final UserDatabase userDataBase = new UserDatabase();
    
    public boolean updateBio(String userId, String newBio) {
        try {
            Profile profile = userDataBase.getRecord(userId).getProfile();
            profile.setBio(newBio);
            userDataBase.saveRecords();
            return true;
        }catch(NullPointerException e) {
            return false;
        }       
    }
    
    public boolean updateProfilePhoto(String userId, String photoPath) {
        try {
            Profile profile = userDataBase.getRecord(userId).getProfile();
            profile.setProfilePhotoPath(photoPath);
            userDataBase.saveRecords();
            return true;
        }catch(NullPointerException e) {
            return false;
        }   
    }
    
    public boolean updateCoverPhoto(String userId, String photoPath) {
        try {
            Profile profile = userDataBase.getRecord(userId).getProfile();
            profile.setCoverPhotoPath(photoPath);
            userDataBase.saveRecords();
            return true;
        }catch(NullPointerException e) {
            return false;
        }   
    }
    
    public boolean updatePassword(String userId, String oldPassword, String newPassword) {
       try {
            User user = userDataBase.getRecord(userId); 
            
            // Validate password is 4 or more characters
            if(!Validator.isValidPassword(newPassword))
                return false;
            
            // Check if new password is identical to old password
            if(newPassword.equals(oldPassword))
                return false;
            
            // Check if old password is confirmed correctly
            String oldHashedPassword = PasswordHasher.getHashedPassword(oldPassword); 
            if(!oldHashedPassword.equals(user.getPassword()))
                return false;
               
            String newHashedPassword = PasswordHasher.getHashedPassword(newPassword);
            // set new password
            user.setPassword(newHashedPassword);
            userDataBase.saveRecords();
            return true;
            
        }catch(NullPointerException e) {
            return false;
        }   
    }
    
    public User getRecord(String userId) {
        return userDataBase.getRecord(userId);
    }
   
   public String getUsername(String userId) {
       try {
           return getRecord(userId).getUsername();
       }catch(Exception e) {
           return "";
       }
   }
     
    
}
