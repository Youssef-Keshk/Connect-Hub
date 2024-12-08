package frontend;

import entities.User;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.MediaTracker;
import javax.swing.ImageIcon;
import javax.swing.JDialog;

public class ItemManageFriendsPanel extends javax.swing.JPanel {

    private String username;
    private String profilePhotoPath;
    private String status;
    private String userID;
    private final MainFrame parent;

    public ItemManageFriendsPanel(User user, MainFrame parent) {
        this.parent = parent;
        this.userID = user.getUserId();
        this.username = user.getUsername();
        this.profilePhotoPath = user.getProfile().getProfilePhotoPath();
        this.status = user.getStatus().toString();

        initComponents();
        setPreferredSize(new Dimension(220, 60));
        setMinimumSize(new Dimension(220, 60));
        setMaximumSize(new Dimension(220, 80));

        //setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setLabels();
    }

    public void setLabels() {
        usernameLabel.setText(username);
        statusLabel.setText("Status: " + status.toUpperCase());
        if (profilePhotoPath == null || profilePhotoPath.isEmpty()) {
            profilePicLabel.setText("No Image");
            return;
        }
        try {
            ImageIcon icon = new ImageIcon(profilePhotoPath);
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
        return new Dimension(220, 60); // Width and height for the panel
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        profilePicLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        statusLabel = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

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

        usernameLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        usernameLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        usernameLabel.setText("username");
        usernameLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usernameLabelMouseClicked(evt);
            }
        });
        add(usernameLabel, java.awt.BorderLayout.CENTER);

        statusLabel.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        statusLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        statusLabel.setText("Status: OFFLINE");
        statusLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        add(statusLabel, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void profilePicLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilePicLabelMouseClicked
        showManagePanel();
        parent.switchToFriendsPage();
    }//GEN-LAST:event_profilePicLabelMouseClicked

    private void usernameLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usernameLabelMouseClicked
        showManagePanel();
        parent.switchToFriendsPage();
    }//GEN-LAST:event_usernameLabelMouseClicked

    private void showManagePanel() {
        try {
            // Create the dialog
            JDialog dialog = new JDialog((Frame) null, "Manage Friend", true);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

            // Create and set up the ManageRequestedPanel
            ManageFriendPanel managefriendPanel = new ManageFriendPanel(parent.getUser().getUserId(), userID, parent.getFriendshipManager(), dialog);
            dialog.setLayout(new BorderLayout());
            dialog.add(managefriendPanel, BorderLayout.CENTER);

            // Set dialog size and location
            dialog.pack();
            dialog.setLocationRelativeTo(null); // Center the dialog

            // Show the dialog
            dialog.setVisible(true);
        } catch (Exception e) {
            System.out.println("Error showing ManageFriendPanel" + e.getMessage());
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel profilePicLabel;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
