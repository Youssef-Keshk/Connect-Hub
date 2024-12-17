package entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.time.LocalDateTime;
import java.util.ArrayList;

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
    protected ArrayList<Like> likes;
    @JsonProperty
    protected ArrayList<Comment> comments;
    
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
        this.likes = new ArrayList<>();
        this.comments = new ArrayList<>();
    }
    

    public String getContentId() {
        return contentId;
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

    public ArrayList<Like> getLikes() {
        return likes;
    }
    
    public Like getLike(String userId) {
        for(Like like : likes) 
            if(like.getUserId().equals(userId))
                return like;
        return null;
    }
    
    public ArrayList<Comment> getComments() {
        return comments;
    }
    
    public Comment getComment(String userId, String text) {
        for(Comment comment : comments)
            if(comment.getUserId().equals(userId) && comment.getText().equals(text))
                return comment;
        return null;
    }
    
    public void addComment(Comment comment) {
        comments.add(comment);
    }
    
    public void addLike(Like like) {
        likes.add(like);
    }
    
    public void deleteComment(Comment comment) {
        comments.remove(comment);
    }
    
    public void removeLike(Like like) {
        likes.remove(like);
    }

    @Override
    public String toString() {
        return "Content{" + "contentId=" + contentId + ", authorId=" + authorId + ", text=" + text + ", imagePath=" + imagePath + ", likes=" + likes + ", comments=" + comments + ", publishDate=" + publishDate + '}';
    }

 
    
}
