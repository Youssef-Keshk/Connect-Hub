package entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FriendRequestNotification extends Notification {
    @JsonProperty("type")
    private final String type = "FRIEND_REQUEST";
    @JsonProperty
    private User sender;

    public FriendRequestNotification() {
    }

    public FriendRequestNotification(User sender, User main) {
        super(main);
        this.sender = sender;
    }

    @Override
    public String getMessage() {
        return sender.getUsername() + " sent you a friend request.";
    }

}
