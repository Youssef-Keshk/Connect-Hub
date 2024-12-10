package managers;

import authenticators.Validator;
import authenticators.PasswordHasher;
import entities.User;
import entities.Profile;
import databases.AccountDatabase;



 class ProfileManager{
    private static ProfileManager instance;
    private final AccountDatabase accountDatabase;
    
    // Singleton
    public static ProfileManager getInstance(AccountDatabase userDataBase) {
        if(instance == null) {
            instance = new ProfileManager(userDataBase);
        }
        return instance;
    }

    public ProfileManager(AccountDatabase userDataBase) {
        this.accountDatabase = userDataBase;
    }
    
    public boolean updateBio(String userId, String newBio) {
        try {
            Profile profile = accountDatabase.getRecord(userId).getProfile();
            profile.setBio(newBio);
            return true;
        }catch(NullPointerException e) {
            return false;
        }       
    }
    
    public boolean updateProfilePhoto(String userId, String photoPath) {
        try {
            Profile profile = accountDatabase.getRecord(userId).getProfile();
            profile.setProfilePhotoPath(photoPath);
            return true;
        }catch(NullPointerException e) {
            return false;
        }   
    }
    
    public boolean updateCoverPhoto(String userId, String photoPath) {
        try {
            Profile profile = accountDatabase.getRecord(userId).getProfile();
            profile.setCoverPhotoPath(photoPath);
            return true;
        }catch(NullPointerException e) {
            return false;
        }   
    }
    
    public boolean updatePassword(String userId, String oldPassword, String newPassword) {
       try {
            User user = accountDatabase.getRecord(userId); 
            
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
            return true;
            
        }catch(NullPointerException e) {
            return false;
        }   
    }
    
}
