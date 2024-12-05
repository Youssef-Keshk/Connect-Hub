package profilemanagement.frontend;

import useraccountmanagement.backend.User;
import authenticator.PasswordHashing;
import javax.swing.JOptionPane;

public class ChangePasswordWindow extends javax.swing.JFrame {

    User user;

    public ChangePasswordWindow(User user) {
        this.user = user;
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        currentPasswordLabel = new java.awt.Label();
        newPasswordLabel = new java.awt.Label();
        confirmPasswordLabel = new java.awt.Label();
        updatePasswordButton = new javax.swing.JButton();
        currentPasswordField = new javax.swing.JPasswordField();
        newPasswordField = new javax.swing.JPasswordField();
        confirmPasswordField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        currentPasswordLabel.setAlignment(java.awt.Label.CENTER);
        currentPasswordLabel.setBackground(new java.awt.Color(255, 255, 255));
        currentPasswordLabel.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        currentPasswordLabel.setText("Current Password");

        newPasswordLabel.setAlignment(java.awt.Label.CENTER);
        newPasswordLabel.setBackground(new java.awt.Color(255, 255, 255));
        newPasswordLabel.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        newPasswordLabel.setText("New Password");

        confirmPasswordLabel.setAlignment(java.awt.Label.CENTER);
        confirmPasswordLabel.setBackground(new java.awt.Color(255, 255, 255));
        confirmPasswordLabel.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        confirmPasswordLabel.setText("Confirm New Password");

        updatePasswordButton.setText("Update Password");
        updatePasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatePasswordButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(newPasswordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(confirmPasswordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(currentPasswordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(currentPasswordField)
                            .addComponent(newPasswordField)
                            .addComponent(confirmPasswordField, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(updatePasswordButton, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(currentPasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(currentPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(newPasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(newPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(confirmPasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(updatePasswordButton)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updatePasswordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatePasswordButtonActionPerformed
       // Get the current password from the password field
    String currentPassword = new String(currentPasswordField.getPassword());

    // Check if the current password matches the user's password
    if (PasswordHashing.comparePasswords(currentPassword, user.getPassword())) {
        // Get the new password and confirmation from the fields
        String newPassword = new String(newPasswordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());

        // Check if the new password matches the confirmation
        if (newPassword.equals(confirmPassword)) {
            // Validate the new password
            if (newPassword.isEmpty() || newPassword.length() < 4) {
                JOptionPane.showMessageDialog(this, 
                    "New password must be at least 4 characters long.", 
                    "Invalid Password", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Hash the new password and update the user's password
            String hashedPassword = PasswordHashing.getHashedPassword(newPassword);
            user.setPassword(hashedPassword);

            // Display success message
            JOptionPane.showMessageDialog(this, 
                "Password updated successfully.", 
                "Success", 
                JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } else {
            // Display error for mismatch
            JOptionPane.showMessageDialog(this, 
                "New password and confirmation do not match.", 
                "Password Mismatch", 
                JOptionPane.ERROR_MESSAGE);
        }
    } else {
        // Display error for incorrect current password
        JOptionPane.showMessageDialog(this, 
            "incorrect Current password.", 
            "Authentication Failed", 
            JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_updatePasswordButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField confirmPasswordField;
    private java.awt.Label confirmPasswordLabel;
    private javax.swing.JPasswordField currentPasswordField;
    private java.awt.Label currentPasswordLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField newPasswordField;
    private java.awt.Label newPasswordLabel;
    private javax.swing.JButton updatePasswordButton;
    // End of variables declaration//GEN-END:variables
}
