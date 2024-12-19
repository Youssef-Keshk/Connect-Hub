package frontend;

import entities.Notification;
import java.awt.Dimension;
import java.util.ArrayList;
import entities.User;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class AllNotificationsPanel extends javax.swing.JPanel{
    ArrayList<Notification> notifications;
    private final MainFrame parent;
 
    public AllNotificationsPanel(ArrayList<Notification> notifications, MainFrame parent) {
        this.notifications = notifications;
        this.parent = parent;
        initComponents();
        setPreferredSize(new Dimension(150, 200));
        setMinimumSize(new Dimension(150, 200));
        setMaximumSize(new Dimension(150, 200));
        notificationsContainerPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        notificationsContainerPanel.setLayout(new javax.swing.BoxLayout(notificationsContainerPanel, javax.swing.BoxLayout.Y_AXIS));
        
        addPanels();
    }
    
    public void addPanels() {
        notificationsContainerPanel.removeAll();
        
        if(notifications.isEmpty()) {
            JLabel label = new JLabel("You have no notifications");

            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setVerticalAlignment(SwingConstants.CENTER);
            label.setFont(new Font("Arial", Font.BOLD, 12));
            notificationsContainerPanel.add(label, BorderLayout.CENTER);
        }else{           
            for(Notification notification : notifications){
                notificationsContainerPanel.add(getItemNotificationPanel(notification));
        }
        }
        notificationsContainerPanel.revalidate();
        notificationsContainerPanel.repaint();
    }
       
    public ItemNotificationPanel getItemNotificationPanel(Notification notification) {
        return new ItemNotificationPanel(notification, parent);
    }        
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        notificationsContainerPanel = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        titleLabel.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Notifications");
        titleLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(titleLabel, java.awt.BorderLayout.PAGE_START);

        notificationsContainerPanel.setLayout(new javax.swing.BoxLayout(notificationsContainerPanel, javax.swing.BoxLayout.LINE_AXIS));
        jScrollPane1.setViewportView(notificationsContainerPanel);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel notificationsContainerPanel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
