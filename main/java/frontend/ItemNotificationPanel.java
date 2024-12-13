package frontend;

import entities.*;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.MediaTracker;
import javax.swing.ImageIcon;

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

//    @Override
//    public Dimension getPreferredSize() {
//        return new Dimension(220, 60); // Width and height for the panel
//    }
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
        if (notification instanceof FriendRequestNotification){
            parent.switchToFriendsPage();
        }
    }//GEN-LAST:event_messageLabelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel messageLabel;
    private javax.swing.JLabel statusLabel;
    // End of variables declaration//GEN-END:variables
}
