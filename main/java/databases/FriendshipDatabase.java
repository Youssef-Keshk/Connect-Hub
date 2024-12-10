package databases;

import enums.FriendshipStatus;
import entities.Friendship;
import java.util.ArrayList;


public class FriendshipDatabase extends DatabaseHandler<Friendship>{

    public FriendshipDatabase(){
        super(FilePaths.FRIENDSHIPS_FILEPATH, Friendship.class);
    }
 
    public ArrayList<Friendship> getRecordsOfUser(String userID) {
        ArrayList<Friendship> userFriendship = new ArrayList<>();
        for(Friendship friendship : records)
            if(friendship.getSenderId().equals(userID) || friendship.getReceiverId().equals(userID))
                userFriendship.add(friendship) ;
        return userFriendship;
    }
    
    public ArrayList<String> getRecordsIDsOfUser(String userID) {
        ArrayList<String> userFriendshipIDs = new ArrayList<>();
        for(Friendship friendship : records) {
            if(friendship.getSenderId().equals(userID))
                userFriendshipIDs.add(friendship.getReceiverId()) ;
            else if(friendship.getReceiverId().equals(userID))
                userFriendshipIDs.add(friendship.getSenderId()) ;
        }
        return userFriendshipIDs;
    }
    
    
    public Friendship getFriendshipRequest(String senderID, String receiverID) {
        for(Friendship friendship : records)
            if(friendship.getSenderId().equals(senderID) && friendship.getReceiverId().equals(receiverID) && friendship.getStatus() == FriendshipStatus.PENDING)
                return friendship;
        return null;
    }
    
    public Friendship getFriendship(String userID1, String userID2) {
        for(Friendship friendship : records) {
            if(friendship.getStatus() == FriendshipStatus.ACCEPTED)
                if(
                (friendship.getSenderId().equals(userID1) && friendship.getReceiverId().equals(userID2)) ||
                (friendship.getSenderId().equals(userID2) && friendship.getReceiverId().equals(userID1))
                )return friendship;   
        }
        return null;
    }
    
    public Friendship getBlockedFriendship(String blockerID, String blockedID) {
        for(Friendship friendship : records)
            if(friendship.getSenderId().equals(blockerID) && friendship.getReceiverId().equals(blockedID) && friendship.getStatus() == FriendshipStatus.BLOCKED)
                return friendship;
        return null;
    }
   
    
    public ArrayList<String> getReceivedRequests(String receiverID) {
        ArrayList<String> userRequests = new ArrayList<>();
        for(Friendship friendship : records)
            if(friendship.getReceiverId().equals(receiverID) && friendship.getStatus() == FriendshipStatus.PENDING)
                userRequests.add(friendship.getSenderId()) ;
        return userRequests;
    }
    
    public ArrayList<String> getSentRequests(String senderID) {
        ArrayList<String> userRequests = new ArrayList<>();
        for(Friendship friendship : records)
            if(friendship.getSenderId().equals(senderID) && friendship.getStatus() == FriendshipStatus.PENDING)
                userRequests.add(friendship.getReceiverId()) ;
        return userRequests;
    }
    
    public ArrayList<String> getFriendsIds(String userID) {
        ArrayList<String> friendsIDs = new ArrayList<>();
        for(Friendship friendship : records) {
            if(friendship.getStatus() == FriendshipStatus.ACCEPTED) {
                if(friendship.getSenderId().equals(userID))
                    friendsIDs.add(friendship.getReceiverId()) ;
                else if(friendship.getReceiverId().equals(userID))
                    friendsIDs.add(friendship.getSenderId()) ;
            }          
        }
        return friendsIDs;
    }
    
    public ArrayList<String> getBlockedUsers(String userID) {
        ArrayList<String> blockedUsersIDs = new ArrayList<>();
        for(Friendship friendship : records) {
            if(friendship.getSenderId().equals(userID) && friendship.getStatus() == FriendshipStatus.BLOCKED) {
                blockedUsersIDs.add(friendship.getReceiverId()) ;
            }          
        }
        return blockedUsersIDs;
    }
    
    public ArrayList<String> getUsersBlockingCurrentUser(String userID) {
        ArrayList<String> usersBlockingCurrentUser = new ArrayList<>();
        for(Friendship friendship : records) {
            if(friendship.getReceiverId().equals(userID) && friendship.getStatus() == FriendshipStatus.BLOCKED) {
                usersBlockingCurrentUser.add(friendship.getReceiverId()) ;
            }          
        }
        return usersBlockingCurrentUser;
    }
    
        
}
