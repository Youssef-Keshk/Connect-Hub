package enums;


public enum ContentType {
    STORY("Story"),
    POST("Post"),
    GROUP_POST("GroupPost");

    private final String type;

    ContentType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type;
    }
}
