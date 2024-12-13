package frontend;

import entities.Group;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.MediaTracker;
import javax.swing.ImageIcon;

public class ItemGroupPanel extends javax.swing.JPanel {
    private final String groupName;
    private final String groupPhotoPath;
    private final String userID;
    private final MainFrame parent;
    
    public ItemGroupPanel(MainFrame parent, Group group) {
        this.parent = parent;
        this.userID = parent.getUser().getUserId();
        this.groupName = group.getGroupName();
        this.groupPhotoPath = group.getgroupPhotoPath();
        initComponents();
//        setPreferredSize(new Dimension(220, 60));
//        setMinimumSize(new Dimension(150, 60));
        setMaximumSize(new Dimension(180, 40));

//        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setLabels();
    }
    
    public void setLabels() {
        groupNameLabel.setText(groupName);
        if (groupPhotoPath == null || groupPhotoPath.isEmpty()) {
            groupPhotoLabel.setText("No Image");
            return;
        }
        try {
            ImageIcon icon = new ImageIcon(groupPhotoPath);
            if (icon.getImageLoadStatus() == MediaTracker.COMPLETE) {
                Image image = icon.getImage().getScaledInstance(40, 25, Image.SCALE_SMOOTH);
                groupPhotoLabel.setIcon(new ImageIcon(image));
            } else {
                groupPhotoLabel.setText("No Image");
            }
        } catch (Exception e) {
            groupPhotoLabel.setText("No Image");
        }

    }

//    @Override
//    public Dimension getPreferredSize() {
//        return new Dimension(220, 60); // Width and height for the panel
//    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupPhotoLabel = new javax.swing.JLabel();
        groupNameLabel = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        groupPhotoLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 102)));
        groupPhotoLabel.setMaximumSize(new java.awt.Dimension(60, 16));
        groupPhotoLabel.setMinimumSize(new java.awt.Dimension(60, 16));
        groupPhotoLabel.setPreferredSize(new java.awt.Dimension(40, 40));
        add(groupPhotoLabel, java.awt.BorderLayout.LINE_START);

        groupNameLabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        groupNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        groupNameLabel.setText("group name");
        add(groupNameLabel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel groupNameLabel;
    private javax.swing.JLabel groupPhotoLabel;
    // End of variables declaration//GEN-END:variables
}
