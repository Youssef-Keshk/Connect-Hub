package entities;

import enums.ContentType;


public class ContentFactory {
    
    public Content create(ContentFactoryData data) {
        if(data.getContentType().equals(ContentType.POST)) {
            return createPostContent(data);
        } else if(data.getContentType().equals(ContentType.STORY)) {
            return createStoryContent(data);
        }

        throw new IllegalStateException("Illegal content type: %s".formatted(data.getContentType().toString()));
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
}
