package frontend;

import java.awt.Color;
import managers.AccountManager;
import entities.User;
import javax.swing.JOptionPane;


public class LoginPanel extends javax.swing.JPanel {
    private final MainFrame parent;
    private final AccountManager accountManager;
    private String username;
    private String password;
    
    public LoginPanel(MainFrame parent) {
        this.parent = parent;
        accountManager = parent.getAccountManager();
        initComponents();
    }
    
    public void resetLabels() {
        usernameTextField.setText("Username");
        passwordField.setText("Password");
        showPasswordCheckBox.setSelected(false);
        passwordField.setEchoChar((char) 0); 
        
        usernameTextField.setForeground(Color.GRAY);
        passwordField.setForeground(Color.GRAY);
        
        welcomLabel.setFocusable(true);
        welcomLabel.requestFocusInWindow();
        
    }
    
    public void startLogin() {
        resetLabels();
    }
    
    private void setValues() throws NullPointerException{
        username = usernameTextField.getText().trim();
        password = passwordField.getText().trim();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        usernameTextField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        signupButton = new javax.swing.JButton();
        welcomLabel = new javax.swing.JLabel();
        showPasswordCheckBox = new javax.swing.JCheckBox();

        usernameTextField.setText("Username");
        usernameTextField.setForeground(Color.GRAY);
        usernameTextField.setBackground(new java.awt.Color(204, 204, 255));
        usernameTextField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        usernameTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 255), 1, true));

        passwordField.setBackground(new java.awt.Color(204, 204, 255));
        passwordField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        passwordField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 255), 1, true));
        passwordField.setText("Password");
        passwordField.setEchoChar((char) 0);
        passwordField.setForeground(Color.GRAY);

        loginButton.setBackground(new java.awt.Color(102, 0, 255));
        loginButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        loginButton.setForeground(new java.awt.Color(255, 255, 255));
        loginButton.setText("Login");
        loginButton.setBorder(null);
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        signupButton.setBackground(new java.awt.Color(102, 0, 255));
        signupButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        signupButton.setText("Sign up");
        signupButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 255)));
        signupButton.setBorderPainted(false);
        signupButton.setContentAreaFilled(false);
        signupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupButtonActionPerformed(evt);
            }
        });

        welcomLabel.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        welcomLabel.setForeground(new java.awt.Color(102, 0, 255));
        welcomLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcomLabel.setText("Connect Hub");

        showPasswordCheckBox.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        showPasswordCheckBox.setText("show password");
        showPasswordCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPasswordCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(welcomLabel)
                            .addComponent(signupButton)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(usernameTextField)
                            .addComponent(passwordField)
                            .addComponent(loginButton, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                            .addComponent(showPasswordCheckBox))))
                .addContainerGap(218, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(welcomLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showPasswordCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(signupButton, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        usernameTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (usernameTextField.getText().equals("Username")) {
                    usernameTextField.setText("");
                    usernameTextField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (usernameTextField.getText().isEmpty()) {
                    usernameTextField.setText("Username");
                    usernameTextField.setForeground(Color.GRAY);
                }
            }
        });
        passwordField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (String.valueOf(passwordField.getPassword()).equals("Password")) {
                    passwordField.setText("");
                    if(!showPasswordCheckBox.isSelected())
                    passwordField.setEchoChar('•');
                    passwordField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (String.valueOf(passwordField.getPassword()).isEmpty()) {
                    passwordField.setText("Password");
                    passwordField.setEchoChar((char) 0);
                    passwordField.setForeground(Color.GRAY);
                }
            }
        });
        welcomLabel.setFocusable(true);
        welcomLabel.requestFocusInWindow();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 417, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void signupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupButtonActionPerformed
        parent.switchToSignupPage();
    }//GEN-LAST:event_signupButtonActionPerformed

    private void showPasswordCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPasswordCheckBoxActionPerformed
     if (showPasswordCheckBox.isSelected()) {
            passwordField.setEchoChar((char) 0); 
        } else {
            if(!passwordField.getText().equals("Password"))
                passwordField.setEchoChar('•');
        }
    }//GEN-LAST:event_showPasswordCheckBoxActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
       try {
           setValues();
       } catch (NullPointerException e){
           JOptionPane.showMessageDialog(null, "Some feilds are empty!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
       }
       User user = accountManager.login(username, password);
       if(user != null) {
           parent.setUser(user);
           parent.switchToNewsFeedPage();
       }
       else
        JOptionPane.showMessageDialog(null, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);     
    }//GEN-LAST:event_loginButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JCheckBox showPasswordCheckBox;
    private javax.swing.JButton signupButton;
    private javax.swing.JTextField usernameTextField;
    private javax.swing.JLabel welcomLabel;
    // End of variables declaration//GEN-END:variables
}
