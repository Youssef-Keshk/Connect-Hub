package entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;


public class ChatMessage {
    @JsonProperty
    private String messageSenderId;
    @JsonProperty
    private String message;
    @JsonProperty
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime timestamp;

    public ChatMessage() {}
        
    public ChatMessage(String messageSenderId, String message) {
        this.messageSenderId = messageSenderId;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public String getMessageSenderId() {
        return messageSenderId;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "ChatMessage{" + "messageSenderId=" + messageSenderId + ", message=" + message + ", timestamp=" + timestamp + '}';
    }

    
}
