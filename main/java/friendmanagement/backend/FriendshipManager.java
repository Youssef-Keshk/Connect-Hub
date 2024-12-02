package friendmanagement.backend;

import database.JsonHandler;
import java.util.ArrayList;

public class FriendshipManager {
    private final JsonHandler<Friendship> friendshipHandler;
    private final ArrayList<Friendship> friendships;

    public FriendshipManager() {
        //refreshFile();
        String filePath = "src/main/java/resources/friendships.json";
        friendshipHandler = new JsonHandler<>(filePath, Friendship.class);
        this.friendships = friendshipHandler.readAll();
    }
    
    public void sendRequest(String senderID, String receiverID) {
        Friendship newFriendship = new Friendship(senderID, receiverID, "PENDING");
        friendships.add(newFriendship);
        refreshFile();
    }
    
    public boolean acceptRequest(String senderID, String receiverID) {
        Friendship friendship = fetchFriendship(senderID, receiverID);
        if(friendship != null && friendship.getStatus().equalsIgnoreCase("PENDING")) {       
                friendship.setStatus("ACCEPTED");
                refreshFile();
                return true;
        }
        return false;
    }
    
    public boolean declineRequest(String senderID, String receiverID) {
        Friendship friendship = fetchFriendship(senderID, receiverID);
        if(friendship != null && friendship.getStatus().equalsIgnoreCase("PENDING")) {       
                this.friendships.remove(friendship);
                refreshFile();
                return true;
        }
        return false;
    }
    
    public boolean removeFriend(String userId1, String userId2) {
        Friendship friendship = fetchFriendship(userId1 + userId2);
        if(friendship != null) {
            this.friendships.remove(friendship);
            refreshFile();
            return true;
        }
        return false;
    }
    
    public boolean blockFriend(String blockerID, String blockedID) {
        removeFriend(blockerID, blockedID);
        Friendship friendship = new Friendship(blockerID, blockedID, "BLOCKED");
        this.friendships.add(friendship);
        refreshFile();
        return true;
    }
    
    public boolean removeBlockedFriend(String blockerID, String blockedID) {
        return removeFriend(blockerID, blockedID);
    }
    
    // Returns all users with no relationship with current user
    public ArrayList<String> suggestFriends(String userID, ArrayList<String> allUserIDs) {
        ArrayList<String> suggestedIDs = new ArrayList<>();
        for(String otherUserID : allUserIDs) {
            if(!isFriendshipExists(userID, otherUserID) && !userID.equals(otherUserID))
                suggestedIDs.add(otherUserID);
        }
        return suggestedIDs;
    }
    
    private Friendship fetchFriendship(String senderID, String receiverID) {
        return friendships.stream()
                .filter(f -> f.getSenderId().equals(senderID) 
                        && f.getReceiverId().equals(receiverID))
                .findFirst()
                .orElse(null); // Return null if no match is found
    }
    
    // Fetches friendship neglecting sender and receiver
    private Friendship fetchFriendship(String friendshipID) {
        return friendships.stream()
                .filter(f -> (f.getSenderId() + f.getReceiverId()).equals(friendshipID) 
                        || (f.getReceiverId() + f.getSenderId()).equals(friendshipID))
                .findFirst()
                .orElse(null); // Return null if no match is found
    }
    
    private boolean isFriendshipExists(String userId1, String userId2) {
        return friendships.stream().anyMatch(f ->
                (f.getSenderId().equals(userId1) && f.getReceiverId().equals(userId2)) ||
                (f.getSenderId().equals(userId2) && f.getReceiverId().equals(userId1)));
    }

    public ArrayList<Friendship> getFriendships() {
        return friendships;
    }
    
    
    private void refreshFile(){
        friendshipHandler.saveAll(friendships);
    }

}
