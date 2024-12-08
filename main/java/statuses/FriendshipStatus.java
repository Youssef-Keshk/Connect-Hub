package statuses;


public enum FriendshipStatus {
    ACCEPTED("Accepted"),
    BLOCKED("Blocked"),
    PENDING("Pending");

    private final String displayName;

    FriendshipStatus(String displayName) {
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
