package frontend;

import java.awt.Color;


public class NewBioPanel extends javax.swing.JPanel {
    private final UpdateProfileDataDialoge parent;
    
    public NewBioPanel(UpdateProfileDataDialoge parent) {
        this.parent = parent;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        updateButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        newBioTextArea = new javax.swing.JTextArea();

        updateButton.setBackground(new java.awt.Color(102, 0, 255));
        updateButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        updateButton.setForeground(new java.awt.Color(255, 255, 255));
        updateButton.setText("Update");
        updateButton.setBorder(null);
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        newBioTextArea.setText("Enter new bio");
        newBioTextArea.setForeground(Color.GRAY);
        newBioTextArea.setBackground(new java.awt.Color(204, 204, 255));
        newBioTextArea.setColumns(20);
        newBioTextArea.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        newBioTextArea.setLineWrap(true);
        newBioTextArea.setRows(5);
        newBioTextArea.setWrapStyleWord(true);
        newBioTextArea.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 255), 1, true));
        newBioTextArea.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jScrollPane1.setViewportView(newBioTextArea);
        newBioTextArea.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (newBioTextArea.getText().equals("Enter new bio")) {
                    newBioTextArea.setText("");
                    newBioTextArea.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (newBioTextArea.getText().isEmpty()) {
                    newBioTextArea.setText("Enter new bio");
                    newBioTextArea.setForeground(Color.GRAY);
                }
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        updateButton.setFocusable(true);
        updateButton.requestFocusInWindow();
    }// </editor-fold>//GEN-END:initComponents

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        parent.updateBio(newBioTextArea.getText());
    }//GEN-LAST:event_updateButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea newBioTextArea;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
