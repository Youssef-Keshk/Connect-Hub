package frontend;

import entities.User;
import java.awt.CardLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import managers.*;


public class MainFrame extends javax.swing.JFrame {
    private User user;
    
    // Managers
    private final AccountManager accountManager;
    private final FriendshipManager friendshipManager;
    private final ContentManager contentManager;
    private final NotificationManager notificationManager;
    
    private final CardLayout cardLayout;
    private final JPanel mainPanel;
    
    // Panels to be displayed as pages
    private final SignupPanel signupPanel;
    private final LoginPanel loginPanel;
    private final ProfilePanel profilePanel;
    private final NewsFeedPanel newsFeedPanel;
    private final FriendsPanel tmpPanel;
    private final NotificationsPanel notificationsPanel;
    
    public MainFrame() {
        
        user = null;
        accountManager =  AccountManager.getInstance();
        friendshipManager = FriendshipManager.getInstance();
        contentManager = ContentManager.getInstance();
        notificationManager = NotificationManager.getInstance();
        initComponents();
        
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        
        signupPanel = new SignupPanel(this);
        loginPanel = new LoginPanel(this);
        profilePanel = new ProfilePanel(this);
        newsFeedPanel = new NewsFeedPanel(this);
        tmpPanel = new FriendsPanel(this);
        notificationsPanel = new NotificationsPanel(this);
        
        setAllPanels();
        add(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                logout();
                System.exit(0);
            }
        });
    }
    
    private void refreshManagers() {
        accountManager.refresh();
        contentManager.refresh();
        friendshipManager.refresh();
        notificationManager.refresh();
    }
    
    private void setAllPanels() {
        mainPanel.add(signupPanel, "SignupPanel");
        mainPanel.add(loginPanel, "LoginPanel");
        mainPanel.add(profilePanel, "ProfilePanel");
        mainPanel.add(newsFeedPanel, "NewsFeedPanel");
        mainPanel.add(tmpPanel, "FriendsPanel");
        mainPanel.add(notificationsPanel, "NotificationsPanel");
       
    }
    
    public void switchToSignupPage() {
       refreshManagers();
       cardLayout.show(mainPanel, "SignupPanel");
       signupPanel.startSignup();
    }
    
    public void switchToLoginPage() {
        refreshManagers();
        cardLayout.show(mainPanel, "LoginPanel");
        loginPanel.startLogin();
    }
    
    public void switchToProfilePage() {
       refreshManagers();
       cardLayout.show(mainPanel, "ProfilePanel");
       profilePanel.startProfile();
       
    }
    
    public void switchToNewsFeedPage() {
        refreshManagers();
        cardLayout.show(mainPanel, "NewsFeedPanel");
        newsFeedPanel.startNewsFeed();
    }
    
    public void switchToFriendsPage() {
        refreshManagers();
        cardLayout.show(mainPanel, "FriendsPanel");   
        tmpPanel.startFriends();
    }
    
    public void switchToNotificationsPage() {
        refreshManagers();
        cardLayout.show(mainPanel, "NotificationsPanel");   
        notificationsPanel.startNotifications();
    }
    
    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public AccountManager getAccountManager() {
        return accountManager;
    }

    public FriendshipManager getFriendshipManager() {
        return friendshipManager;
    }
    
    public NotificationManager getNotificationManager() {
        return notificationManager;
    }

    public ContentManager getContentManager() {
        return contentManager;
    }
    
    public void updateUser() {
        user = accountManager.getRecord(user.getUserId());
    }
    
    
    public void logout() {
        if(user != null)
            accountManager.logout(user.getUserId());
        user = null;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Connect Hub");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame());
    }
  
       

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
