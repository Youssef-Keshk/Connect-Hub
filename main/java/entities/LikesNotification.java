package entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LikesNotification extends Notification {
    @JsonProperty("type")
    private final String type = "Like";
    @JsonProperty
    private String senderName;
    @JsonProperty
    private String postId;

    public LikesNotification() {
    }

    public LikesNotification(User sender, String mainId, String postId) {
        super(mainId);
        this.senderName = sender.getUsername();
        this.postId = postId;
    }

    public String getPostId() {
        return postId;
    }
    
    @Override
    public String getMessage() {
        return senderName + " Liked your post.";
    }

}
