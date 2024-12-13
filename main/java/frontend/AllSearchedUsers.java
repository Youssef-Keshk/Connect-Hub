package frontend;

import entities.User;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class AllSearchedUsers extends javax.swing.JPanel {
    ArrayList<User> userMatches;
    private final MainFrame parent;
    
    public AllSearchedUsers(MainFrame parent, ArrayList<User> userMatches) {
        this.userMatches = userMatches;
        this.parent = parent;
        initComponents();
        setPreferredSize(new Dimension(150, 200));
        setMinimumSize(new Dimension(150, 200));
        setMaximumSize(new Dimension(150, 200));
        usersContainerPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        usersContainerPanel.setLayout(new javax.swing.BoxLayout(usersContainerPanel, javax.swing.BoxLayout.Y_AXIS));
        
        addPanels();
    }
    
    public void addPanels() {
        if(userMatches.isEmpty()) {
            JLabel label = new JLabel("No users found!");

            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setVerticalAlignment(SwingConstants.CENTER);
            label.setFont(new Font("Arial", Font.BOLD, 12));
            usersContainerPanel.add(label, BorderLayout.CENTER);
        }

        for(User user : userMatches)
            usersContainerPanel.add(getItemSearchUserPanel(user));

    }
    
    public ItemSearchUserPanel getItemSearchUserPanel(User user) {
        return new ItemSearchUserPanel(parent, user);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usersContainerPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        usersContainerPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        usersContainerPanel.setLayout(new javax.swing.BoxLayout(usersContainerPanel, javax.swing.BoxLayout.LINE_AXIS));
        add(usersContainerPanel, java.awt.BorderLayout.CENTER);

        titleLabel.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Best Matching Users");
        titleLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        add(titleLabel, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel titleLabel;
    private javax.swing.JPanel usersContainerPanel;
    // End of variables declaration//GEN-END:variables
}
