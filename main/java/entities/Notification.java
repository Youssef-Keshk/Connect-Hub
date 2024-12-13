package entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = FriendRequestNotification.class, name = "FRIEND_REQUEST"),
    @JsonSubTypes.Type(value = GroupStatusNotification.class, name = "GROUP_STATUS"),
    @JsonSubTypes.Type(value = PostNotification.class, name = "POST"),
    @JsonSubTypes.Type(value = UserAddedNotification.class, name = "USER_ADDED")
})
public abstract class Notification {
    @JsonProperty
    protected boolean isRead;
    @JsonProperty
    protected User main;

    public Notification() {
    }

    public Notification(User main) {
        this.main = main;
    }

    public String getUserId() {
        return main.getUserId();
    }
    public abstract String getMessage();
    public void markAsRead(){
        isRead = true;
    }
    public boolean isRead(){
        return isRead;
    }
}
