package entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import databases.PostCount;
import enums.ContentType;

public class Post extends Content{
    @JsonProperty("type")
    private final ContentType type = ContentType.POST;
    
    public Post(){}
    
    public Post(String authorId, String text, String imagePath) {
        super("P" + new PostCount().incrementAndGetCount(), authorId, text, imagePath);
    }
        
}
