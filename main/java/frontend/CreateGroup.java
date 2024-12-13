package frontend;

import entities.User;


public class CreateGroup extends javax.swing.JPanel {
    private final MainFrame parent;
    private User user;
    
    public CreateGroup(MainFrame parent) {
        this.parent = parent;
        initComponents();
    }
    
    public void startCreateGroup() {
        this.user = parent.getUser();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ProfileButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        selectionLabel = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        groupNameTextField = new javax.swing.JTextField();
        descriptionTextField = new javax.swing.JTextField()
        ;
        createButton = new javax.swing.JButton();
        uploadButton = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(200, 200, 200));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 255), 2, true));
        jPanel1.setMaximumSize(new java.awt.Dimension(89, 32767));
        jPanel1.setPreferredSize(new java.awt.Dimension(89, 400));

        ProfileButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ProfileButton.setForeground(new java.awt.Color(102, 0, 255));
        ProfileButton.setText("Profile");
        ProfileButton.setToolTipText("");
        ProfileButton.setBorder(null);
        ProfileButton.setBorderPainted(false);
        ProfileButton.setContentAreaFilled(false);
        ProfileButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ProfileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProfileButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ProfileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ProfileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        selectionLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        selectionLabel.setForeground(new java.awt.Color(102, 0, 255));
        selectionLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        selectionLabel.setText("Select Group");

        groupNameTextField.setText("Group Name");
        groupNameTextField.setForeground(Color.GRAY);
        groupNameTextField.setBackground(new java.awt.Color(204, 204, 255));
        groupNameTextField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        groupNameTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 255), 1, true));

        descriptionTextField.setText("Group Description");
        descriptionTextField.setForeground(Color.GRAY);
        descriptionTextField.setBackground(new java.awt.Color(204, 204, 255));
        descriptionTextField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        descriptionTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 255), 1, true));

        createButton.setBackground(new java.awt.Color(102, 0, 255));
        createButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        createButton.setForeground(new java.awt.Color(255, 255, 255));
        createButton.setText("Create");
        createButton.setBorder(null);
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });

        uploadButton.setBorderPainted(false);
        uploadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(selectionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(createButton, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(descriptionTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                                .addComponent(groupNameTextField))
                            .addComponent(uploadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(137, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(selectionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(groupNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(uploadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(createButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        selectionLabel.setFocusable(true);
        selectionLabel.requestFocusInWindow();
        groupNameTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (groupNameTextField.getText().equals("Group Name")) {
                    groupNameTextField.setText("");
                    groupNameTextField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (groupNameTextField.getText().isEmpty()) {
                    groupNameTextField.setText("Group Name");
                    groupNameTextField.setForeground(Color.GRAY);
                }
            }
        });
        descriptionTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (descriptionTextField.getText().equals("Group Description")) {
                    descriptionTextField.setText("");
                    descriptionTextField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (descriptionTextField.getText().isEmpty()) {
                    descriptionTextField.setText("Group Description");
                    descriptionTextField.setForeground(Color.GRAY);
                }
            }
        });
        try {
            ImageIcon icon = new ImageIcon(FilePaths.UPLOAD_PHOTO_ICON);
            if (icon.getImageLoadStatus() == MediaTracker.COMPLETE) {
                Image image = icon.getImage().getScaledInstance(30, 16, Image.SCALE_SMOOTH);
                uploadButton.setIcon(new ImageIcon(image));
            } else {
                uploadButton.setText("Upload");
            }
        } catch (Exception e) {
            uploadButton.setText("Upload");
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ProfileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProfileButtonActionPerformed
        parent.switchToProfilePage();
    }//GEN-LAST:event_ProfileButtonActionPerformed

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
        boolean success;
        try{
            setValues();
            success = validateData();
            if(!success)
            return;
        }catch(NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Some feilds are empty!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Profile profile = createProfile();
        User user = createUser(profile);

        success = accountManager.signup(user);

        if(success){
            parent.setUser(user);
            parent.switchToProfilePage();
        }
        else
        JOptionPane.showMessageDialog(null, "Username or password already used!", "Error", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_createButtonActionPerformed

    private void uploadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadButtonActionPerformed
        newContentPhotopath = getNewPath("Choose a photo");
    }//GEN-LAST:event_uploadButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ProfileButton;
    private javax.swing.JButton createButton;
    private javax.swing.JTextField descriptionTextField;
    private javax.swing.JTextField groupNameTextField;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel selectionLabel;
    private javax.swing.JButton uploadButton;
    // End of variables declaration//GEN-END:variables
}
