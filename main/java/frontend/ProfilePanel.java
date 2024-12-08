package frontend;

import managers.*;
import entities.*;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.MediaTracker;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class ProfilePanel extends javax.swing.JPanel {

    private final MainFrame parent;
    private ContentManager contentManager;
    private ProfileManager profileManager;
    private FriendshipManager friendshipManager;

    public ProfilePanel(MainFrame parent) {
        this.parent = parent;
        initComponents();
        postsPanel.setLayout(new javax.swing.BoxLayout(postsPanel, javax.swing.BoxLayout.Y_AXIS));
    }

    public void startProfile() {
        resetLabels();
        contentManager = parent.getContentManager();
        profileManager = parent.getProfileManager();
        friendshipManager = parent.getFriendshipManager();
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

    public void viewPosts() {
        ArrayList<Post> posts = contentManager.getPosts(parent.getUser().getUserId());
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

    public void viewProfileData() {
        String profilePhoto = profileManager.getRecord(parent.getUser().getUserId()).getProfile().getProfilePhotoPath();
        String coverPhoto = profileManager.getRecord(parent.getUser().getUserId()).getProfile().getCoverPhotoPath();
        viewProfilePic(profilePhoto);
        viewCoverPic(coverPhoto);
        usernameLabel.setText(profileManager.getRecord(parent.getUser().getUserId()).getUsername());
        bioTextField.setText(profileManager.getRecord(parent.getUser().getUserId()).getProfile().getBio());
    }

    public void viewStories() {
        ArrayList<Story> stories = contentManager.getStories(parent.getUser().getUserId());
        if (stories.isEmpty()) {
            JOptionPane.showMessageDialog(null, "You have no stories.", "Message", JOptionPane.ERROR_MESSAGE);
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

    private void resetProfilePanel() {
        profileContainerPanel.removeAll(); // Clear all dynamically added components
        profileContainerPanel.setLayout(new BorderLayout()); // Reset layout if needed

        // Re-add the original components
        profileContainerPanel.add(profileDataPanel, BorderLayout.NORTH);
        profileContainerPanel.add(postsPanel, BorderLayout.CENTER);

        // Refresh the UI
        profileContainerPanel.revalidate();
        profileContainerPanel.repaint();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        updateButton = new javax.swing.JButton();
        storiesButton = new javax.swing.JButton();
        friendsButton = new javax.swing.JButton();
        homeButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        profileContainerPanel = new javax.swing.JPanel();
        profileDataPanel = new javax.swing.JPanel();
        coverPicLabel = new javax.swing.JLabel();
        profilePicLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        bioTextField = new javax.swing.JTextField();
        postsPanel = new javax.swing.JPanel();

        jPanel1.setBackground(new java.awt.Color(200, 200, 200));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 255), 2, true));

        updateButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        updateButton.setForeground(new java.awt.Color(102, 0, 255));
        updateButton.setText("Update");
        updateButton.setToolTipText("");
        updateButton.setBorder(null);
        updateButton.setBorderPainted(false);
        updateButton.setContentAreaFilled(false);
        updateButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
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

        friendsButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        friendsButton.setForeground(new java.awt.Color(102, 0, 255));
        friendsButton.setText("Friends");
        friendsButton.setBorder(null);
        friendsButton.setBorderPainted(false);
        friendsButton.setContentAreaFilled(false);
        friendsButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        friendsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                friendsButtonActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(updateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(friendsButton, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                            .addComponent(storiesButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 3, Short.MAX_VALUE))
                    .addComponent(homeButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(storiesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(friendsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

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
                .addComponent(postsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane1.setViewportView(profileContainerPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        UpdateProfileDataDialoge dialog = new UpdateProfileDataDialoge(parent, "Update", true);
        viewProfileData();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void storiesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_storiesButtonActionPerformed
        viewStories();
    }//GEN-LAST:event_storiesButtonActionPerformed

    private void friendsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_friendsButtonActionPerformed
        parent.switchToFriendsPage();
    }//GEN-LAST:event_friendsButtonActionPerformed

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        parent.switchToNewsFeedPage();
    }//GEN-LAST:event_homeButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bioTextField;
    private javax.swing.JLabel coverPicLabel;
    private javax.swing.JButton friendsButton;
    private javax.swing.JButton homeButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel postsPanel;
    private javax.swing.JPanel profileContainerPanel;
    private javax.swing.JPanel profileDataPanel;
    private javax.swing.JLabel profilePicLabel;
    private javax.swing.JButton storiesButton;
    private javax.swing.JButton updateButton;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
