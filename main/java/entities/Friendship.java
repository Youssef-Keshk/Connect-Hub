package entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import enums.FriendshipStatus;
import enums.FriendshipType;


public class Friendship {
    @JsonProperty
    private String senderId;
    @JsonProperty
    private String receiverId;
    @JsonProperty
    private FriendshipStatus status;
    @JsonProperty
    private FriendshipType type;
    
    public Friendship(){}
    
    Friendship(FriendshipBuilder builder) {
        this.senderId = builder.senderId;
        this.receiverId = builder.receiverId;
        this.status = builder.status;
        this.type = builder.type;
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

    public FriendshipType getType() {
        return type;
    }
    
    public void setStatus(FriendshipStatus status) {
        this.status = status;
    }
    

    @Override
    public String toString() {
        return "Friendship{" + "senderID=" + senderId + ", receiverID=" + receiverId + ", status=" + status + '}';
    }
    
    
    
}
