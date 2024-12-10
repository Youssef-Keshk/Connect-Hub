package enums;


public enum UserStatus {
    ONLINE("Online"),
    OFFLINE("Offline");

    private final String status;

    UserStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return status;
    }
}
