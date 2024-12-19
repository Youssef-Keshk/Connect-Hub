package entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

public class Chat {
    @JsonProperty
    private final ArrayList<ChatMessage> messages;

    
    public Chat() {
        this.messages = new ArrayList<>();
    }
    
    public void addMessage(String messageSenderId, String message) {
        messages.add(new ChatMessage(messageSenderId, message));
    }

    public ArrayList<ChatMessage> getMessages() {
        return messages;
    }

    @Override
    public String toString() {
        return "Chat{" + "messages=" + messages + '}';
    }
    
}
