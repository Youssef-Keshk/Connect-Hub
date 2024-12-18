package frontend;

import entities.Comment;
import entities.User;
import java.awt.Image;
import java.awt.MediaTracker;
import javax.swing.ImageIcon;


public class ItemCommentPanel extends javax.swing.JPanel {
    private final MainFrame parent;
    private final Comment comment;
    
    public ItemCommentPanel(MainFrame parent, Comment comment) {
        this.parent = parent;
        this.comment = comment;
        
        initComponents();
        setLabels();
        
    }
    
    public void setLabels() {
        User user = parent.getAccountManager().getRecord(comment.getUserId());
        String imagePath = user.getProfile().getProfilePhotoPath();
        setProfilePicLabel(imagePath);
        usernameLabel.setText(user.getUsername());
        commentTextArea.setText(comment.getText());
        
    }
    
    public void setProfilePicLabel(String imagePath) {
        if (imagePath == null || imagePath.isEmpty()) {
            profilePicLabel.setText("No Image");
            return;
        }
        try {
            ImageIcon icon = new ImageIcon(imagePath);
            if (icon.getImageLoadStatus() == MediaTracker.COMPLETE) {
                Image image = icon.getImage().getScaledInstance(40, 16, Image.SCALE_SMOOTH);
                profilePicLabel.setIcon(new ImageIcon(image));
            }else {
                profilePicLabel.setText("No Image");
            }
        } catch (Exception e) {
            profilePicLabel.setText("No Image");
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        profilePicLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        commentTextArea = new javax.swing.JTextArea();

        setLayout(new java.awt.BorderLayout());

        profilePicLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        profilePicLabel.setText("pic");
        profilePicLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        profilePicLabel.setMaximumSize(new java.awt.Dimension(40, 16));
        profilePicLabel.setMinimumSize(new java.awt.Dimension(40, 16));
        profilePicLabel.setPreferredSize(new java.awt.Dimension(40, 16));
        add(profilePicLabel, java.awt.BorderLayout.LINE_START);

        usernameLabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        usernameLabel.setText("Username");
        add(usernameLabel, java.awt.BorderLayout.CENTER);

        commentTextArea.setEditable(false);
        commentTextArea.setBackground(new java.awt.Color(204, 204, 255));
        commentTextArea.setColumns(20);
        commentTextArea.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        commentTextArea.setLineWrap(true);
        commentTextArea.setRows(5);
        commentTextArea.setWrapStyleWord(true);
        commentTextArea.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(commentTextArea);

        add(jScrollPane2, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea commentTextArea;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel profilePicLabel;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
