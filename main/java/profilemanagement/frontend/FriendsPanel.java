package profilemanagement.frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.MediaTracker;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

public class FriendsPanel extends javax.swing.JPanel {

    
    public FriendsPanel(String username, String path, String status) {
        initComponents();
        setPreferredSize(new Dimension(220, 60));
        setMinimumSize(new Dimension(220, 60));
        setMaximumSize(new Dimension(220, 80));
       
        
        //setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setLabels(username, path, status);
    }
    
    public void setLabels(String username, String path, String status) {
        usernameLabel.setText(username);
        statusLabel.setText("Status: " + status.toUpperCase());
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
        return new Dimension(220, 60); // Width and height for the panel
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
        // TODO add your handling code here:
    }//GEN-LAST:event_profilePicLabelMouseClicked

    private void usernameLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usernameLabelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameLabelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel profilePicLabel;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}