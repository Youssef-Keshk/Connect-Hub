package databases;

import enums.FriendshipStatus;
import entities.Friendship;
import enums.FriendshipType;
import java.util.ArrayList;
import java.util.stream.Collectors;


public class FriendshipDatabase extends DatabaseHandler<Friendship>{

    public FriendshipDatabase(){
        super(FilePaths.FRIENDSHIPS_FILEPATH, Friendship.class);
    }
 
    public ArrayList<Friendship> getRecordsOfUser(String userID) {
        ArrayList<Friendship> userFriendship = new ArrayList<>();
        for(Friendship friendship : records)
            if(friendship.getType() == FriendshipType.USERS)
                if(friendship.getSenderId().equals(userID) || friendship.getReceiverId().equals(userID))
                    userFriendship.add(friendship) ;
        return userFriendship;
    }
    
    public ArrayList<String> getRecordsIDsOfUser(String userID) {
        ArrayList<String> userFriendshipIDs = new ArrayList<>();
        for(Friendship friendship : records) {
            if(friendship.getType() == FriendshipType.USERS) {
                if(friendship.getSenderId().equals(userID))
                    userFriendshipIDs.add(friendship.getReceiverId()) ;
                else if(friendship.getReceiverId().equals(userID))
                    userFriendshipIDs.add(friendship.getSenderId()) ;
            }
        }
        return userFriendshipIDs;
    }
  
    public Friendship getFriendshipRequest(String senderID, String receiverID) {
        for(Friendship friendship : records)
            if(friendship.getSenderId().equals(senderID) 
                    && friendship.getReceiverId().equals(receiverID) 
                    && friendship.getStatus() == FriendshipStatus.PENDING
                    && friendship.getType() == FriendshipType.USERS)
                return friendship;
        return null;
    }
    
    // Returns relation between two users
    public Friendship getFriendshipOfTwoUsers(String userID1, String userID2) {
        for(Friendship friendship : records) {
            if(friendship.getType()== FriendshipType.USERS)
                if(
                (friendship.getSenderId().equals(userID1) && friendship.getReceiverId().equals(userID2)) ||
                (friendship.getSenderId().equals(userID2) && friendship.getReceiverId().equals(userID1))
                )return friendship;   
        }
        return null;
    }
    
    public Friendship getActiveFriendship(String userID1, String userID2) {
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
            if(friendship.getSenderId().equals(blockerID) 
                    && friendship.getReceiverId().equals(blockedID) 
                    && friendship.getStatus() == FriendshipStatus.BLOCKED
                    && friendship.getType() == FriendshipType.USERS)
                return friendship;
        return null;
    }
   
    public ArrayList<String> getReceivedRequests(String receiverID) {
        ArrayList<String> userRequests = new ArrayList<>();
        for(Friendship friendship : records)
            if(friendship.getReceiverId().equals(receiverID) 
                    && friendship.getStatus() == FriendshipStatus.PENDING
                    && friendship.getType() == FriendshipType.USERS)
                userRequests.add(friendship.getSenderId()) ;
        return userRequests;
    }
    
    public ArrayList<String> getSentRequests(String senderID) {
        ArrayList<String> userRequests = new ArrayList<>();
        for(Friendship friendship : records)
            if(friendship.getSenderId().equals(senderID) 
                    && friendship.getStatus() == FriendshipStatus.PENDING
                    && friendship.getType() == FriendshipType.USERS)
                userRequests.add(friendship.getReceiverId()) ;
        return userRequests;
    }
    
    public ArrayList<String> getFriendsIds(String userID) {
        ArrayList<String> friendsIDs = new ArrayList<>();
        for(Friendship friendship : records) {
            if(friendship.getStatus() == FriendshipStatus.ACCEPTED && friendship.getType() == FriendshipType.USERS) {
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
            if(friendship.getSenderId().equals(userID) 
                    && friendship.getStatus() == FriendshipStatus.BLOCKED
                    && friendship.getType() == FriendshipType.USERS) {
                blockedUsersIDs.add(friendship.getReceiverId()) ;
            }          
        }
        return blockedUsersIDs;
    }
    
    public ArrayList<String> getUsersBlockingCurrentUser(String userID) {
        ArrayList<String> usersBlockingCurrentUser = new ArrayList<>();
        for(Friendship friendship : records) {
            if(friendship.getReceiverId().equals(userID) 
                    && friendship.getStatus() == FriendshipStatus.BLOCKED 
                    && friendship.getType() == FriendshipType.USERS) {
                usersBlockingCurrentUser.add(friendship.getReceiverId()) ;
            }          
        }
        return usersBlockingCurrentUser;
    }
    
    
    // Get request to join a group
    public Friendship getGroupFriendShipRequest(String groupId, String userId) {
        for(Friendship friendship : records)
            if(friendship.getSenderId().equals(userId) 
                    && friendship.getReceiverId().equals(groupId) 
                    && friendship.getStatus() == FriendshipStatus.PENDING 
                    && friendship.getType() == FriendshipType.GROUPS)
                return friendship;
        return null;
    }
    
    
    // Returns all friendships of a group
    public ArrayList<Friendship> getGroupFriendships(String groupID) {
        return records.stream()
                .filter(friendship -> friendship.getReceiverId().equals(groupID) 
                        && friendship.getType() == FriendshipType.GROUPS)
                .collect(Collectors.toCollection(ArrayList::new));
    }
    
    // Returns all groups user is a member of
    public ArrayList<Friendship> getGroupsOfAUser(String userId) {
        return records.stream()
                .filter(friendship -> friendship.getSenderId().equals(userId) 
                        && friendship.getType() == FriendshipType.GROUPS
                        && friendship.getStatus() == FriendshipStatus.ACCEPTED)
                .collect(Collectors.toCollection(ArrayList::new));
    }
    
    // Returns all groups friendships of a user
    public ArrayList<Friendship> getAllGroupsFriendshipsOfAUser(String userId) {
        return records.stream()
                .filter(friendship -> friendship.getSenderId().equals(userId) 
                        && friendship.getType() == FriendshipType.GROUPS)
                .collect(Collectors.toCollection(ArrayList::new));
    }
    
    // Returns all group IDs of a user
    public ArrayList<String> getAllGroupsIdsOfAUser(String userId) {
        return records.stream()
                .filter(friendship -> friendship.getSenderId().equals(userId)
                        && friendship.getType() == FriendshipType.GROUPS)
                .map(friendship -> friendship.getReceiverId()) // Map to receiverId
                .collect(Collectors.toCollection(ArrayList::new)); // Collect as ArrayList
    }

    
    
        
}
