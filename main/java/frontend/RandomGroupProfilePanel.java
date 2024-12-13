package frontend;

import entities.Group;
import entities.GroupPost;
import entities.User;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.MediaTracker;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import managers.*;


public class RandomGroupProfilePanel extends javax.swing.JPanel {
    private final MainFrame parent;
    private User mainUser;
    private Group searchedGroup;
    private boolean isMember;
    private final GroupContentManager groupContentManager;
    private final GroupManager groupManager;
    private final FriendshipManager friendshipManager;
    
    public RandomGroupProfilePanel(MainFrame parent) {
        this.parent = parent;

        groupContentManager = parent.getGroupContentManager();
        groupManager = parent.getGroupManager();
        friendshipManager = parent.getFriendshipManager();
        
        initComponents();
        postsPanel.setLayout(new javax.swing.BoxLayout(postsPanel, javax.swing.BoxLayout.Y_AXIS));
        
    }
    
    public void startGroupProfile(Group searchedGroup, boolean isMember) {
        this.isMember = isMember;
        if(isMember)
            accessButton.setText("Leave");
        else
            accessButton.setText("Join");
        
        this.searchedGroup = searchedGroup;
        this.mainUser = parent.getUser();
        resetLabels();
        viewGroupPosts();
        viewGroupProfileData();     
    }
    
    public void resetLabels() {
        groupPicLabel.removeAll();
        groupNameLabel.removeAll();
        descriptionTextField.removeAll();
        postsPanel.removeAll();
        revalidate();
        repaint();
    }
    
    public void viewGroupProfileData() {
        viewGroupPic(searchedGroup.getPhotoPath());
        groupNameLabel.setText(searchedGroup.getGroupName());
        descriptionTextField.setText(searchedGroup.getDescription());
    }
    
    public void viewGroupPic(String groupPic) {
        try {
            ImageIcon icon = new ImageIcon(groupPic);
            if (icon.getImageLoadStatus() == MediaTracker.COMPLETE) {
                Image image = icon.getImage().getScaledInstance(120, 100, Image.SCALE_SMOOTH);
                groupPicLabel.setIcon(new ImageIcon(image));
            } else {
                groupPicLabel.setText("No Image");
            }
        } catch (Exception e) {
            groupPicLabel.setText("No Image");
        }
    }
    
    public void viewGroupPosts() {
        ArrayList<GroupPost> groupPosts = groupContentManager.getPosts(searchedGroup.getGroupId());
        if (groupPosts.isEmpty()) {
            JLabel label = new JLabel("No posts yet");

            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setVerticalAlignment(SwingConstants.CENTER);
            label.setFont(new Font("Arial", Font.BOLD, 24));
            postsPanel.add(label, BorderLayout.CENTER);
        }
        for (GroupPost groupPost : groupPosts) {
            ItemContentPanel icp = new ItemContentPanel(parent, groupPost);
            postsPanel.add(icp);
        }
    }

    public void leaveGroup() {
        groupManager.removeMember(searchedGroup.getGroupId(), searchedGroup.getPrimaryAdminId(), mainUser.getUserId());
        friendshipManager.removeRequest(searchedGroup.getGroupId(), mainUser.getUserId());
        startGroupProfile(searchedGroup, false);  
    }
    
    public void sendJoinGroupRequest() {
        friendshipManager.sendGroupRequest(searchedGroup.getGroupId(), mainUser.getUserId());
        startGroupProfile(searchedGroup, true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        profileContainerPanel = new javax.swing.JPanel();
        profileDataPanel = new javax.swing.JPanel();
        groupPicLabel = new javax.swing.JLabel();
        groupNameLabel = new javax.swing.JLabel();
        descriptionTextField = new javax.swing.JTextField();
        postsPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        homeButton = new javax.swing.JButton();
        accessButton = new javax.swing.JButton();

        profileContainerPanel.setMaximumSize(new java.awt.Dimension(501, 32767));

        profileDataPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 102), 1, true));
        profileDataPanel.setMaximumSize(new java.awt.Dimension(493, 134));

        groupPicLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        groupPicLabel.setForeground(new java.awt.Color(102, 0, 255));
        groupPicLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        groupPicLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        groupNameLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        groupNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        groupNameLabel.setText("Group Name");

        descriptionTextField.setEditable(false);
        descriptionTextField.setBackground(new java.awt.Color(255, 255, 255));
        descriptionTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        descriptionTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        descriptionTextField.setText("Description");
        descriptionTextField.setBorder(null);

        javax.swing.GroupLayout profileDataPanelLayout = new javax.swing.GroupLayout(profileDataPanel);
        profileDataPanel.setLayout(profileDataPanelLayout);
        profileDataPanelLayout.setHorizontalGroup(
            profileDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profileDataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(profileDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, profileDataPanelLayout.createSequentialGroup()
                        .addComponent(groupPicLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(groupNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(descriptionTextField))
                .addGap(14, 14, 14))
        );
        profileDataPanelLayout.setVerticalGroup(
            profileDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profileDataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(profileDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(groupPicLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(groupNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descriptionTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        postsPanel.setBackground(new java.awt.Color(255, 255, 255));
        postsPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        postsPanel.setLayout(new javax.swing.BoxLayout(postsPanel, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout profileContainerPanelLayout = new javax.swing.GroupLayout(profileContainerPanel);
        profileContainerPanel.setLayout(profileContainerPanelLayout);
        profileContainerPanelLayout.setHorizontalGroup(
            profileContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profileContainerPanelLayout.createSequentialGroup()
                .addGroup(profileContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(profileDataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(postsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        profileContainerPanelLayout.setVerticalGroup(
            profileContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profileContainerPanelLayout.createSequentialGroup()
                .addComponent(profileDataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(postsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(200, 200, 200));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 255), 2, true));
        jPanel2.setMaximumSize(new java.awt.Dimension(89, 243));

        homeButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        homeButton.setForeground(new java.awt.Color(102, 0, 255));
        homeButton.setText("Home");
        homeButton.setToolTipText("");
        homeButton.setBorder(null);
        homeButton.setBorderPainted(false);
        homeButton.setContentAreaFilled(false);
        homeButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        accessButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        accessButton.setForeground(new java.awt.Color(102, 0, 255));
        accessButton.setText("Access");
        accessButton.setBorder(null);
        accessButton.setBorderPainted(false);
        accessButton.setContentAreaFilled(false);
        accessButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        accessButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accessButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(homeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(accessButton, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(accessButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(profileContainerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(profileContainerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 602, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 243, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        parent.switchToNewsFeedPage();
    }//GEN-LAST:event_homeButtonActionPerformed

    private void accessButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accessButtonActionPerformed
        if(isMember)
            leaveGroup();
        else sendJoinGroupRequest();
    }//GEN-LAST:event_accessButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accessButton;
    private javax.swing.JTextField descriptionTextField;
    private javax.swing.JLabel groupNameLabel;
    private javax.swing.JLabel groupPicLabel;
    private javax.swing.JButton homeButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel postsPanel;
    private javax.swing.JPanel profileContainerPanel;
    private javax.swing.JPanel profileDataPanel;
    // End of variables declaration//GEN-END:variables
}
