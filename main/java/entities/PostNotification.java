package entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PostNotification extends Notification{
    @JsonProperty("type")
    private final String type = "POST";
    @JsonProperty
      private String sender;

    public PostNotification() {
    }

    public PostNotification(String sender, User main) {
        super(main);
        this.sender = sender;
    }

    @Override
    public String getMessage() {
        return sender + " Added a new post.";
    }

}
