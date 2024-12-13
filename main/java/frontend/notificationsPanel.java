package frontend;

import entities.Notification;
import managers.NotificationManager;
import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class NotificationsPanel extends javax.swing.JPanel {

    private final MainFrame parent;
    private NotificationManager notificationManager;

    public NotificationsPanel(MainFrame parent) {
        this.parent = parent;
        initComponents();
    }

    public void startNotifications() {
        notificationManager = parent.getNotificationManager();
        displayNotifications();
    }

    private void resetPanels() {
        containerPanel.removeAll();
        containerPanel.revalidate();
        containerPanel.repaint();
    }

    private void displayNotifications() {
        resetPanels();

        // Retrieve all notifications
        ArrayList<Notification> notifications = notificationManager.getAllNotifications(parent.getUser().getUserId());

        // Check if there are no notifications
        if (notifications.isEmpty()) {
            // Display "No notifications available" message
            JLabel noNotificationsLabel = new JLabel("No notifications available.", JLabel.CENTER);
            containerPanel.setLayout(new java.awt.BorderLayout());
            containerPanel.add(noNotificationsLabel, java.awt.BorderLayout.CENTER);
        } else {
            // Display the notifications in AllNotificationsPanel
            AllNotificationsPanel allNotificationsPanel = new AllNotificationsPanel(notifications, parent);
            containerPanel.setLayout(new java.awt.BorderLayout());
            containerPanel.add(allNotificationsPanel, java.awt.BorderLayout.CENTER);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        containerPanel = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(200, 200, 200));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 255), 2, true));
        jPanel1.setMaximumSize(new java.awt.Dimension(89, 32767));
        jPanel1.setPreferredSize(new java.awt.Dimension(89, 400));

        backButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        backButton.setForeground(new java.awt.Color(102, 0, 255));
        backButton.setText("Back");
        backButton.setToolTipText("");
        backButton.setBorder(null);
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(356, Short.MAX_VALUE)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(jPanel1, java.awt.BorderLayout.WEST);

        containerPanel.setLayout(new java.awt.GridLayout(1, 0));
        add(containerPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        parent.switchToNewsFeedPage();
    }//GEN-LAST:event_backButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JPanel containerPanel;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
