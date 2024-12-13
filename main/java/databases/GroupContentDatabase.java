package databases;

import entities.GroupPost;
import java.util.ArrayList;
import java.util.stream.Collectors;


public class GroupContentDatabase extends DatabaseHandler<GroupPost>{

    public GroupContentDatabase() {
        super(FilePaths.GROUPS_POSTS_FILEPATH, GroupPost.class);
        saveRecords();
    }
    
    // Returns all posts of a specific group
    public ArrayList<GroupPost> getPosts(String groupID) {
        return records.stream()
                .filter(groupPost -> groupPost.getGroupId().equals(groupID))
                .collect(Collectors.toCollection(ArrayList::new));
    }
    
    // Return a specific post of a specific group
    public GroupPost getPost(String contentId) {
        for(GroupPost record : records) 
            if(record.getContentId().equals(contentId))
                return record;
        return null;
    }
    
    // Returns all posts of a specific author and group
    public ArrayList<GroupPost> getPostsOfMember(String groupID, String authorId) {
        return getPosts(groupID).stream()
                .filter(groupPost -> groupPost.getAuthorId().equals(authorId))
                .collect(Collectors.toCollection(ArrayList::new));
    }
    
}
