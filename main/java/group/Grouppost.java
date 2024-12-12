package group;

import entities.Post;

public class Grouppost extends Post {
    private String groupid;
    public Grouppost(String groupid,Post post) {
        super();
        this.contentId = post.getContentId();
        this.text = post.getText();
        this.groupid=groupid;
        this.authorId = post.getAuthorId();
        this.imagePath = post.getImagePath();
    }
    public String getGroupid() {
        return groupid;
    }

}
