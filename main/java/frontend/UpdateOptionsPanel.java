package frontend;


public class UpdateOptionsPanel extends javax.swing.JPanel {
    private final UpdateProfileDataDialoge parent;
    
    public UpdateOptionsPanel(UpdateProfileDataDialoge parent) {
        this.parent = parent;
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        changeProfilePhotoButton = new javax.swing.JButton();
        changeCoverPhotoButton = new javax.swing.JButton();
        changeBioButton = new javax.swing.JButton();
        changePasswordButton = new javax.swing.JButton();

        changeProfilePhotoButton.setBackground(new java.awt.Color(102, 0, 255));
        changeProfilePhotoButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        changeProfilePhotoButton.setForeground(new java.awt.Color(255, 255, 255));
        changeProfilePhotoButton.setText("Profile photo");
        changeProfilePhotoButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        changeProfilePhotoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeProfilePhotoButtonActionPerformed(evt);
            }
        });

        changeCoverPhotoButton.setBackground(new java.awt.Color(102, 0, 255));
        changeCoverPhotoButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        changeCoverPhotoButton.setForeground(new java.awt.Color(255, 255, 255));
        changeCoverPhotoButton.setText("Cover Photo");
        changeCoverPhotoButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        changeCoverPhotoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeCoverPhotoButtonActionPerformed(evt);
            }
        });

        changeBioButton.setBackground(new java.awt.Color(102, 0, 255));
        changeBioButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        changeBioButton.setForeground(new java.awt.Color(255, 255, 255));
        changeBioButton.setText("Bio");
        changeBioButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        changeBioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeBioButtonActionPerformed(evt);
            }
        });

        changePasswordButton.setBackground(new java.awt.Color(102, 0, 255));
        changePasswordButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        changePasswordButton.setForeground(new java.awt.Color(255, 255, 255));
        changePasswordButton.setText("Password");
        changePasswordButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        changePasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePasswordButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(changeProfilePhotoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changeBioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changeCoverPhotoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changePasswordButton, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(changeProfilePhotoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(changeCoverPhotoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(changeBioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(changePasswordButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void changeProfilePhotoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeProfilePhotoButtonActionPerformed
        parent.updateProfilePic();
    }//GEN-LAST:event_changeProfilePhotoButtonActionPerformed

    private void changeCoverPhotoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeCoverPhotoButtonActionPerformed
        parent.updateCoverPic();
    }//GEN-LAST:event_changeCoverPhotoButtonActionPerformed

    private void changeBioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeBioButtonActionPerformed
        parent.switchToNewBioPage();
    }//GEN-LAST:event_changeBioButtonActionPerformed

    private void changePasswordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePasswordButtonActionPerformed
        parent.switchToNewPasswordPage();
    }//GEN-LAST:event_changePasswordButtonActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton changeBioButton;
    private javax.swing.JButton changeCoverPhotoButton;
    private javax.swing.JButton changePasswordButton;
    private javax.swing.JButton changeProfilePhotoButton;
    // End of variables declaration//GEN-END:variables
}
