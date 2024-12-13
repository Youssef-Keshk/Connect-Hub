package entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.time.LocalDateTime;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = Post.class, name = "POST"),
    @JsonSubTypes.Type(value = Story.class, name = "STORY"),
    @JsonSubTypes.Type(value = GroupPost.class, name = "GROUP_POST")
})
public abstract class Content {
    @JsonProperty
    protected String contentId;
    @JsonProperty
    protected String authorId;
    @JsonProperty
    protected String text;
    @JsonProperty
    protected String imagePath;
    
    @JsonProperty
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    protected LocalDateTime publishDate;
    
    public Content(){}
    
    public Content(String contentId, String authorId, String text, String imagePath) {
        LocalDateTime currentTime = LocalDateTime.now();
        this.contentId = contentId;
        this.authorId = authorId;
        this.text = text;
        this.imagePath = imagePath;
        this.publishDate = currentTime;
    }
    

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public LocalDateTime getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDateTime publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "Content{" + "contentId=" + contentId + ", authorId=" + authorId + ", text=" + text + ", imagePath=" + imagePath + ", publishDate=" + publishDate + '}';
    }
 
    
}
