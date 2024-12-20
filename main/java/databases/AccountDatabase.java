package databases;

import entities.User;        
        
public class AccountDatabase extends DatabaseHandler<User>{
    
    public AccountDatabase(){
        super(FilePaths.USERS_FILEPATH, User.class);
    }
    
    @Override
    public boolean insertRecord(User user) {
        if(!contains(user.getUsername(), user.getPassword()))
            return super.insertRecord(user);
        return false;
    }
    
    public boolean contains(String userID) {
        for(User user : records) 
            if(user.getUserId().equals(userID))
                return true;
        return false;
    }
    
    public boolean contains(String username, String password) {
        for(User user : records) 
            if(user.getUsername().equals(username) && user.getPassword().equals(password))
                return true;
        return false;
    }
    
    
    public User getRecord(String userID) {
        for(User user : records)
            if(user.getUserId().equals(userID))
                return user;
        return null;
    }
    
    public User getRecord(String username, String password) {
        for(User user : records) 
            if(user.getUsername().equals(username) && user.getPassword().equals(password))
                return user;
        return null;
    }
    
    
    public boolean deleteRecord(String userID) {
        User user = getRecord(userID);
        boolean success = false;
        if(user != null) {
            success = records.remove(user);
            if(success) 
                saveRecords();
        } 
        return success;
    }
    
}
