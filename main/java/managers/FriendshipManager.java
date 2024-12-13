package managers;

import entities.Friendship;
import enums.FriendshipStatus;
import databases.FriendshipDatabase;
import enums.FriendshipType;
import java.util.ArrayList;

public class FriendshipManager implements Manager{
    private static FriendshipManager instance;
    private final FriendshipDatabase friendshipDataBase;
    
    // Singleton
    public static FriendshipManager getInstance() {
        if(instance == null) {
            instance = new FriendshipManager();
        }
        return instance;
    }

    private FriendshipManager() {
        friendshipDataBase = new FriendshipDatabase();
    }
    
    @Override
    public void refresh() {
        friendshipDataBase.refreshRecords();
    }

    @Override
    public void save() {
        friendshipDataBase.saveRecords();
    }
      
    
    public void sendRequest(String senderID, String receiverID) {
        Friendship checkingAlreadySentRequest = friendshipDataBase.getFriendshipRequest(receiverID, senderID);
        if(checkingAlreadySentRequest != null)
            return;
        Friendship friendship = Friendship.builder()
                .senderId(senderID)
                .receiverId(receiverID)
                .status(FriendshipStatus.PENDING)
                .type(FriendshipType.USERS)
                .build();

        friendshipDataBase.insertRecord(friendship);
    }
    
    public boolean acceptRequest(String senderID, String receiverID) {
        Friendship friendship = friendshipDataBase.getFriendshipRequest(senderID, receiverID);
        try {
            friendship.setStatus(FriendshipStatus.ACCEPTED);
            friendshipDataBase.saveRecords();
            return true;
            
        } catch(NullPointerException e) {
            return false;
        }
    }
    
    public boolean declineRequest(String senderID, String receiverID) {
        Friendship friendship = friendshipDataBase.getFriendshipRequest(senderID, receiverID);
        try {
            friendshipDataBase.removeRecord(friendship);
            friendshipDataBase.saveRecords();
            return true;
            
        } catch(NullPointerException e) {
            return false;
        }
    }
    
    public boolean removeFriend(String userId1, String userId2) {
        Friendship friendship = friendshipDataBase.getActiveFriendship(userId1, userId2);
        try {
            friendshipDataBase.removeRecord(friendship);
            friendshipDataBase.saveRecords();
            return true;
            
        } catch(NullPointerException e) {
            return false;
        }
    }
    
    public boolean blockUser(String blockerID, String blockedID) {
        removeFriend(blockerID, blockedID); // remove if already a friend
        Friendship friendship = Friendship.builder()
                .senderId(blockerID)
                .receiverId(blockedID)
                .status(FriendshipStatus.BLOCKED)
                .type(FriendshipType.USERS)
                .build();
        
        return friendshipDataBase.insertRecord(friendship);
    }
    
    public boolean removeBlockedFriend(String blockerID, String blockedID) {
        Friendship friendship = friendshipDataBase.getBlockedFriendship(blockerID, blockedID);
        try {
            friendshipDataBase.removeRecord(friendship);
            //friendshipDataBase.saveRecords();
            return true;
            
        } catch(NullPointerException e) {
            return false;
        }
    }
    
    // Returns all users with no relationship with current user
    public ArrayList<String> suggestFriends(String userID) {
        SuggesterAbstractionImpl suggester = new SuggesterAbstractionImpl(new FriendSuggester());
        return suggester.suggest(userID);     
    }
    
    public ArrayList<String> getAllFriends(String userID) {
        return friendshipDataBase.getFriendsIds(userID);    
    } 
    
    public ArrayList<String> getAllPendingFriends(String userID) {
        return friendshipDataBase.getSentRequests(userID);    
    }
    
    public Friendship getFriendshipOfTwoUsers(String userID1, String userID2) {
        return friendshipDataBase.getFriendshipOfTwoUsers(userID1, userID2);
    }
    
    
    public ArrayList<Friendship> get() {
        return friendshipDataBase.getAllRecords();
    }
    
    public ArrayList<String> getAllSentFriends(String userId) {
        return friendshipDataBase.getReceivedRequests(userId);
    }

    // Returns all requests to join group
    public ArrayList<String> getGroupRequests(String groupId) {
        ArrayList<String> requests = new ArrayList<>();
        ArrayList<Friendship> friendships = friendshipDataBase.getGroupFriendships(groupId);
        for(Friendship f : friendships) 
            if(f.getStatus().equals(FriendshipStatus.PENDING))
                requests.add(f.getSenderId());
        return requests;           
    }
    
    // Returns all current members of a group
    public ArrayList<String> getGroupMembers(String groupId) {
        ArrayList<String> members = new ArrayList<>();
        ArrayList<Friendship> friendships = friendshipDataBase.getGroupFriendships(groupId);
        for(Friendship f : friendships) 
            if(f.getStatus().equals(FriendshipStatus.ACCEPTED))
                members.add(f.getSenderId());
        return members;           
    }
    
    // Returns all active groups of a user
    public ArrayList<String> getCurrentGroupsOfUser(String memberId) {
        ArrayList<String> groups = new ArrayList<>();
        ArrayList<Friendship> friendships = friendshipDataBase.getGroupsOfAUser(memberId);
        for(Friendship f : friendships)
                groups.add(f.getReceiverId());
        return groups;    
    }
    
    // sends a join request to a group
    public void sendGroupRequest(String groupId, String userId) {
        Friendship checkingAlreadySentRequest = friendshipDataBase.getGroupFriendShipRequest(groupId, userId);
        if(checkingAlreadySentRequest != null)
            return;
        Friendship friendship = Friendship.builder()
                .senderId(userId)
                .receiverId(groupId)
                .status(FriendshipStatus.PENDING)
                .type(FriendshipType.GROUPS)
                .build();

        friendshipDataBase.insertRecord(friendship);
    }
    
    // Accepts request to join group
    public void acceptGroupRequest(String groupId, String userId) {
        Friendship friendship = friendshipDataBase.getGroupFriendShipRequest(groupId, userId);
        if(friendship == null)
            return;
        friendship.setStatus(FriendshipStatus.ACCEPTED);
        save();
    }
    
    // Returns all groups with no relationship with current user
    public ArrayList<String> suggestGroups(String userID) {
        SuggesterAbstractionImpl suggester = new SuggesterAbstractionImpl(new GroupSuggester());
        return suggester.suggest(userID);     
    }
    
 
    public boolean removeRequest(String groupId, String userId) {
        Friendship friendship = friendshipDataBase.getGroupFriendShipRequest(groupId, userId);
        if(friendship == null)
            return false;
        return friendshipDataBase.removeRecord(friendship);
    }

}
