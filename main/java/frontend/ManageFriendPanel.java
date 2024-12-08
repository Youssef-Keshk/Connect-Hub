package frontend;


import javax.swing.JDialog;
import managers.FriendshipManager;

public class ManageFriendPanel extends javax.swing.JPanel {
    String mainUserID;
    String friendID;
    FriendshipManager friendshipManager;
    JDialog parentDialog;
    
    public ManageFriendPanel(String mainUserID, String friendID, FriendshipManager friendshipManager, JDialog parentDialog) {
        this.mainUserID = mainUserID;
        this.friendID = friendID;
        this.friendshipManager = friendshipManager;
        this.parentDialog = parentDialog;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        removeButton = new javax.swing.JButton();
        blockButton = new javax.swing.JButton();

        removeButton.setBackground(new java.awt.Color(102, 0, 255));
        removeButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        removeButton.setForeground(new java.awt.Color(255, 255, 255));
        removeButton.setText("Remove");
        removeButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        blockButton.setBackground(new java.awt.Color(102, 0, 255));
        blockButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        blockButton.setForeground(new java.awt.Color(102, 0, 0));
        blockButton.setText("Block");
        blockButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        blockButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blockButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(blockButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(blockButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        friendshipManager.removeFriend(mainUserID, friendID);
        parentDialog.dispose();
    }//GEN-LAST:event_removeButtonActionPerformed

    private void blockButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blockButtonActionPerformed
        friendshipManager.blockUser(mainUserID, friendID);
        parentDialog.dispose();
    }//GEN-LAST:event_blockButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton blockButton;
    private javax.swing.JButton removeButton;
    // End of variables declaration//GEN-END:variables
}
