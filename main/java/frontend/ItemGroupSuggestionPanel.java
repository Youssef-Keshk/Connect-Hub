package frontend;

import entities.Group;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.MediaTracker;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import managers.FriendshipManager;


public class ItemGroupSuggestionPanel extends javax.swing.JPanel {
    private final Group group;
    private final String groupName;
    private final String path;
    private final MainFrame parent;
    private final FriendshipManager friendshipManager;
    
    public ItemGroupSuggestionPanel(MainFrame parent, Group group) {
        this.group = group;
        this.groupName = group.getGroupName();
        this.parent = parent;
        this.friendshipManager = parent.getFriendshipManager();
        this.path = group.getPhotoPath();

//        setPreferredSize(new Dimension(220, 80));
//        setMinimumSize(new Dimension(150, 80));
           setMaximumSize(new Dimension(180, 80));
        initComponents();
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        setLabels();
    }
    
    public void setLabels() {
        groupNameLabel.setText(groupName);
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

        jPanel1 = new javax.swing.JPanel();
        groupNameLabel = new javax.swing.JLabel();
        joinButton = new javax.swing.JButton();
        profilePicLabel = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.setToolTipText("");
        jPanel1.setLayout(new java.awt.BorderLayout());

        groupNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        groupNameLabel.setText("group name");
        jPanel1.add(groupNameLabel, java.awt.BorderLayout.CENTER);

        joinButton.setBackground(new java.awt.Color(204, 204, 204));
        joinButton.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        joinButton.setForeground(new java.awt.Color(102, 0, 255));
        joinButton.setText("Join");
        joinButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 0, 255), new java.awt.Color(102, 0, 255), new java.awt.Color(102, 0, 255), new java.awt.Color(102, 0, 255)));
        joinButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joinButtonActionPerformed(evt);
            }
        });
        jPanel1.add(joinButton, java.awt.BorderLayout.PAGE_END);

        profilePicLabel.setText("No image");
        profilePicLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 102)));
        profilePicLabel.setMaximumSize(new java.awt.Dimension(60, 16));
        profilePicLabel.setMinimumSize(new java.awt.Dimension(60, 16));
        profilePicLabel.setPreferredSize(new java.awt.Dimension(40, 40));
        jPanel1.add(profilePicLabel, java.awt.BorderLayout.LINE_START);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void joinButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joinButtonActionPerformed
        JOptionPane.showMessageDialog(null, "Join request sent to " + groupName, "Message", JOptionPane.INFORMATION_MESSAGE);
        friendshipManager.sendGroupRequest(group.getGroupId(), parent.getUser().getUserId());
        parent.switchToNewsFeedPage();
    }//GEN-LAST:event_joinButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel groupNameLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton joinButton;
    private javax.swing.JLabel profilePicLabel;
    // End of variables declaration//GEN-END:variables
}
