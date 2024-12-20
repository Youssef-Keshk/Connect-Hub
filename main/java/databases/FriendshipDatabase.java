package databases;

import enums.FriendshipStatus;
import entities.Friendship;
import enums.FriendshipType;
import iterators.FriendshipIterator;
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


    //(1)// Returns all user friendships of a status(used for all iterators)
    public Friendship[] getUserFriendshipsOfStatus(FriendshipStatus status) {
        ArrayList<Friendship> friendships = new ArrayList<>();
        for(Friendship record : records) 
            if(record.getType().equals(FriendshipType.USERS) && record.getStatus().equals(status))
                friendships.add(record);
        return friendships.toArray(Friendship[]::new);
    }

    //(2)// Returns all group friendships of a status(used for all iterators)
    public Friendship[] getGroupFriendshipsOfStatus(FriendshipStatus status) {
        ArrayList<Friendship> friendships = new ArrayList<>();
        for(Friendship record : records) 
            if(record.getType().equals(FriendshipType.GROUPS) && record.getStatus().equals(status))
                friendships.add(record);
        return friendships.toArray(Friendship[]::new);
    }

   
    //(1.1)// Iterator (interates over PENDING users)
    public Friendship getFriendshipRequest(String senderID, String receiverID) {
        Friendship[] friendships = getUserFriendshipsOfStatus(FriendshipStatus.PENDING);
        FriendshipIterator iterator = new FriendshipIterator(friendships);
        while(iterator.hasMore()) {
            Friendship friendship = iterator.getNext();
            if(friendship.getSenderId().equals(senderID) && friendship.getReceiverId().equals(receiverID))
                return friendship;
        }
        return null;
    }
    
    
    //(1.2)// Iterator (interates over BLOCKED users)
    public Friendship getBlockedFriendship(String blockerID, String blockedID) {
        Friendship[] friendships = getUserFriendshipsOfStatus(FriendshipStatus.BLOCKED);
        FriendshipIterator iterator = new FriendshipIterator(friendships);
        while(iterator.hasMore()) {
            Friendship friendship = iterator.getNext();
            if(friendship.getSenderId().equals(blockerID) && friendship.getReceiverId().equals(blockedID))
                return friendship;
        }
        return null;
    }
    
    
    //(1.3)// Iterator (interates over ACCEPTED users)
    public Friendship getActiveFriendship(String userID1, String userID2) {
        Friendship[] friendships = getUserFriendshipsOfStatus(FriendshipStatus.ACCEPTED);
        FriendshipIterator iterator = new FriendshipIterator(friendships);
        while(iterator.hasMore()) {
            Friendship friendship = iterator.getNext();
            if(
                (friendship.getSenderId().equals(userID1) && friendship.getReceiverId().equals(userID2)) ||
                (friendship.getSenderId().equals(userID2) && friendship.getReceiverId().equals(userID1))
                )return friendship;
        }
        return null;
    }
    
    
    //(1.4)// Iterator (interates over PENDING users)
    public ArrayList<String> getReceivedRequests(String receiverID) {
        Friendship[] friendships = getUserFriendshipsOfStatus(FriendshipStatus.PENDING);
        FriendshipIterator iterator = new FriendshipIterator(friendships);
        
        ArrayList<String> userRequests = new ArrayList<>();
        while(iterator.hasMore()) {
            Friendship friendship = iterator.getNext();
            if(friendship.getReceiverId().equals(receiverID))
                userRequests.add(friendship.getSenderId());
        }
        return userRequests;
    }
    
    
    //(1.5)// Iterator (interates over PENDING users)
    public ArrayList<String> getSentRequests(String senderID) {
        Friendship[] friendships = getUserFriendshipsOfStatus(FriendshipStatus.PENDING);
        FriendshipIterator iterator = new FriendshipIterator(friendships);
        
        ArrayList<String> userRequests = new ArrayList<>();
        while(iterator.hasMore()) {
            Friendship friendship = iterator.getNext();
            if(friendship.getSenderId().equals(senderID))
                userRequests.add(friendship.getReceiverId()) ;
        }
        return userRequests;
    }
    
    
    //(1.6)// Iterator (interates over ACCEPTED users)
    public ArrayList<String> getFriendsIds(String userID) {
        Friendship[] friendships = getUserFriendshipsOfStatus(FriendshipStatus.ACCEPTED);
        FriendshipIterator iterator = new FriendshipIterator(friendships);
        
        ArrayList<String> friendsIDs = new ArrayList<>();
        while(iterator.hasMore()) {
            Friendship friendship = iterator.getNext();
            if(friendship.getSenderId().equals(userID))
                friendsIDs.add(friendship.getReceiverId());
            else if(friendship.getReceiverId().equals(userID))
                friendsIDs.add(friendship.getSenderId());
        }
        return friendsIDs;
    }
    
    
    //(1.7)// Iterator (interates over BLOCKED users)
    public ArrayList<String> getBlockedUsers(String userID) {
        Friendship[] friendships = getUserFriendshipsOfStatus(FriendshipStatus.BLOCKED);
        FriendshipIterator iterator = new FriendshipIterator(friendships);
        
        ArrayList<String> blockedUsersIDs = new ArrayList<>();
        while(iterator.hasMore()) {
            Friendship friendship = iterator.getNext();
            if(friendship.getSenderId().equals(userID))
                blockedUsersIDs.add(friendship.getReceiverId());
        }
        return blockedUsersIDs;
    }
    
    
    //(1.8)// Iterator (interates over BLOCKED users)
    public ArrayList<String> getUsersBlockingCurrentUser(String userID) {
        Friendship[] friendships = getUserFriendshipsOfStatus(FriendshipStatus.BLOCKED);
        FriendshipIterator iterator = new FriendshipIterator(friendships);
        
        ArrayList<String> usersBlockingCurrentUser = new ArrayList<>();
        while(iterator.hasMore()) {
            Friendship friendship = iterator.getNext();
            if(friendship.getReceiverId().equals(userID))
                usersBlockingCurrentUser.add(friendship.getReceiverId());
        }
        return usersBlockingCurrentUser;
    }

    
    //(2.1)// Iterator (interates over PENDING groups)
    // Get request to join a group
    public Friendship getGroupFriendShipRequest(String groupId, String userId) {
        Friendship[] friendships = getGroupFriendshipsOfStatus(FriendshipStatus.PENDING);
        FriendshipIterator iterator = new FriendshipIterator(friendships);
        
        while(iterator.hasMore()) {
            Friendship friendship = iterator.getNext();
            if(friendship.getSenderId().equals(userId) && friendship.getReceiverId().equals(groupId))
                return friendship;
        }
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
