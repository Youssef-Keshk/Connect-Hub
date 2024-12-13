package managers;

import databases.NotificationDatabase;
import entities.*;
import java.util.ArrayList;
import java.util.List;

public class NotificationManager implements Manager{
    private static NotificationManager instance;
    private final NotificationDatabase notificationDatabase;

    // Singleton
    public static NotificationManager getInstance() {
        if(instance == null) {
            instance = new NotificationManager();
        }
        return instance;
    }
    
    public NotificationManager() {
        notificationDatabase = new NotificationDatabase();
    }
    public void createRequestNotification(User sender, User reciever){
        sendNotification(new FriendRequestNotification(sender, reciever));
    }

    public void sendNotification(Notification notification) {
        notificationDatabase.addNotification(notification);
    }

    public ArrayList <Notification> getAllNotifications(String userId) {
        return notificationDatabase.getAllNotifications(userId);
    }

    public List<Notification> getUnreadNotifications(String userId) {
        return notificationDatabase.getUnreadNotifications(userId);
    }
    
     @Override
    public void refresh() {
        notificationDatabase.refreshRecords();
    }

    @Override
    public void save() {
        notificationDatabase.saveRecords();
    }

    public void markAllAsRead(String userId) {
        notificationDatabase.markAllAsRead(userId);
    }

}
