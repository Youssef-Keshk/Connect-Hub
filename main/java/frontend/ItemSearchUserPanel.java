package frontend;

import entities.User;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.MediaTracker;
import javax.swing.ImageIcon;


public class ItemSearchUserPanel extends javax.swing.JPanel {
    private final MainFrame parent;
    private final String userID;
    private final String username;
    private final String profilePhotoPath;

    public ItemSearchUserPanel(MainFrame parent, User user) {
        this.parent = parent;
        this.userID = user.getUserId();
        this.username = user.getUsername();
        this.profilePhotoPath = user.getProfile().getProfilePhotoPath();
        
        initComponents();
        //        setPreferredSize(new Dimension(220, 60));
//        setMinimumSize(new Dimension(150, 60));
          setMaximumSize(new Dimension(180, 40));

        //setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setLabels();
    }
    
    public void setLabels() {
        usernameLabel.setText(username);
        if (profilePhotoPath == null || profilePhotoPath.isEmpty()) {
            profilePicLabel.setText("No Image");
            return;
        }
        try {
            ImageIcon icon = new ImageIcon(profilePhotoPath);
            if (icon.getImageLoadStatus() == MediaTracker.COMPLETE) {
                Image image = icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
                profilePicLabel.setIcon(new ImageIcon(image));
            } else {
                profilePicLabel.setText("No Image");
            }
        } catch (Exception e) {
            profilePicLabel.setText("No Image");
        }

    }
    
    public void viewProfile() {
        parent.switchToRandomUserProfile(parent.getAccountManager().getRecord(userID));
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        profilePicLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        profilePicLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 102)));
        profilePicLabel.setMaximumSize(new java.awt.Dimension(60, 16));
        profilePicLabel.setMinimumSize(new java.awt.Dimension(60, 16));
        profilePicLabel.setPreferredSize(new java.awt.Dimension(40, 40));
        profilePicLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profilePicLabelMouseClicked(evt);
            }
        });
        add(profilePicLabel, java.awt.BorderLayout.LINE_START);

        usernameLabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        usernameLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        usernameLabel.setText("username");
        usernameLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usernameLabelMouseClicked(evt);
            }
        });
        add(usernameLabel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void usernameLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usernameLabelMouseClicked
        viewProfile();
    }//GEN-LAST:event_usernameLabelMouseClicked

    private void profilePicLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilePicLabelMouseClicked
        viewProfile();
    }//GEN-LAST:event_profilePicLabelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel profilePicLabel;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
