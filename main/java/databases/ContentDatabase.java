package databases;

import entities.Post;
import entities.Story;
import entities.Content;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.stream.Collectors;


public class ContentDatabase extends DatabaseHandler<Content>{
    
    public ContentDatabase(){
        super(FilePaths.CONTENT_FILEPATH, Content.class);
        filterContent();
        saveRecords();
    }
    
    public ArrayList<Post> getPosts(String authorID) {
        return records.stream()
                .filter(content -> content instanceof Post && content.getAuthorId().equals(authorID))
                .map(content -> (Post) content)
                .collect(Collectors.toCollection(ArrayList::new));
    }
    
    public ArrayList<Story> getStories(String authorID) {
        filterContent();
        return records.stream()
                .filter(content -> content instanceof Story && content.getAuthorId().equals(authorID))
                .map(content -> (Story) content)
                .collect(Collectors.toCollection(ArrayList::new));
    }
    
    public ArrayList<Post> getFriendsPosts(ArrayList<String> friendsIDs) {
        return records.stream()
                .filter(content -> content instanceof Post && friendsIDs.contains(content.getAuthorId()))
                .map(content -> (Post) content)
                .collect(Collectors.toCollection(ArrayList::new));
    }
    
    public ArrayList<Story> getFriendsStories(ArrayList<String> friendsIDs) {
        filterContent();
        return records.stream()
                .filter(content -> content instanceof Story && friendsIDs.contains(content.getAuthorId()))
                .map(content -> (Story) content)
                .collect(Collectors.toCollection(ArrayList::new));
    }
    
    public void filterContent() {
    records = records.stream()
        .filter(content -> {
            if (content instanceof Story) {
                Duration duration = Duration.between(content.getPublishDate(), LocalDateTime.now());
                return duration.toHours() < 24; //Keep stories that are less than 24 hours old
            }
            return true;
        })
        .collect(Collectors.toCollection(ArrayList::new));
}

}
