package entities;

public class ContentFactory {
    
    public Content create(ContentFactoryData data) {
        switch (data.getContentType()) {
            case POST -> {
                return createPostContent(data);
            }
            case STORY -> {
                return createStoryContent(data);
            }
            case GROUP_POST -> {
                return createGroupPostContent(data);
            }
            default -> {
                throw new IllegalStateException("Illegal content type: %s".formatted(data.getContentType().toString()));
            }
        }
    }
    
    private Content createPostContent(ContentFactoryData data) {
        return new Post(
                data.getAuthorId(),
                data.getText(),
                data.getImagePath()
        );
    }

    private Content createStoryContent(ContentFactoryData data) {
        return new Story(
                data.getAuthorId(),
                data.getText(),
                data.getImagePath()
        );
    }
    
    private Content createGroupPostContent(ContentFactoryData data) {
        return new GroupPost(
                data.getGroupId(),
                data.getAuthorId(),
                data.getText(),
                data.getImagePath()
        );
    }
}
