package entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import databases.PostCount;


public class Post extends Content{
    @JsonProperty("type")
    private final String type = "post";
    
    public Post(){}
    
    public Post(String authorId, String text, String imagePath) {
        super("P" + new PostCount().incrementAndGetCount(), authorId, text, imagePath);
    }
    
    
}
