package entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FriendRequestNotification extends Notification {
    @JsonProperty("type")
    private final String type = "FRIEND_REQUEST";
    @JsonProperty
    private String senderName;

    public FriendRequestNotification() {
    }

    public FriendRequestNotification(User sender, String mainId) {
        super(mainId);
        this.senderName = sender.getUsername();
    }

    @Override
    public String getMessage() {
        return senderName + " sent you a friend request.";
    }

}
