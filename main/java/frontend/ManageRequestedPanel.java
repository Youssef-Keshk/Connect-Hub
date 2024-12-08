package frontend;
import entities.User;
import managers.FriendshipManager;
import javax.swing.JDialog;

public class ManageRequestedPanel extends javax.swing.JPanel {
    String mainUserID;
    String friendID;
    FriendshipManager friendshipManager;
    JDialog parentDialog;
    public ManageRequestedPanel(String mainUserID, String friendID, FriendshipManager friendshipManager, JDialog parentDialog) {
        this.mainUserID = mainUserID;
        this.friendID = friendID;
        this.friendshipManager = friendshipManager;
        this.parentDialog = parentDialog;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        acceptButton = new javax.swing.JButton();
        rejectButton = new javax.swing.JButton();

        acceptButton.setBackground(new java.awt.Color(102, 0, 255));
        acceptButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        acceptButton.setForeground(new java.awt.Color(255, 255, 255));
        acceptButton.setText("Accept");
        acceptButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        acceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptButtonActionPerformed(evt);
            }
        });

        rejectButton.setBackground(new java.awt.Color(102, 0, 255));
        rejectButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        rejectButton.setForeground(new java.awt.Color(255, 255, 255));
        rejectButton.setText("Reject");
        rejectButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        rejectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rejectButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(acceptButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rejectButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(acceptButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rejectButton, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void acceptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptButtonActionPerformed
        friendshipManager.acceptRequest(friendID, mainUserID);
        parentDialog.dispose();
    }//GEN-LAST:event_acceptButtonActionPerformed

    private void rejectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rejectButtonActionPerformed
        friendshipManager.declineRequest(friendID, mainUserID);   
        parentDialog.dispose();
    }//GEN-LAST:event_rejectButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptButton;
    private javax.swing.JButton rejectButton;
    // End of variables declaration//GEN-END:variables
}
