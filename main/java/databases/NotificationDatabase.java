package databases;

import java.util.ArrayList;
import java.util.List;
import entities.Notification;

public class NotificationDatabase extends DatabaseHandler<Notification> {

    public NotificationDatabase() {
        super(FilePaths.NOTIFICATIONS_FILEPATH, Notification.class);
    }

    public boolean addNotification(Notification notification) {
        return insertRecord(notification);
    }
    

    public ArrayList<Notification> getAllNotifications(String userId) {
        ArrayList<Notification> allNotifications = new ArrayList<>();
        for (Notification notification : records) {
            if (notification.getUserId() != null && notification.getUserId().equals(userId)) {
                allNotifications.add(notification);
            }
        }
        return allNotifications;
    }

    public ArrayList<Notification> getUnreadNotifications(String userId) {
        ArrayList<Notification> unreadNotifications = new ArrayList<>();
        for (Notification notification : records) {
            if (notification.getUserId().equals(userId) && !notification.isRead()) {
                unreadNotifications.add(notification);
            }
        }
        return unreadNotifications;
    }

    public void markAllAsRead(String userId) {
        for (Notification notification : records) {
            if (notification.getUserId().equals(userId)) {
                notification.markAsRead();
            }
        }
        saveRecords();
    }
}
