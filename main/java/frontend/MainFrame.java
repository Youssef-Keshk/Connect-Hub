package frontend;

import entities.Group;
import entities.User;
import java.awt.CardLayout;
import java.awt.Dimension;
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
    private final GroupManager groupManager;
    private final GroupContentManager groupContentManager;
    
    private final CardLayout cardLayout;
    private final JPanel mainPanel;
    
    // Panels to be displayed as pages
    private final SignupPanel signupPanel;
    private final LoginPanel loginPanel;
    private final ProfilePanel profilePanel;
    private final NewsFeedPanel newsFeedPanel;
    private final FriendsPanel friendsPanel;
    private final SearchPanel searchPanel;
    private final RandomGroupProfilePanel groupProfilePanel;
    private final RandomUserProfilePanel userProfilePanel;
    private final NotificationsPanel notificationsPanel;

    
    public MainFrame() {
        
        user = null;
        accountManager =  AccountManager.getInstance();
        friendshipManager = FriendshipManager.getInstance();
        contentManager = ContentManager.getInstance();
        groupManager = GroupManager.getInstance();
        groupContentManager = GroupContentManager.getInstance();
        notificationManager = NotificationManager.getInstance();
      
        initComponents();
        
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        
        signupPanel = new SignupPanel(this);
        loginPanel = new LoginPanel(this);
        profilePanel = new ProfilePanel(this);
        newsFeedPanel = new NewsFeedPanel(this);
        friendsPanel = new FriendsPanel(this);
        searchPanel = new SearchPanel(this);
        groupProfilePanel = new RandomGroupProfilePanel(this);
        userProfilePanel = new RandomUserProfilePanel(this);
        notificationsPanel = new NotificationsPanel(this);
        
        setAllPanels();
        add(mainPanel);
        
        setPreferredSize(new Dimension(640, 450));
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
        groupManager.refresh();
        groupContentManager.refresh();
        notificationManager.refresh();

    }
    
    private void setAllPanels() {
        mainPanel.add(signupPanel, "SignupPanel");
        mainPanel.add(loginPanel, "LoginPanel");
        mainPanel.add(profilePanel, "ProfilePanel");
        mainPanel.add(newsFeedPanel, "NewsFeedPanel");
        mainPanel.add(friendsPanel, "FriendsPanel");
        mainPanel.add(searchPanel, "SearchPanel");
        mainPanel.add(groupProfilePanel, "RandomGroupProfilePanel");
        mainPanel.add(userProfilePanel, "RandomUserProfilePanel");
        mainPanel.add(notificationsPanel, "NotificationsPanel");
       
    }
    
    public void switchToSignupPage() {
       refreshManagers();
       cardLayout.show(mainPanel, "SignupPanel");
       resizeFrame(new Dimension(640, 450));
       signupPanel.startSignup();
    }
    
    public void switchToLoginPage() {
        refreshManagers();
        cardLayout.show(mainPanel, "LoginPanel");
        resizeFrame(new Dimension(640, 450));
        loginPanel.startLogin();
    }
    
    public void switchToProfilePage() {
       refreshManagers();
       cardLayout.show(mainPanel, "ProfilePanel");
       resizeFrame(new Dimension(700, 600));
       profilePanel.startProfile();
       
    }
    
    public void switchToNewsFeedPage() {
        refreshManagers();
        cardLayout.show(mainPanel, "NewsFeedPanel");
        resizeFrame(new Dimension(1000, 600));
        newsFeedPanel.startNewsFeed();
    }
    
    public void switchToFriendsPage() {
        refreshManagers();
        cardLayout.show(mainPanel, "FriendsPanel");   
        resizeFrame(new Dimension(1000, 600));
        friendsPanel.startFriends();
    }
    
    public void switchToSearchPage() {
       refreshManagers();
       cardLayout.show(mainPanel, "SearchPanel");
       resizeFrame(new Dimension(640, 450));
       searchPanel.startSearch();
    }
    
    
    public void switchToRandomUserProfile(User user) {
        refreshManagers();
       cardLayout.show(mainPanel, "RandomUserProfilePanel");
       resizeFrame(new Dimension(650, 500));
       userProfilePanel.startProfile(user);
        
    }
    
    public void switchToRandomGroupProfile(Group searchedGroup) {
       refreshManagers();
       cardLayout.show(mainPanel, "RandomGroupProfilePanel");
       resizeFrame(new Dimension(650, 500));
       groupProfilePanel.startGroupProfile(searchedGroup,
               friendshipManager.getGroupRequests(searchedGroup.getGroupId()).contains(user.getUserId()) 
                       || searchedGroup.getMembersIds().contains(user.getUserId()));
        
    }
    
    public void switchToNotificationsPage() {
        refreshManagers();
        cardLayout.show(mainPanel, "NotificationsPanel");   
        resizeFrame(new Dimension(1000, 600));
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

    public GroupManager getGroupManager() {
        return groupManager;
    }

    public GroupContentManager getGroupContentManager() {
        return groupContentManager;
    }
    
    
    public void updateUser() {
        user = accountManager.getRecord(user.getUserId());
    }    
    
    public void logout() {
        if(user != null)
            accountManager.logout(user.getUserId());
        user = null;
    }
    
    private void resizeFrame(Dimension dimension) {
       setPreferredSize(dimension);
       pack();
       setLocationRelativeTo(null);
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
