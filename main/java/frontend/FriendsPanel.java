package frontend;

import entities.User;
import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import managers.FriendshipManager;
import managers.AccountManager;


public class FriendsPanel extends javax.swing.JPanel {
    private final MainFrame parent;
    private final AccountManager accountManager;
    private final FriendshipManager friendshipManager;
    
    public FriendsPanel(MainFrame parent) {
        this.parent = parent;
        accountManager = parent.getAccountManager();
        friendshipManager = parent.getFriendshipManager();
        initComponents();
    }
    
    public void startFriends() {
        resetPanels();
        viewFriends();
        viewRequests();
    }
    
    public void resetPanels() {
        containerPanel.removeAll();
        revalidate();
        repaint();
    }
    
    public void viewFriends() {
        JPanel friendsPanel = new JPanel();
        ArrayList<String> friendsIds = friendshipManager.getAllFriends(parent.getUser().getUserId());
       // Check if the list of friend IDs is empty
        if (friendsIds.isEmpty()) {
            // Display "No friends available" message
            JLabel noFriendsLabel = new JLabel("No friends available.", SwingConstants.CENTER);
            noFriendsLabel.setFont(new Font("Arial", Font.BOLD, 16));
            friendsPanel.setLayout(new BorderLayout());
            friendsPanel.add(noFriendsLabel, BorderLayout.CENTER);
        } else {
            // Create the list of friend User objects
            ArrayList<User> friends = new ArrayList<>();
            for (String id : friendsIds) {
                friends.add(accountManager.getRecord(id));
            }
            // Create or retrieve the AllFriendsPanel instance
            AllFriendsPanel allFriendPanel = new AllFriendsPanel(friends, parent, false);
            friendsPanel.setLayout(new BorderLayout());
            friendsPanel.add(allFriendPanel, BorderLayout.CENTER);
            
        }   
        containerPanel.add(friendsPanel, java.awt.BorderLayout.WEST);
    }
    
    public void viewRequests() {
        JPanel requestedPanel = new JPanel();
        ArrayList<String> requestedIds = friendshipManager.getAllSentFriends(parent.getUser().getUserId());
        
        // Check if the list of requested friend IDs is empty
        if (requestedIds.isEmpty()) {
            // Display "No friend requests available" message
            JLabel noRequestedLabel = new JLabel("No friend requests available.", SwingConstants.CENTER);
            noRequestedLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Optional: Customize font
            requestedPanel.setLayout(new BorderLayout());
            requestedPanel.add(noRequestedLabel, BorderLayout.CENTER);
        } else {
            // Create the list of requested User objects
            ArrayList<User> requested = new ArrayList<>();
            for (String id : requestedIds) {
                requested.add(accountManager.getRecord(id));
            }

            // Create or retrieve the AllRequestedPanel instance
            AllRequestedPanel allRequestedPanel = new AllRequestedPanel(requested, parent);
            requestedPanel.setLayout(new BorderLayout());
            requestedPanel.add(allRequestedPanel, BorderLayout.CENTER);
        }
        
        containerPanel.add(requestedPanel, java.awt.BorderLayout.EAST);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        containerPanel = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(200, 200, 200));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 255), 2, true));
        jPanel1.setMaximumSize(new java.awt.Dimension(89, 32767));
        jPanel1.setPreferredSize(new java.awt.Dimension(89, 400));

        backButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        backButton.setForeground(new java.awt.Color(102, 0, 255));
        backButton.setText("Back");
        backButton.setToolTipText("");
        backButton.setBorder(null);
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(356, Short.MAX_VALUE)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(jPanel1, java.awt.BorderLayout.WEST);

        containerPanel.setLayout(new java.awt.GridLayout(1, 0));
        add(containerPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        parent.switchToProfilePage();
    }//GEN-LAST:event_backButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JPanel containerPanel;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
