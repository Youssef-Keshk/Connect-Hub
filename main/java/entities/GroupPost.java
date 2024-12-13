package entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import databases.GroupPostCount;

public class GroupPost extends Content{
    @JsonProperty
    private String groupId;
 
    public GroupPost(){}
    
    public GroupPost(String groupId, String authorId, String text, String imagePath) {
        super("GP" + new GroupPostCount().incrementAndGetCount(), authorId, text, imagePath);
        this.groupId = groupId;  
    }

    public String getGroupId() {
        return groupId;
    }
    
}
