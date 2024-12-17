package entities;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Comment {
    @JsonProperty
    private String userId;
    @JsonProperty
    private String text;

    public Comment() {
    }

    public Comment(String userId, String text) {
        this.userId = userId;
        this.text = text;
    }

    public String getUserId() {
        return userId;
    }
    
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Comment{" + "userId=" + userId + ", text=" + text + '}';
    }

}
