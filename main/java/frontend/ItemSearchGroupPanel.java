package frontend;

import entities.Group;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.MediaTracker;
import javax.swing.ImageIcon;


public class ItemSearchGroupPanel extends javax.swing.JPanel {
    private final MainFrame parent;
    private final String groupID;
    private final String groupName;
    private final String groupPhotoPath;
    
    public ItemSearchGroupPanel(MainFrame parent, Group group) {
        this.parent = parent;
        this.groupID = group.getGroupId();
        this.groupName = group.getGroupName();
        this.groupPhotoPath = group.getPhotoPath();
        
        initComponents();
        
//        setPreferredSize(new Dimension(220, 60));
        setMinimumSize(new Dimension(150, 60));
//        setMaximumSize(new Dimension(180, 40));
//
//        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setLabels();
    }
    
    public void setLabels() {
        groupNameLabel.setText(groupName);
        if (groupPhotoPath == null || groupPhotoPath.isEmpty()) {
            groupPicLabel.setText("No Image");
            return;
        }
        try {
            ImageIcon icon = new ImageIcon(groupPhotoPath);
            if (icon.getImageLoadStatus() == MediaTracker.COMPLETE) {
                Image image = icon.getImage().getScaledInstance(40, 25, Image.SCALE_SMOOTH);
                groupPicLabel.setIcon(new ImageIcon(image));
            } else {
                groupPicLabel.setText("No Image");
            }
        } catch (Exception e) {
            groupPicLabel.setText("No Image");
        }

    }  
    
    public void viewProfile() {
        parent.switchToRandomGroupProfile(groupID);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupPicLabel = new javax.swing.JLabel();
        groupNameLabel = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        groupPicLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 102)));
        groupPicLabel.setMaximumSize(new java.awt.Dimension(60, 16));
        groupPicLabel.setMinimumSize(new java.awt.Dimension(60, 16));
        groupPicLabel.setPreferredSize(new java.awt.Dimension(40, 40));
        groupPicLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                groupPicLabelMouseClicked(evt);
            }
        });
        add(groupPicLabel, java.awt.BorderLayout.LINE_START);

        groupNameLabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        groupNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        groupNameLabel.setText("group name");
        groupNameLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                groupNameLabelMouseClicked(evt);
            }
        });
        add(groupNameLabel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void groupPicLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_groupPicLabelMouseClicked
        viewProfile();
    }//GEN-LAST:event_groupPicLabelMouseClicked

    private void groupNameLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_groupNameLabelMouseClicked
        viewProfile();
    }//GEN-LAST:event_groupNameLabelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel groupNameLabel;
    private javax.swing.JLabel groupPicLabel;
    // End of variables declaration//GEN-END:variables
}
