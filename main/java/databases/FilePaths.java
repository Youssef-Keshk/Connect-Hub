package databases;

// Modify these paths

public interface FilePaths {
    final String RESOURCES_DIRECTORY = "src/main/java/resources/";
    final String ICONS_DIRECTORY = "src/main/java/icons/";
    
    final String USERS_FILEPATH = RESOURCES_DIRECTORY + "users.json";
    final String GROUPS_FILEPATH = RESOURCES_DIRECTORY + "groups.json";
    final String CONTENT_FILEPATH = RESOURCES_DIRECTORY + "content.json";
    final String FRIENDSHIPS_FILEPATH = RESOURCES_DIRECTORY + "friendships.json";
    final String NOTIFICATIONS_FILEPATH = RESOURCES_DIRECTORY + "notifications.json";
    final String GROUPS_POSTS_FILEPATH = RESOURCES_DIRECTORY + "groupsPosts.json";
    
    final String USERS_COUNT_FILEPATH = RESOURCES_DIRECTORY + "usersCount.txt";
    final String GROUPS_COUNT_FILEPATH = RESOURCES_DIRECTORY + "groupsCount.txt";
    final String POSTS_COUNT_FILEPATH = RESOURCES_DIRECTORY + "postsCount.txt";
    final String STORIES_COUNT_FILEPATH = RESOURCES_DIRECTORY + "storiesCount.txt"; 
    
    final String DEFAUL_USER_PHOTO = ICONS_DIRECTORY + "defaultProfilePhoto.png";
    final String LEFT_ARROW_ICON = ICONS_DIRECTORY + "left.png";
    final String RIGHT_ARROW_ICON = ICONS_DIRECTORY + "right.png";
    final String UPLOAD_PHOTO_ICON = ICONS_DIRECTORY + "uploadPhoto.png";
    final String LIKE_PHOTO_FILEPATH = ICONS_DIRECTORY + "like.png";
    final String FILLED_LIKE_PHOTO_FILEPATH = ICONS_DIRECTORY + "filledLike.png";
    final String SEND_ICON_FILEPATH = ICONS_DIRECTORY + "sendIcon.png";

}