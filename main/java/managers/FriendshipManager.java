package managers;


import entities.Friendship;
import statuses.FriendshipStatus;
import databases.FriendshipDatabase;
import java.util.ArrayList;

public class FriendshipManager {
    private final FriendshipDatabase friendshipDataBase = new FriendshipDatabase();
    
    public void sendRequest(String senderID, String receiverID) {
        Friendship checkingAlreadySentRequest = friendshipDataBase.getFriendshipRequest(receiverID, senderID);
        if(checkingAlreadySentRequest != null)
            return;
        Friendship friendship = Friendship.builder()
                .senderId(senderID)
                .receiverId(receiverID)
                .status(FriendshipStatus.PENDING)
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
        Friendship friendship = friendshipDataBase.getFriendship(userId1, userId2);
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
        FriendSuggester friendSuggester = new FriendSuggester();
        return friendSuggester.suggestFriends(userID);     
    }
    
    public ArrayList<String> getAllFriends(String userID) {
        return friendshipDataBase.getFriendsIds(userID);    
    } 
    
    public ArrayList<String> getAllPendingFriends(String userID) {
        return friendshipDataBase.getSentRequests(userID);    
    }
    
    
    public ArrayList<Friendship> get() {
        return friendshipDataBase.getAllRecords();
    }
    
    public ArrayList<String> getAllSentFriends(String userId) {
        return friendshipDataBase.getReceivedRequests(userId);
    }

}
