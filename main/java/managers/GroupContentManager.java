package managers;

import databases.GroupContentDatabase;
import entities.GroupPost;
import java.util.ArrayList;


public class GroupContentManager implements Manager{
    private static GroupContentManager instance;
    private final GroupContentDatabase groupContentDatabase;

    public static GroupContentManager getInstance() {
        if(instance == null) {
            instance = new GroupContentManager();
        }
        return instance;
    } 
    
    private GroupContentManager() {
        groupContentDatabase = new GroupContentDatabase();
    }
    
    @Override
    public void refresh() {
        groupContentDatabase.refreshRecords();
    }

    @Override
    public void save() {
      groupContentDatabase.saveRecords();
    }
    
    // Addes new group post to records
    public boolean addGroupPost(GroupPost groupPost) {
        return groupContentDatabase.insertRecord(groupPost);
    }
    
    // Edit text of a group post
    public boolean editGroupPostImage(String contentId, String newImagePath) {
        GroupPost groupPost = getRecord(contentId);
        if(groupPost == null)
            return false;
        groupPost.setImagePath(newImagePath);
        save();
        return true;
    }
    
    // Edit image of a group post
    public boolean editGroupPostText(String contentId, String newText) {
        GroupPost groupPost = getRecord(contentId);
        if(groupPost == null)
            return false;
        groupPost.setText(newText);
        save();
        return true;
    }
    
    // Edit text and image of a group post
    public boolean editGroupPost(String contentId, String newText, String newImagePath) {
        GroupPost groupPost = getRecord(contentId);
        if(groupPost == null)
            return false;
        groupPost.setText(newText);
        groupPost.setImagePath(newImagePath);
        save();
        return true;
    }
    
    public boolean deleteGroupPost(String contentId) {
        GroupPost groupPost = getRecord(contentId);
        if(groupPost == null)
            return false;
        return groupContentDatabase.removeRecord(groupPost);
    }
    
    // Returns post by post id
    public GroupPost getRecord(String contentId) {
        return groupContentDatabase.getPost(contentId);
    }
    
    // Fetches all posts of a group
    public ArrayList<GroupPost> getPosts(String groupID) {
        return groupContentDatabase.getPosts(groupID);
    } 
    
    
    
}
