package managers;

import databases.FriendshipDatabase;
import databases.GroupDatabase;
import entities.Group;
import java.util.ArrayList;


public class GroupSuggester implements SuggestionsGeneratorImplementor{
    private final GroupDatabase groupDatabase;
    private final FriendshipDatabase friendshipDataBase;

    
    public GroupSuggester() {
        groupDatabase = new GroupDatabase();
        friendshipDataBase = new FriendshipDatabase();
    }
    
    
    @Override
    public ArrayList<String> suggest(String userID) {
        ArrayList<Group> groups = groupDatabase.getAllRecords();
        ArrayList<String> connectedFriendships = friendshipDataBase.getAllGroupsIdsOfAUser(userID);
        
        ArrayList<String> suggestions = new ArrayList<>();
        
        for (Group group : groups) {
            String groupId = group.getGroupId();

            if (!connectedFriendships.contains(groupId)) {
                suggestions.add(groupId);
            }
        }
        return suggestions;
    }
   
}
