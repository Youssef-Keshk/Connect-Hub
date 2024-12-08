package frontend;

import entities.User;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.MediaTracker;
import javax.swing.ImageIcon;

public class ItemFriendsPanel extends javax.swing.JPanel {

    private final String username;
    private final String profilePhotoPath;
    private final String status;
    private final String userID;
    private final MainFrame parent;

    public ItemFriendsPanel(User user, MainFrame parent) {
        this.parent = parent;
        this.userID = user.getUserId();
        this.username = user.getUsername();
        this.profilePhotoPath = user.getProfile().getProfilePhotoPath();
        this.status = user.getStatus().toString();

        initComponents();
//        setPreferredSize(new Dimension(220, 60));
//        setMinimumSize(new Dimension(150, 60));
          setMaximumSize(new Dimension(180, 40));

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
                Image image = icon.getImage().getScaledInstance(40, 25, Image.SCALE_SMOOTH);
                profilePicLabel.setIcon(new ImageIcon(image));
            } else {
                profilePicLabel.setText("No Image");
            }
        } catch (Exception e) {
            profilePicLabel.setText("No Image");
        }

    }

//    @Override
//    public Dimension getPreferredSize() {
//        return new Dimension(220, 60); // Width and height for the panel
//    }

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
        profilePicLabel.setPreferredSize(new java.awt.Dimension(40, 40));
        add(profilePicLabel, java.awt.BorderLayout.LINE_START);

        usernameLabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        usernameLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        usernameLabel.setText("username");
        add(usernameLabel, java.awt.BorderLayout.CENTER);

        statusLabel.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        statusLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        statusLabel.setText("Status: OFFLINE");
        statusLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        add(statusLabel, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel profilePicLabel;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
