package frontend;

import java.awt.Dimension;
import java.util.ArrayList;
import entities.Group;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class AllGroupsPanel extends javax.swing.JPanel {
    ArrayList<Group> groups;
    private final MainFrame parent;
    
    public AllGroupsPanel(MainFrame parent, ArrayList<Group> groups) {
        this.groups = groups;
        this.parent = parent;
        initComponents();
        setPreferredSize(new Dimension(150, 200));
        setMinimumSize(new Dimension(150, 200));
        setMaximumSize(new Dimension(150, 200));
        groupListContainerPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        groupListContainerPanel.setLayout(new javax.swing.BoxLayout(groupListContainerPanel, javax.swing.BoxLayout.Y_AXIS));
        
        addPanels();
    }
    
    public void addPanels() {
        if(groups.isEmpty()) {
            JLabel label = new JLabel("You have no groups");

            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setVerticalAlignment(SwingConstants.CENTER);
            label.setFont(new Font("Arial", Font.BOLD, 12));
            groupListContainerPanel.add(label, BorderLayout.CENTER);
        }
        for(Group group : groups)
            groupListContainerPanel.add(getItemGroupPanel(group));
    }
    
   
    public ItemGroupPanel getItemGroupPanel(Group group) {
        return new ItemGroupPanel(parent, group);
    }


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        groupListContainerPanel = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        titleLabel.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Groups");
        titleLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(titleLabel, java.awt.BorderLayout.PAGE_START);

        groupListContainerPanel.setLayout(new javax.swing.BoxLayout(groupListContainerPanel, javax.swing.BoxLayout.LINE_AXIS));
        add(groupListContainerPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel groupListContainerPanel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
