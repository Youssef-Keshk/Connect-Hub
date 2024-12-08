package managers;

import databases.FriendshipDatabase;
import databases.UserDatabase;
import java.util.ArrayList;
import entities.User;


public class FriendSuggester {
    private final UserDatabase userDataBase = new UserDatabase();
    private final FriendshipDatabase friendshipDataBase = new FriendshipDatabase();
    
    public ArrayList<String> suggestFriends(String userID) {
        ArrayList<User> users = userDataBase.getAllRecords();
        ArrayList<String> connectedUserIDs = friendshipDataBase.getRecordsIDsOfUser(userID);
        ArrayList<String> suggestions = new ArrayList<>();
        
        for (User user : users) {
            String currentUserId = user.getUserId();

            if (!currentUserId.equals(userID) && !connectedUserIDs.contains(currentUserId)) {
                suggestions.add(currentUserId);
            }
        }
        return suggestions;
    }
}