package entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentsNotification extends Notification {
    @JsonProperty("type")
    private final String type = "Comment";
    @JsonProperty
    private String senderName;

    public CommentsNotification() {
    }

    public CommentsNotification(User sender, String mainId) {
        super(mainId);
        this.senderName = sender.getUsername();
    }

    @Override
    public String getMessage() {
        return senderName + " Commented on your post.";
    }

}
