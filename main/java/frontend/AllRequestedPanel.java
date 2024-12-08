package frontend;

import java.awt.Dimension;
import java.util.ArrayList;
import entities.User;
import java.awt.Component;


public class AllRequestedPanel extends javax.swing.JPanel {
    ArrayList<User> requested;
    private final MainFrame parent;
 
    public AllRequestedPanel(ArrayList<User> friends, MainFrame parent) {
        this.requested = friends;
        this.parent = parent;
        initComponents();
        //setPreferredSize(new Dimension(240, 600));
        //setMinimumSize(new Dimension(220, 600));
        setMaximumSize(new Dimension(240, 200));
        requestsListContainerPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        requestsListContainerPanel.setLayout(new javax.swing.BoxLayout(requestsListContainerPanel, javax.swing.BoxLayout.Y_AXIS));
        
        addPanels();
    }
    
    public void addPanels() {
        for(User user : requested)
            requestsListContainerPanel.add(getItemFriendSuggestionPanel(user));
    }
    
    
    public ItemRequsetedPanel getItemFriendSuggestionPanel(User user) {
        return new ItemRequsetedPanel(user, parent);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        requestsListContainerPanel = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        titleLabel.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Requests");
        titleLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(titleLabel, java.awt.BorderLayout.PAGE_START);

        requestsListContainerPanel.setLayout(new javax.swing.BoxLayout(requestsListContainerPanel, javax.swing.BoxLayout.LINE_AXIS));
        jScrollPane1.setViewportView(requestsListContainerPanel);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel requestsListContainerPanel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
