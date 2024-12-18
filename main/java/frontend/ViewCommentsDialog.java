package frontend;

import entities.Comment;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ViewCommentsDialog extends javax.swing.JDialog {
    private final MainFrame parent;
    private final ArrayList<Comment> comments;
   
    public ViewCommentsDialog(MainFrame parent, ArrayList<Comment> comments) {
        super(parent, true);
        this.parent = parent;
        this.comments = comments;
        
        initComponents();
        setPreferredSize(new Dimension(287, 235));
        setMinimumSize(new Dimension(287, 235));
        setMaximumSize(new Dimension(287, 235));
        
        commentsContainerPanel.setLayout(new javax.swing.BoxLayout(commentsContainerPanel, javax.swing.BoxLayout.Y_AXIS));
        viewComments();
        
        setLocationRelativeTo(null);
    }
    
    public void viewComments() {
        
        if(comments.isEmpty()) {
            JLabel label = new JLabel("No comments");

            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setVerticalAlignment(SwingConstants.CENTER);
            label.setFont(new Font("Arial", Font.BOLD, 12));
            commentsContainerPanel.add(label, BorderLayout.CENTER);
        }
        
        for(Comment comment : comments) {
            ItemCommentPanel icp = new ItemCommentPanel(parent, comment);
            commentsContainerPanel.add(icp);
            
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        commentsContainerPanel = new javax.swing.JPanel();
        commentsLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.BorderLayout());

        commentsContainerPanel.setLayout(new javax.swing.BoxLayout(commentsContainerPanel, javax.swing.BoxLayout.LINE_AXIS));
        jScrollPane1.setViewportView(commentsContainerPanel);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        commentsLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        commentsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        commentsLabel.setText("Comments");
        commentsLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel2.add(commentsLabel, java.awt.BorderLayout.PAGE_START);

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel commentsContainerPanel;
    private javax.swing.JLabel commentsLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
