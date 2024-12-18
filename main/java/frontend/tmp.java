/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package frontend;

/**
 *
 * @author Youssef
 */
public class tmp extends javax.swing.JPanel {

    /**
     * Creates new form tmp
     */
    public tmp() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        profileContainerPanel = new javax.swing.JPanel();
        profileDataPanel = new javax.swing.JPanel();
        groupPicLabel = new javax.swing.JLabel();
        groupNameLabel = new javax.swing.JLabel();
        descriptionTextField = new javax.swing.JTextField();
        postsPanel = new javax.swing.JPanel();

        profileContainerPanel.setMaximumSize(new java.awt.Dimension(501, 32767));

        profileDataPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 102), 1, true));
        profileDataPanel.setMaximumSize(new java.awt.Dimension(493, 134));

        groupPicLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        groupPicLabel.setForeground(new java.awt.Color(102, 0, 255));
        groupPicLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        groupPicLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        groupNameLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        groupNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        groupNameLabel.setText("Group Name");

        descriptionTextField.setEditable(false);
        descriptionTextField.setBackground(new java.awt.Color(255, 255, 255));
        descriptionTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        descriptionTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        descriptionTextField.setText("Description");
        descriptionTextField.setBorder(null);

        javax.swing.GroupLayout profileDataPanelLayout = new javax.swing.GroupLayout(profileDataPanel);
        profileDataPanel.setLayout(profileDataPanelLayout);
        profileDataPanelLayout.setHorizontalGroup(
            profileDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profileDataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(profileDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, profileDataPanelLayout.createSequentialGroup()
                        .addComponent(groupPicLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(groupNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(descriptionTextField))
                .addGap(14, 14, 14))
        );
        profileDataPanelLayout.setVerticalGroup(
            profileDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profileDataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(profileDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(groupPicLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(groupNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descriptionTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        postsPanel.setBackground(new java.awt.Color(255, 255, 255));
        postsPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        postsPanel.setLayout(new javax.swing.BoxLayout(postsPanel, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout profileContainerPanelLayout = new javax.swing.GroupLayout(profileContainerPanel);
        profileContainerPanel.setLayout(profileContainerPanelLayout);
        profileContainerPanelLayout.setHorizontalGroup(
            profileContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profileContainerPanelLayout.createSequentialGroup()
                .addGroup(profileContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(profileDataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(postsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        profileContainerPanelLayout.setVerticalGroup(
            profileContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profileContainerPanelLayout.createSequentialGroup()
                .addComponent(profileDataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(postsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 513, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(profileContainerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addComponent(profileContainerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(30, 30, 30)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField descriptionTextField;
    private javax.swing.JLabel groupNameLabel;
    private javax.swing.JLabel groupPicLabel;
    private javax.swing.JPanel postsPanel;
    private javax.swing.JPanel profileContainerPanel;
    private javax.swing.JPanel profileDataPanel;
    // End of variables declaration//GEN-END:variables
}