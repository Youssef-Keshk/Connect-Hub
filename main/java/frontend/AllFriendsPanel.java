package frontend;

import java.awt.Dimension;
import java.util.ArrayList;
import entities.User;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class AllFriendsPanel extends javax.swing.JPanel {
    ArrayList<User> friends;
    private final MainFrame parent;
    private final boolean flag;
 
    public AllFriendsPanel(ArrayList<User> friends, MainFrame parent, boolean flag) {
        this.friends = friends;
        this.parent = parent;
        this.flag = flag;
        initComponents();
        setPreferredSize(new Dimension(150, 200));
        setMinimumSize(new Dimension(150, 200));
        setMaximumSize(new Dimension(150, 200));
        friendListContainerPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        friendListContainerPanel.setLayout(new javax.swing.BoxLayout(friendListContainerPanel, javax.swing.BoxLayout.Y_AXIS));
        
        addPanels();
    }
    
    public void addPanels() {
        if(friends.isEmpty()) {
            JLabel label = new JLabel("You have no friends");

            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setVerticalAlignment(SwingConstants.CENTER);
            label.setFont(new Font("Arial", Font.BOLD, 12));
            friendListContainerPanel.add(label, BorderLayout.CENTER);
        }
            
        if(flag) {
            for(User user : friends)
                friendListContainerPanel.add(getItemFriendsPanel(user));
        }
        else {
            for(User user : friends)
                friendListContainerPanel.add(getItemManageFriendsPanel(user));
        }
    }
    
    
    
    public ItemFriendsPanel getItemFriendsPanel(User user) {
        return new ItemFriendsPanel(user, parent);
    }
    
    public ItemManageFriendsPanel getItemManageFriendsPanel(User user) {
        return new ItemManageFriendsPanel(user, parent);
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        friendListContainerPanel = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        titleLabel.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Friends");
        titleLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(titleLabel, java.awt.BorderLayout.PAGE_START);

        friendListContainerPanel.setLayout(new javax.swing.BoxLayout(friendListContainerPanel, javax.swing.BoxLayout.LINE_AXIS));
        jScrollPane1.setViewportView(friendListContainerPanel);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel friendListContainerPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
