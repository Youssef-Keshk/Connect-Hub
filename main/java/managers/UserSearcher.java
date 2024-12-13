package managers;

import databases.AccountDatabase;
import entities.User;
import java.util.ArrayList;


public class UserSearcher implements SearchGeneratorImplementor<User>{
    private final ArrayList<User> users;
    
    public UserSearcher() {
        AccountDatabase accountDatabase = new AccountDatabase();
        users = accountDatabase.getAllRecords();
    }
    

    @Override
    public ArrayList<User> search(String searchKey) {
        searchKey = searchKey.toLowerCase();
        ArrayList<User> matchingUsers = new ArrayList<>();
        ArrayList<User> toRemove = new ArrayList<>();
        
        // Users with username similar to searchkey
        for(User user : users) {
            if(user.getUsername().toLowerCase().equals(searchKey)) {
                matchingUsers.add(user);
                toRemove.add(user);
            }
        }
        
        users.removeAll(toRemove);
        toRemove.clear();
        
        // Users with username starts with searchkey
        for(User user : users) {
            if(user.getUsername().toLowerCase().startsWith(searchKey)) {
                matchingUsers.add(user);
                toRemove.add(user);
            }
        }
        
        users.removeAll(toRemove);
        toRemove.clear();
        
        // Users with username ends by searchkey
        for(User user : users) {
            if(user.getUsername().toLowerCase().endsWith(searchKey)) {
                matchingUsers.add(user);
                toRemove.add(user);
            }
        }
        return matchingUsers;
    }
    
}
