package frontend;

import entities.Post;
import entities.Story;
import entities.User;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.MediaTracker;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import managers.*;


public class RandomUserProfilePanel extends javax.swing.JPanel {
    private final MainFrame parent;
    private final User mainUser;
    private final User searchedUser;
    private final boolean isFriend;
    private final ContentManager contentManager;
    private final AccountManager accountManager;
    private final FriendshipManager friendshipManager;
    
    public RandomUserProfilePanel(MainFrame parent, User searchedUser, boolean isFriend) {
        this.parent = parent;
        this.isFriend = isFriend;
        this.mainUser = parent.getUser();
        this.searchedUser = searchedUser;
        contentManager = parent.getContentManager();
        accountManager = parent.getAccountManager();
        friendshipManager = parent.getFriendshipManager();
        initComponents();
        postsPanel.setLayout(new javax.swing.BoxLayout(postsPanel, javax.swing.BoxLayout.Y_AXIS));
    }
    
    public void startProfile() {
        resetLabels();
        viewProfileData();
        viewPosts();     
    }

    public void resetLabels() {
        profilePicLabel.removeAll();
        coverPicLabel.removeAll();
        usernameLabel.removeAll();
        bioTextField.removeAll();
        postsPanel.removeAll();
        revalidate();
        repaint();
    }
    
    
    
    public void viewProfileData() {
        String profilePhoto = searchedUser.getProfile().getProfilePhotoPath();
        String coverPhoto = searchedUser.getProfile().getCoverPhotoPath();
        viewProfilePic(profilePhoto);
        viewCoverPic(coverPhoto);
        usernameLabel.setText(accountManager.getRecord(searchedUser.getUserId()).getUsername());
        bioTextField.setText(accountManager.getRecord(searchedUser.getUserId()).getProfile().getBio());
    }
    
    public void viewProfilePic(String profilePhoto) {
        try {
            ImageIcon icon = new ImageIcon(profilePhoto);
            if (icon.getImageLoadStatus() == MediaTracker.COMPLETE) {
                Image image = icon.getImage().getScaledInstance(120, 100, Image.SCALE_SMOOTH);
                profilePicLabel.setIcon(new ImageIcon(image));
            } else {
                profilePicLabel.setText("No Image");
            }
        } catch (Exception e) {
            profilePicLabel.setText("No Image");
        }
    }

    public void viewCoverPic(String coverPhoto) {
        try {
            ImageIcon icon = new ImageIcon(coverPhoto);
            if (icon.getImageLoadStatus() == MediaTracker.COMPLETE) {
                Image image = icon.getImage().getScaledInstance(360, 100, Image.SCALE_SMOOTH);
                coverPicLabel.setIcon(new ImageIcon(image));
            } else {
                coverPicLabel.setText("No Image");
            }
        } catch (Exception e) {
            coverPicLabel.setText("No Image");
        }
    }
    
    public void viewPosts() {
        ArrayList<Post> posts = contentManager.getPosts(searchedUser.getUserId());
        if (posts.isEmpty()) {
            JLabel label = new JLabel("No posts yet");

            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setVerticalAlignment(SwingConstants.CENTER);
            label.setFont(new Font("Arial", Font.BOLD, 24));
            postsPanel.add(label, BorderLayout.CENTER);
        }
        for (Post post : posts) {
            ItemContentPanel icp = new ItemContentPanel(parent, post);
            postsPanel.add(icp);
        }
    }
    
    public void viewStories() {
        ArrayList<Story> stories = contentManager.getStories(searchedUser.getUserId());
        if (stories.isEmpty()) {
            JOptionPane.showMessageDialog(null, "User has no stories.", "Message", JOptionPane.ERROR_MESSAGE);
            return;
        }
        ArrayList<ItemContentPanel> icps = new ArrayList<>();
        for (Story story : stories) {
            icps.add(new ItemContentPanel(parent, story));
        }
        StoryCarouselPanel carouselPanel = new StoryCarouselPanel(icps);

        StoriesDialoge dialog = new StoriesDialoge(parent, "Stories", true);
        dialog.viewStoryCarousel(carouselPanel);
    }
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        profileContainerPanel = new javax.swing.JPanel();
        profileDataPanel = new javax.swing.JPanel();
        coverPicLabel = new javax.swing.JLabel();
        profilePicLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        bioTextField = new javax.swing.JTextField();
        postsPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        blockButton = new javax.swing.JButton();
        homeButton = new javax.swing.JButton();
        storiesButton = new javax.swing.JButton();

        profileContainerPanel.setBackground(new java.awt.Color(255, 255, 255));
        profileContainerPanel.setMaximumSize(new java.awt.Dimension(501, 32767));

        profileDataPanel.setBackground(new java.awt.Color(255, 255, 255));
        profileDataPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 102), 1, true));
        profileDataPanel.setMaximumSize(new java.awt.Dimension(493, 134));

        coverPicLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        coverPicLabel.setForeground(new java.awt.Color(102, 0, 255));
        coverPicLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        profilePicLabel.setBackground(new java.awt.Color(255, 255, 255));
        profilePicLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        profilePicLabel.setForeground(new java.awt.Color(102, 0, 255));
        profilePicLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profilePicLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        usernameLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        usernameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usernameLabel.setText("Username");

        bioTextField.setEditable(false);
        bioTextField.setBackground(new java.awt.Color(255, 255, 255));
        bioTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        bioTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bioTextField.setText("Bio");
        bioTextField.setBorder(null);

        javax.swing.GroupLayout profileDataPanelLayout = new javax.swing.GroupLayout(profileDataPanel);
        profileDataPanel.setLayout(profileDataPanelLayout);
        profileDataPanelLayout.setHorizontalGroup(
            profileDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, profileDataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(profileDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(profilePicLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(usernameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(profileDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bioTextField)
                    .addComponent(coverPicLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );
        profileDataPanelLayout.setVerticalGroup(
            profileDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profileDataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(profileDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(profilePicLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                    .addComponent(coverPicLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(profileDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usernameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bioTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
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

        jPanel1.setBackground(new java.awt.Color(200, 200, 200));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 255), 2, true));

        blockButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        blockButton.setForeground(new java.awt.Color(102, 0, 0));
        blockButton.setText("Block");
        blockButton.setBorder(null);
        blockButton.setBorderPainted(false);
        blockButton.setContentAreaFilled(false);
        blockButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        blockButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blockButtonActionPerformed(evt);
            }
        });

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

        storiesButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        storiesButton.setForeground(new java.awt.Color(102, 0, 255));
        storiesButton.setText("Stories");
        storiesButton.setBorder(null);
        storiesButton.setBorderPainted(false);
        storiesButton.setContentAreaFilled(false);
        storiesButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        storiesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                storiesButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(homeButton, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                    .addComponent(storiesButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(blockButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(storiesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(blockButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(profileContainerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(profileContainerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void blockButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blockButtonActionPerformed
        
    }//GEN-LAST:event_blockButtonActionPerformed

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        parent.switchToNewsFeedPage();
    }//GEN-LAST:event_homeButtonActionPerformed

    private void storiesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_storiesButtonActionPerformed
        viewStories();
    }//GEN-LAST:event_storiesButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bioTextField;
    private javax.swing.JButton blockButton;
    private javax.swing.JLabel coverPicLabel;
    private javax.swing.JButton homeButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel postsPanel;
    private javax.swing.JPanel profileContainerPanel;
    private javax.swing.JPanel profileDataPanel;
    private javax.swing.JLabel profilePicLabel;
    private javax.swing.JButton storiesButton;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
