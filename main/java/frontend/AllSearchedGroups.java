package frontend;

import entities.Group;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class AllSearchedGroups extends javax.swing.JPanel {
    ArrayList<Group> groupMatches;
    private final MainFrame parent;
    
    public AllSearchedGroups(MainFrame parent, ArrayList<Group> groupMatches) {
        this.groupMatches = groupMatches;
        this.parent = parent;
        initComponents();
        setPreferredSize(new Dimension(150, 200));
        setMinimumSize(new Dimension(150, 200));
        setMaximumSize(new Dimension(150, 200));
        groupsContainerPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        groupsContainerPanel.setLayout(new javax.swing.BoxLayout(groupsContainerPanel, javax.swing.BoxLayout.Y_AXIS));
        
        addPanels();
    }
    
    public void addPanels() {
        if(groupMatches.isEmpty()) {
            JLabel label = new JLabel("No groups found!");

            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setVerticalAlignment(SwingConstants.CENTER);
            label.setFont(new Font("Arial", Font.BOLD, 12));
            groupsContainerPanel.add(label, BorderLayout.CENTER);
        }

        for(Group group : groupMatches)
            groupsContainerPanel.add(getItemSearchGroupPanel(group));

    }
    
    public ItemSearchGroupPanel getItemSearchGroupPanel(Group group) {
        return new ItemSearchGroupPanel(parent, group);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        groupsContainerPanel = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        titleLabel.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Best Matching Groups");
        titleLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(titleLabel, java.awt.BorderLayout.PAGE_START);

        groupsContainerPanel.setLayout(new javax.swing.BoxLayout(groupsContainerPanel, javax.swing.BoxLayout.LINE_AXIS));
        add(groupsContainerPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel groupsContainerPanel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
