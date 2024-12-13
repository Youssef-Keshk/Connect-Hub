package frontend;

import entities.User;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class SuggestedFriendsPanel extends javax.swing.JPanel {
    ArrayList<User> suggestedsFriends;
    MainFrame parent;
 
    public SuggestedFriendsPanel(ArrayList<User> suggestedsFriends, MainFrame parent) {
        this.suggestedsFriends = suggestedsFriends;
        this.parent = parent;
        initComponents();
        setPreferredSize(new Dimension(150, 200));
        setMinimumSize(new Dimension(150, 200));
        setMaximumSize(new Dimension(150, 200));
        suggestionListContainerPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        suggestionListContainerPanel.setLayout(new javax.swing.BoxLayout(suggestionListContainerPanel, javax.swing.BoxLayout.Y_AXIS));
        
        addPanels();
    }
    
    public void addPanels() {
        if(suggestedsFriends.isEmpty()) {
            JLabel label = new JLabel("No users to suggest");

            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setVerticalAlignment(SwingConstants.CENTER);
            label.setFont(new Font("Arial", Font.BOLD, 12));
            suggestionListContainerPanel.add(label, BorderLayout.CENTER);
        }
        for(User user : suggestedsFriends)
            suggestionListContainerPanel.add(getItemFriendSuggestionPanel(user));
    }
    
    
    public ItemFriendSuggestionPanel getItemFriendSuggestionPanel(User user) {
        return new ItemFriendSuggestionPanel(user,parent);
    }
    
//    @Override
//    public Dimension getPreferredSize() {
//        return new Dimension(240, 600); // Width and height for the panel
//    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        suggestionsScrollPane = new javax.swing.JScrollPane();
        suggestionListContainerPanel = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        titleLabel.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Friend Suggestions");
        titleLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        titleLabel.setMaximumSize(new java.awt.Dimension(240, 21));
        titleLabel.setMinimumSize(new java.awt.Dimension(220, 21));
        titleLabel.setPreferredSize(new java.awt.Dimension(220, 21));
        add(titleLabel, java.awt.BorderLayout.PAGE_START);

        suggestionListContainerPanel.setBackground(javax.swing.UIManager.getDefaults().getColor("MenuBar.hoverBackground"));
        suggestionListContainerPanel.setLayout(new javax.swing.BoxLayout(suggestionListContainerPanel, javax.swing.BoxLayout.LINE_AXIS));

        suggestionListContainerPanel.setLayout(new javax.swing.BoxLayout(suggestionListContainerPanel, javax.swing.BoxLayout.Y_AXIS));

        suggestionsScrollPane.setViewportView(suggestionListContainerPanel);

        add(suggestionsScrollPane, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel suggestionListContainerPanel;
    private javax.swing.JScrollPane suggestionsScrollPane;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
    
}


