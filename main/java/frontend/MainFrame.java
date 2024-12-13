package frontend;

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
//    private final SearchPanel searchPanel;
//    private final NoficationsPanel noficationsPanel;
    
    public MainFrame() {
        
        user = null;
        accountManager =  AccountManager.getInstance();
        friendshipManager = FriendshipManager.getInstance();
        contentManager = ContentManager.getInstance();
        groupManager = GroupManager.getInstance();
        groupContentManager = GroupContentManager.getInstance();
        
        initComponents();
        
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        
        signupPanel = new SignupPanel(this);
        loginPanel = new LoginPanel(this);
        profilePanel = new ProfilePanel(this);
        newsFeedPanel = new NewsFeedPanel(this);
        friendsPanel = new FriendsPanel(this);
//        searchPanel = new SearchPanel(this);
//        noficationsPanel = new NoficationsPanel(this);
        
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
    }
    
    private void setAllPanels() {
        mainPanel.add(signupPanel, "SignupPanel");
        mainPanel.add(loginPanel, "LoginPanel");
        mainPanel.add(profilePanel, "ProfilePanel");
        mainPanel.add(newsFeedPanel, "NewsFeedPanel");
        mainPanel.add(friendsPanel, "FriendsPanel");
//        mainPanel.add(searchPanel, "SearchPanel");
//        mainPanel.add(noficationsPanel, "NoficationsPanel");
       
    }
    
    public void switchToSignupPage() {
       refreshManagers();
       cardLayout.show(mainPanel, "SignupPanel");
       setPreferredSize(new Dimension(640, 450));
       pack();
       signupPanel.startSignup();
    }
    
    public void switchToLoginPage() {
        refreshManagers();
        cardLayout.show(mainPanel, "LoginPanel");
        setPreferredSize(new Dimension(640, 450));
        pack();
        loginPanel.startLogin();
    }
    
    public void switchToProfilePage() {
       refreshManagers();
       cardLayout.show(mainPanel, "ProfilePanel");
       setPreferredSize(new Dimension(1000, 600));
       pack();
       profilePanel.startProfile();
       
    }
    
    public void switchToNewsFeedPage() {
        refreshManagers();
        cardLayout.show(mainPanel, "NewsFeedPanel");
        setPreferredSize(new Dimension(1000, 600));
        pack();
        newsFeedPanel.startNewsFeed();
    }
    
    public void switchToFriendsPage() {
        refreshManagers();
        cardLayout.show(mainPanel, "FriendsPanel");   
        setPreferredSize(new Dimension(1000, 600));
        pack();
        friendsPanel.startFriends();
    }
    
    public void switchToSearchPage() {
//        resizeFrame(SearchPanel);
        refreshManagers();
//        cardLayout.show(mainPanel, "SearchPanel");   
//        searchPanel.startSearch();
    }
    
    public void switchToNoficationsPage() {
//        resizeFrame(noficationsPanel);
        refreshManagers();
//        cardLayout.show(mainPanel, "NoficationsPanel");   
//        noficationsPanel.startNofications();
    }
    
    public void switchToRandomUserProfile(String userID) {
//        resizeFrame();
        
    }
    
    public void switchToRandomGroupProfile(String groupID) {
//        resizeFrame();
        
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
    
    private void resizeFrame(JPanel panel) {
    Dimension preferredSize = panel.getPreferredSize();
    if (preferredSize == null || preferredSize.width == 0 || preferredSize.height == 0) {
        preferredSize = new Dimension(600, 400);
    }
    setSize(preferredSize.width, preferredSize.height);
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
