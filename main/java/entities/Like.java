package entities;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Like {
    @JsonProperty
    private String userId;

    public Like() {}

    public Like(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "Like{" + "userId=" + userId + '}';
    }
       
}
