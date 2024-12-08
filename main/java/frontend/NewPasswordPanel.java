package frontend;

import authenticators.Validator;
import java.awt.Color;
import javax.swing.JOptionPane;


public class NewPasswordPanel extends javax.swing.JPanel {
    private final UpdateProfileDataDialoge parent;
    
    public NewPasswordPanel(UpdateProfileDataDialoge parent) {
        this.parent = parent;
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        newPasswordField = new javax.swing.JPasswordField();
        confirmNewPasswordField = new javax.swing.JPasswordField();
        showPasswordCheckBox = new javax.swing.JCheckBox();
        updateButton = new javax.swing.JButton();
        oldPasswordField = new javax.swing.JPasswordField();

        newPasswordField.setBackground(new java.awt.Color(204, 204, 255));
        newPasswordField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        newPasswordField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 255), 1, true));
        newPasswordField.setText("New password");
        newPasswordField.setEchoChar((char) 0);
        newPasswordField.setForeground(Color.GRAY);

        confirmNewPasswordField.setBackground(new java.awt.Color(204, 204, 255));
        confirmNewPasswordField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        confirmNewPasswordField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 255), 1, true));
        confirmNewPasswordField.setText("Confirm new password");
        confirmNewPasswordField.setEchoChar((char) 0);
        confirmNewPasswordField.setForeground(Color.GRAY);

        showPasswordCheckBox.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        showPasswordCheckBox.setText("show password");
        showPasswordCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPasswordCheckBoxActionPerformed(evt);
            }
        });

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

        oldPasswordField.setBackground(new java.awt.Color(204, 204, 255));
        oldPasswordField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        oldPasswordField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 255), 1, true));
        oldPasswordField.setText("Old password");
        oldPasswordField.setEchoChar((char) 0);
        oldPasswordField.setForeground(Color.GRAY);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(updateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(newPasswordField, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                            .addComponent(confirmNewPasswordField)
                            .addComponent(showPasswordCheckBox))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(oldPasswordField, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(oldPasswordField, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirmNewPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showPasswordCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        newPasswordField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (String.valueOf(newPasswordField.getPassword()).equals("New password")) {
                    newPasswordField.setText("");
                    if(!showPasswordCheckBox.isSelected())
                    newPasswordField.setEchoChar('•');
                    newPasswordField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (String.valueOf(newPasswordField.getPassword()).isEmpty()) {
                    newPasswordField.setText("New password");
                    newPasswordField.setEchoChar((char) 0);
                    newPasswordField.setForeground(Color.GRAY);
                }
            }
        });
        confirmNewPasswordField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (String.valueOf(confirmNewPasswordField.getPassword()).equals("Confirm new password")) {
                    confirmNewPasswordField.setText("");

                    if(!showPasswordCheckBox.isSelected())
                    confirmNewPasswordField.setEchoChar('•');
                    confirmNewPasswordField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (String.valueOf(confirmNewPasswordField.getPassword()).isEmpty()) {
                    confirmNewPasswordField.setText("Confirm new password");
                    confirmNewPasswordField.setEchoChar((char) 0);
                    confirmNewPasswordField.setForeground(Color.GRAY);
                }
            }
        });
        updateButton.setFocusable(true);
        updateButton.requestFocusInWindow();
        oldPasswordField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (String.valueOf(oldPasswordField.getPassword()).equals("Old password")) {
                    oldPasswordField.setText("");
                    if(!showPasswordCheckBox.isSelected())
                    oldPasswordField.setEchoChar('•');
                    oldPasswordField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (String.valueOf(oldPasswordField.getPassword()).isEmpty()) {
                    oldPasswordField.setText("Old password");
                    oldPasswordField.setEchoChar((char) 0);
                    oldPasswordField.setForeground(Color.GRAY);
                }
            }
        });
    }// </editor-fold>//GEN-END:initComponents

    private void showPasswordCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPasswordCheckBoxActionPerformed
        if (showPasswordCheckBox.isSelected()) {
            newPasswordField.setEchoChar((char) 0);
            confirmNewPasswordField.setEchoChar((char) 0);
            oldPasswordField.setEchoChar((char) 0);
        } else {
            if(!oldPasswordField.getText().equals("Old password"))
                oldPasswordField.setEchoChar('•');
            
            if(!newPasswordField.getText().equals("New password"))
                newPasswordField.setEchoChar('•');

            if(!confirmNewPasswordField.getText().equals("Confirm new password"))
                confirmNewPasswordField.setEchoChar('•');
        }
    }//GEN-LAST:event_showPasswordCheckBoxActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        if(!Validator.isValidPassword(newPasswordField.getText())) {
            JOptionPane.showMessageDialog(null, "Password must be 4 or more characters!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(!newPasswordField.getText().equals(confirmNewPasswordField.getText())) {
            JOptionPane.showMessageDialog(null, "Invalid confirmation!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        parent.updatePassword(oldPasswordField.getText(), newPasswordField.getText());
        
    }//GEN-LAST:event_updateButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField confirmNewPasswordField;
    private javax.swing.JPasswordField newPasswordField;
    private javax.swing.JPasswordField oldPasswordField;
    private javax.swing.JCheckBox showPasswordCheckBox;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
