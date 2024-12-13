package enums;


public enum FriendshipType {
    USERS("Users"),
    GROUPS("Groups");

    private final String displayName;

    FriendshipType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
