package frontend;


public class PrimaryChatBarPanel extends javax.swing.JPanel {

    
    public PrimaryChatBarPanel(String text) {
        initComponents();
        chatTextField.setText(text);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chatTextField = new javax.swing.JTextField();

        setMaximumSize(new java.awt.Dimension(300, 32));
        setMinimumSize(new java.awt.Dimension(300, 32));
        setPreferredSize(new java.awt.Dimension(300, 32));
        setLayout(new java.awt.BorderLayout());

        chatTextField.setEditable(false);
        chatTextField.setBackground(new java.awt.Color(102, 0, 255));
        chatTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        chatTextField.setForeground(new java.awt.Color(255, 255, 255));
        chatTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        chatTextField.setText("text");
        chatTextField.setToolTipText("");
        chatTextField.setBorder(null);
        add(chatTextField, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField chatTextField;
    // End of variables declaration//GEN-END:variables
}
