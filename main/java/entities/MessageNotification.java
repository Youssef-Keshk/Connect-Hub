package entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageNotification extends Notification {
    @JsonProperty("type")
    private final String type = "Message";
    @JsonProperty
    private String senderName;

    public MessageNotification() {
    }

    public MessageNotification(User sender, String mainId) {
        super(mainId);
        this.senderName = sender.getUsername();
    }

    @Override
    public String getMessage() {
        return senderName + "Sent you a message.";
    }

}