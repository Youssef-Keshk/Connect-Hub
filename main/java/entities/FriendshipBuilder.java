package entities;

import statuses.FriendshipStatus;

// Builder creational pattern for Friendship
public class FriendshipBuilder {
    public String senderId;
    public String receiverId;
    public FriendshipStatus status;
    
    public FriendshipBuilder senderId(String senderId) {
            this.senderId = senderId;
            return this;
        }

    public FriendshipBuilder receiverId(String receiverId) {
        this.receiverId = receiverId;
        return this;
    }

    public FriendshipBuilder status(FriendshipStatus status) {
        this.status = status;
        return this;
    }

    public Friendship build() {
        return new Friendship(this);
    }
}
