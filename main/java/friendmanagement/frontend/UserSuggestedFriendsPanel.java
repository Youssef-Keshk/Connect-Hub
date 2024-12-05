package friendmanagement.frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.MediaTracker;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

public class UserSuggestedFriendsPanel extends javax.swing.JPanel {

    
    public UserSuggestedFriendsPanel(String username, String path) {
        setPreferredSize(new Dimension(220, 80));
        setMinimumSize(new Dimension(220, 80));
        setMaximumSize(new Dimension(220, 100));
        initComponents();
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setLabels(username, path);
        
    }
    
    public void setLabels(String username, String path) {
        usernameLabel.setText(username);
        if (path == null || path.isEmpty()) {
        profilePicLabel.setText("No Image");
        return;
    }
    try {
        ImageIcon icon = new ImageIcon(path);
        if (icon.getImageLoadStatus() == MediaTracker.COMPLETE) {
            Image image = icon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            profilePicLabel.setIcon(new ImageIcon(image));
        } else {
            profilePicLabel.setText("No Image");
        }
    } catch (Exception e) {
        profilePicLabel.setText("No Image");
    }
        
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(220, 80); // Width and height for the panel
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usernameLabel = new javax.swing.JLabel();
        addFriendButton = new javax.swing.JButton();
        profilePicLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setToolTipText("");
        setLayout(new java.awt.BorderLayout());

        usernameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usernameLabel.setText("username");
        usernameLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usernameLabelMouseClicked(evt);
            }
        });
        add(usernameLabel, java.awt.BorderLayout.CENTER);

        addFriendButton.setBackground(new java.awt.Color(0, 0, 153));
        addFriendButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        addFriendButton.setForeground(new java.awt.Color(255, 255, 255));
        addFriendButton.setText("Add Friend");
        addFriendButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 255, 204), new java.awt.Color(153, 255, 204), new java.awt.Color(153, 255, 204), new java.awt.Color(153, 255, 204)));
        addFriendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFriendButtonActionPerformed(evt);
            }
        });
        add(addFriendButton, java.awt.BorderLayout.PAGE_END);

        profilePicLabel.setText("No image");
        profilePicLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 102)));
        profilePicLabel.setMaximumSize(new java.awt.Dimension(60, 16));
        profilePicLabel.setMinimumSize(new java.awt.Dimension(60, 16));
        profilePicLabel.setPreferredSize(new java.awt.Dimension(60, 16));
        profilePicLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profilePicLabelMouseClicked(evt);
            }
        });
        add(profilePicLabel, java.awt.BorderLayout.LINE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void usernameLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usernameLabelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameLabelMouseClicked

    private void addFriendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFriendButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addFriendButtonActionPerformed

    private void profilePicLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilePicLabelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_profilePicLabelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addFriendButton;
    private javax.swing.JLabel profilePicLabel;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
