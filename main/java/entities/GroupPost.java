package entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import databases.GroupPostCount;
import enums.ContentType;

public class GroupPost extends Content{
    @JsonProperty
    private String groupId;
    @JsonProperty("type")
    private final ContentType type = ContentType.GROUP_POST;
 
    public GroupPost(){}
    
    public GroupPost(String groupId, String authorId, String text, String imagePath) {
        super("GP" + new GroupPostCount().incrementAndGetCount(), authorId, text, imagePath);
        this.groupId = groupId;  
    }

    public String getGroupId() {
        return groupId;
    }
    
}
