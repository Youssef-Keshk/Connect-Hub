package entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import databases.StoryCount;
import enums.ContentType;


public class Story extends Content{
    @JsonProperty("type")
    private final ContentType type = ContentType.STORY;
    
    public Story(){}
    
    public Story(String authorId, String text, String imagePath) {
        super("S" + new StoryCount().incrementAndGetCount(), authorId, text, imagePath);
    }

}
