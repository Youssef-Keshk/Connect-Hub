package frontend;

import entities.User;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.MediaTracker;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import managers.FriendshipManager;

public class ItemFriendSuggestionPanel extends javax.swing.JPanel {

    private final User user;
    private final String username;
    private final String path;
    private final MainFrame parent;
    private final FriendshipManager friendshipManager;

    public ItemFriendSuggestionPanel(User user, MainFrame parent) {
        this.user = user;
        this.username = user.getUsername();
        this.parent = parent;
        this.friendshipManager = parent.getFriendshipManager();
        this.path = user.getProfile().getProfilePhotoPath();

//        setPreferredSize(new Dimension(220, 80));
//        setMinimumSize(new Dimension(150, 80));
           setMaximumSize(new Dimension(180, 80));
        initComponents();
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        setLabels();

    }

    public void setLabels() {
        usernameLabel.setText(username);
        if (path == null || path.isEmpty()) {
            profilePicLabel.setText("No Image");
            return;
        }
        try {
            ImageIcon icon = new ImageIcon(path);
            if (icon.getImageLoadStatus() == MediaTracker.COMPLETE) {
                Image image = icon.getImage().getScaledInstance(40, 60, Image.SCALE_SMOOTH);
                profilePicLabel.setIcon(new ImageIcon(image));
            } else {
                profilePicLabel.setText("No Image");
            }
        } catch (Exception e) {
            profilePicLabel.setText("No Image");
        }
        profilePicLabel.revalidate();
        profilePicLabel.repaint();

    }

//    @Override
//    public Dimension getPreferredSize() {
//        return new Dimension(220, 80); // Width and height for the panel
//    }

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

        usernameLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        usernameLabel.setText("username");
        add(usernameLabel, java.awt.BorderLayout.CENTER);

        addFriendButton.setBackground(new java.awt.Color(204, 204, 204));
        addFriendButton.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        addFriendButton.setForeground(new java.awt.Color(102, 0, 255));
        addFriendButton.setText("Add Friend");
        addFriendButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 0, 255), new java.awt.Color(102, 0, 255), new java.awt.Color(102, 0, 255), new java.awt.Color(102, 0, 255)));
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
        profilePicLabel.setPreferredSize(new java.awt.Dimension(40, 40));
        add(profilePicLabel, java.awt.BorderLayout.LINE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void addFriendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFriendButtonActionPerformed
        JOptionPane.showMessageDialog(null, "Friend request sent to " + username, "Message", JOptionPane.INFORMATION_MESSAGE);
        friendshipManager.sendRequest(user.getUserId(), parent.getUser().getUserId());
        parent.switchToNewsFeedPage();
    }//GEN-LAST:event_addFriendButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addFriendButton;
    private javax.swing.JLabel profilePicLabel;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
