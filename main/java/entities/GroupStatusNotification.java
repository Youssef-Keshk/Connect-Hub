package entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupStatusNotification extends Notification{
    @JsonProperty("type")
    private final String type = "GROUP_STATUS";
    @JsonProperty    
    private String group;

    public GroupStatusNotification() {
    }

    public GroupStatusNotification(String group, User main) {
        super(main);
        this.group = group;
    }

    @Override
    public String getMessage() {
        return group + " status changed.";
    }
}
