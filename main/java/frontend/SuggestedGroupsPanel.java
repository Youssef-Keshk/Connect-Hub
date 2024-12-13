package frontend;

import entities.Group;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class SuggestedGroupsPanel extends javax.swing.JPanel {
    ArrayList<Group> suggestedsGroups;
    MainFrame parent;
    
    public SuggestedGroupsPanel(MainFrame parent, ArrayList<Group> suggestedsGroups) {
        this.suggestedsGroups = suggestedsGroups;
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
        if(suggestedsGroups.isEmpty()) {
            JLabel label = new JLabel("No groups to suggest");

            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setVerticalAlignment(SwingConstants.CENTER);
            label.setFont(new Font("Arial", Font.BOLD, 12));
            suggestionListContainerPanel.add(label, BorderLayout.CENTER);
        }
        for(Group group : suggestedsGroups)
            suggestionListContainerPanel.add(getItemGroupSuggestionPanel(group));
    }
    
    
    public ItemGroupSuggestionPanel getItemGroupSuggestionPanel(Group group) {
        return new ItemGroupSuggestionPanel(parent, group);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        suggestionListContainerPanel = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        titleLabel.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Group Suggestions");
        titleLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        titleLabel.setMaximumSize(new java.awt.Dimension(240, 21));
        titleLabel.setMinimumSize(new java.awt.Dimension(220, 21));
        titleLabel.setPreferredSize(new java.awt.Dimension(220, 21));
        add(titleLabel, java.awt.BorderLayout.PAGE_START);

        suggestionListContainerPanel.setBackground(javax.swing.UIManager.getDefaults().getColor("MenuBar.hoverBackground"));
        suggestionListContainerPanel.setLayout(new javax.swing.BoxLayout(suggestionListContainerPanel, javax.swing.BoxLayout.LINE_AXIS));

        suggestionListContainerPanel.setLayout(new javax.swing.BoxLayout(suggestionListContainerPanel, javax.swing.BoxLayout.Y_AXIS));

        add(suggestionListContainerPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel suggestionListContainerPanel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
