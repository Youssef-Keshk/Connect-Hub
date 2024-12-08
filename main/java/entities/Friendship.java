package entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import statuses.FriendshipStatus;


public class Friendship {
    @JsonProperty
    private String senderId;
    @JsonProperty
    private String receiverId;
    @JsonProperty
    private FriendshipStatus status;
    
    public Friendship(){}
    
    Friendship(FriendshipBuilder builder) {
        this.senderId = builder.senderId;
        this.receiverId = builder.receiverId;
        this.status = builder.status;
    }
    
    public static FriendshipBuilder builder() {
        return new FriendshipBuilder();
    }

    public String getSenderId() {
        return senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }


    public FriendshipStatus getStatus() {
        return status;
    }

    public void setStatus(FriendshipStatus status) {
        this.status = status;
    }
    

    @Override
    public String toString() {
        return "Friendship{" + "senderID=" + senderId + ", receiverID=" + receiverId + ", status=" + status + '}';
    }
    
    
    
}
