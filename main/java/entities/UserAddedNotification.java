package entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserAddedNotification extends Notification{
    @JsonProperty("type")
    private final String type = "USER_ADDED";
    @JsonProperty
      private String user;
    @JsonProperty
      private String group;

    public UserAddedNotification() {
    }


    public UserAddedNotification(String user, String group, User main) {
        super(main);
        this.user = user;
        this.group = group;
    }

    @Override
    public String getMessage() {
        return user + "was added to" + group;
    }

}
