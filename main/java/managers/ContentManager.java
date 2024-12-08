package managers;

import entities.Story;
import databases.ContentDatabase;
import entities.Content;
import entities.Post;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ContentManager {
    private final ContentDatabase contentDatabase = new ContentDatabase();
    
    
    public ArrayList<Story> getStories(String userID) {
        return contentDatabase.getStories(userID);
    }
    
    public ArrayList<Post> getPosts(String userID) {
        return contentDatabase.getPosts(userID);
    }
    
    public boolean addPost(Post post) {
        return contentDatabase.insertRecord(post);
    }
    
    public boolean addStory(Story story) {
        return contentDatabase.insertRecord(story);
    }
    
    public ArrayList<Content> get() {
        return contentDatabase.getAllRecords();
    }
    
    public void createContent(Content content) {
        contentDatabase.insertRecord(content);
    }
    
    public ArrayList<Post> getFriendsPosts(ArrayList<String> friendsIDs) {
        ArrayList<Post> friendsPosts = new ArrayList<>();
        Set<String> friendsSet = new HashSet<>(friendsIDs);
        ArrayList<Content> allContent = contentDatabase.getAllRecords();

        for (Content content : allContent) {
            if (content instanceof Post post) {
                if (friendsSet.contains(content.getAuthorId())) {
                    friendsPosts.add(post);
                }
            }
        }

        return friendsPosts;
        }
    
    public ArrayList<Story> getFriendsStories(ArrayList<String> friendsIDs) {
        ArrayList<Story> friendsStories = new ArrayList<>();
        Set<String> friendsSet = new HashSet<>(friendsIDs);
        ArrayList<Content> allContent = contentDatabase.getAllRecords();

        for (Content content : allContent) {
            if (content instanceof Story story) {
                if (friendsSet.contains(content.getAuthorId())) {
                    friendsStories.add(story);
                }
            }
        }

        return friendsStories;
    }

    
}
