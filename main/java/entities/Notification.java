package entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = FriendRequestNotification.class, name = "FRIEND_REQUEST"),
    @JsonSubTypes.Type(value = GroupStatusNotification.class, name = "GROUP_STATUS"),
    @JsonSubTypes.Type(value = PostNotification.class, name = "POST"),
    @JsonSubTypes.Type(value = UserAddedNotification.class, name = "USER_ADDED"),
    @JsonSubTypes.Type(value = CommentsNotification.class, name = "Comment"),   
    @JsonSubTypes.Type(value = LikesNotification.class, name = "Like")        
})
public abstract class Notification {
    @JsonProperty
    protected boolean isRead;
    @JsonProperty
    protected String mainId;

    public Notification() {
    }

    public Notification(String mainId) {
        this.mainId = mainId;
    }

    public String getUserId() {
        return mainId;
    }
    public abstract String getMessage();
    public void markAsRead(){
        isRead = true;
    }
    public boolean isRead(){
        return isRead;
    }
}
