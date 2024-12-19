package frontend;


import java.awt.BorderLayout;
import java.awt.Frame;
import javax.swing.JDialog;
import managers.FriendshipManager;

public class ManageFriendPanel extends javax.swing.JPanel {
    private MainFrame parent;
    private String mainUserID;
    private String friendID;
    private FriendshipManager friendshipManager;
    private JDialog parentDialog;
    
    public ManageFriendPanel(MainFrame parent, String friendID, JDialog parentDialog) {
        this.parent = parent;
        this.mainUserID = parent.getUser().getUserId();
        this.friendID = friendID;
        this.friendshipManager = parent.getFriendshipManager();
        this.parentDialog = parentDialog;
        initComponents();
    }
    public void apearChatPanel(){
        try {
            // Create the dialog
            JDialog dialog = new JDialog((Frame) null, "Private chat", true);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

            // Create and set up the ManageRequestedPanel
            ChatPanel chatPanel = new ChatPanel(parent, friendID);
            dialog.setLayout(new BorderLayout());
            dialog.add(chatPanel, BorderLayout.CENTER);

            // Set dialog size and location
            dialog.pack();
            dialog.setLocationRelativeTo(null); // Center the dialog

            // Show the dialog
            dialog.setVisible(true);
        } catch (Exception e) {
            System.out.println("Error showing chatPanel" + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        removeButton = new javax.swing.JButton();
        blockButton = new javax.swing.JButton();
        chatButton = new javax.swing.JButton();

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

        chatButton.setBackground(new java.awt.Color(102, 0, 255));
        chatButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        chatButton.setForeground(new java.awt.Color(255, 255, 255));
        chatButton.setText("Chat");
        chatButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        chatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chatButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(blockButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chatButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chatButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

    private void chatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chatButtonActionPerformed
        parentDialog.dispose();
        apearChatPanel();
    }//GEN-LAST:event_chatButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton blockButton;
    private javax.swing.JButton chatButton;
    private javax.swing.JButton removeButton;
    // End of variables declaration//GEN-END:variables
}
