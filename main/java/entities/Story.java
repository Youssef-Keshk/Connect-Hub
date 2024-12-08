package entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import databases.StoryCount;


public class Story extends Content{
    @JsonProperty("type")
    private final String type = "story";
    
    public Story(){}
    
    public Story(String authorId, String text, String imagePath) {
        super("S" + new StoryCount().incrementAndGetCount(), authorId, text, imagePath);
    }

}
