package entities;

import enums.ContentType;


public class ContentFactoryData {
    private final ContentType contentType;
    private String groupId;
    private final String authorId;
    private final String text;
    private final String imagePath;

    public ContentFactoryData(ContentType contentType, String authorId, String text, String imagePath) {
        this.contentType = contentType;
        this.authorId = authorId;
        this.text = text;
        this.imagePath = imagePath;
    }
    
    public ContentFactoryData(ContentType contentType, String groupId, String authorId, String text, String imagePath) {
        this.contentType = contentType;
        this.groupId = groupId;
        this.authorId = authorId;
        this.text = text;
        this.imagePath = imagePath;
    }
    

    public ContentType getContentType() {
        return contentType;
    }

    public String getAuthorId() {
        return authorId;
    }

    public String getText() {
        return text;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getGroupId() {
        return groupId;
    }
    
    
}
