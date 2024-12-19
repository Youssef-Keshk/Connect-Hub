package frontend;

import entities.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.MediaTracker;
import javax.swing.ImageIcon;
import javax.swing.JDialog;

public class ItemNotificationPanel extends javax.swing.JPanel {

    private final Notification notification;
    private final MainFrame parent;

    public ItemNotificationPanel(Notification notification, MainFrame parent) {
        this.parent = parent;
        this.notification = notification;

        initComponents();
        setMaximumSize(new Dimension(300, 80));
        setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.DARK_GRAY));
        setLabels();
    }

    private void setLabels() {
        messageLabel.setText(notification.getMessage());
    }

    public void apearChatPanel(String friendID) {
        try {
            // Create the dialog
            JDialog dialog = new JDialog((Frame) null, "Private chat", true);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

            // Create and set up the ManageRequestedPanel
            ChatPanel chatPanel = new ChatPanel(parent, friendID);
            dialog.setLayout(new BorderLayout());
            dialog.add(chatPanel, BorderLayout.CENTER);

            // Set dialog size and location
            dialog.pack();
            dialog.setLocationRelativeTo(null); // Center the dialog

            // Show the dialog
            dialog.setVisible(true);
        } catch (Exception e) {
            System.out.println("Error showing chatPanel" + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        statusLabel = new javax.swing.JLabel();
        messageLabel = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        statusLabel.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        statusLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        statusLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        add(statusLabel, java.awt.BorderLayout.PAGE_END);

        messageLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                messageLabelMouseClicked(evt);
            }
        });
        add(messageLabel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void messageLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_messageLabelMouseClicked
        if (notification instanceof FriendRequestNotification) {
            parent.switchToFriendsPage();
        }
        if (notification instanceof LikesNotification || notification instanceof CommentsNotification) {
            parent.switchToProfilePage();
        }
        if (notification instanceof MessageNotification) {
            apearChatPanel(((MessageNotification) notification).getSenderId());
        }
    }//GEN-LAST:event_messageLabelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel messageLabel;
    private javax.swing.JLabel statusLabel;
    // End of variables declaration//GEN-END:variables
}
