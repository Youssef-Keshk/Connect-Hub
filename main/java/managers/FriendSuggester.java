package managers;

import databases.FriendshipDatabase;
import databases.AccountDatabase;
import java.util.ArrayList;
import entities.User;


class FriendSuggester implements SuggestionsGeneratorImplementor{
    private final AccountDatabase accountDatabase;
    private final FriendshipDatabase friendshipDataBase;

    public FriendSuggester() {
        accountDatabase = new AccountDatabase();
        friendshipDataBase = new FriendshipDatabase();
    }    

    @Override
    public ArrayList<String> suggest(String userID) {
        ArrayList<User> users = accountDatabase.getAllRecords();
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
    