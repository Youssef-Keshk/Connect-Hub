package managers;

import entities.Story;
import databases.ContentDatabase;
import entities.Comment;
import entities.Content;
import entities.ContentFactory;
import entities.ContentFactoryData;
import entities.Like;
import entities.Post;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import enums.ContentType;

public class ContentManager implements Manager{
    private static ContentManager instance;
    private final ContentDatabase contentDatabase;

    // Singleton
    public static ContentManager getInstance() {
        if(instance == null) {
            instance = new ContentManager();
        }
        return instance;
    }
    
    private ContentManager() {
        contentDatabase = new ContentDatabase();
    }
    
    
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
    
    // Method to add a like to a content
    public boolean addLike(String contentId, String userId) {
        Content content = contentDatabase.getContent(contentId);
        try {
            Like like = new Like(userId);
            content.addLike(like);
            save();
        }catch(NullPointerException e) {
            System.out.println("Error finding content " + e.getMessage());
            return false;
        }
        return true;
    }
    
    // Method to remove a like of a content
    public boolean removeLike(String contentId, String userId) {
        Content content = contentDatabase.getContent(contentId);
        try {
            Like like = content.getLike(userId);
            content.removeLike(like);
            save();
        }catch(NullPointerException e) {
            System.out.println("Error finding content or like " + e.getMessage());
            return false;
        }
        return true;
    }
    
    // Method to add comment to a content
    public boolean addComment(String contentId, String userId, String text) {
        Content content = contentDatabase.getContent(contentId);
        try {
            Comment comment = new Comment(userId, text);
            content.addComment(comment);
            save();
        }catch(NullPointerException e) {
            System.out.println("Error finding content " + e.getMessage());
            return false;
        }
        return true;
    }

    // Method to add comment to a content
    public boolean removeComment(String contentId, String userId, String text) {
        Content content = contentDatabase.getContent(contentId);
        try {
            Comment comment = content.getComment(userId, text);
            content.deleteComment(comment);
            save();
        }catch(NullPointerException e) {
            System.out.println("Error finding content or comment" + e.getMessage());
            return false;
        }
        return true;
    }
    
    public void createContent(ContentType type, String userId, String text, String path) {
        ContentFactoryData contentFactoryData= new ContentFactoryData(type, userId, text, path);
        ContentFactory contentFactory = new ContentFactory();
        Content content = contentFactory.create(contentFactoryData);
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

    @Override
    public void refresh() {
        contentDatabase.refreshRecords();
    }

    @Override
    public void save() {
        contentDatabase.saveRecords();
    }
    
    

    
}
