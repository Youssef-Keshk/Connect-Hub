package frontend;

import java.awt.CardLayout;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import managers.ProfileManager;


public class UpdateProfileDataDialoge extends javax.swing.JDialog {
    private final CardLayout cardLayout;
    private final JPanel mainPanel;
    private final ProfileManager profileManager;
    private final String userId;
    
    public UpdateProfileDataDialoge(MainFrame parent, String title, boolean modal) {
        super(parent, modal);
        userId = parent.getUser().getUserId();        
        this.profileManager = parent.getProfileManager();
        
        initComponents();
        setTitle(title);
        
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        
        setAllPanels();
        add(mainPanel);
        pack();
        setLocationRelativeTo(parent);
        setVisible(true);
    }
    
    public void setAllPanels() {
        mainPanel.add(new UpdateOptionsPanel(this), "options");
        mainPanel.add(new NewPasswordPanel(this), "newPassword");
        mainPanel.add(new NewBioPanel(this), "newBio");
    }
    
    public void switchToNewPasswordPage() {
       cardLayout.show(mainPanel, "newPassword");
    }
    
    public void switchToNewBioPage() {
        cardLayout.show(mainPanel, "newBio");
    }
    
    public void updateBio(String bio) {
        profileManager.updateBio(userId, bio);
        dispose();
    }
    
    public void updatePassword(String oldPassword, String newPassword) {
        profileManager.updatePassword(userId, oldPassword, newPassword);
        dispose();
    }
    
    public void updateProfilePic() {
        setVisible(false);
        String path = getNewPath("profile photo");
        profileManager.updateProfilePhoto(userId, path);
        dispose();
    }
    
    public void updateCoverPic() {
        setVisible(false);
        String path = getNewPath("cover photo");
        profileManager.updateCoverPhoto(userId, path);
        dispose();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public String getNewPath(String title) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY); // Ensure user chooses only files not directories
        fileChooser.setDialogTitle("Choose new" + title);
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png"));
        int userSelection = fileChooser.showOpenDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            String path = fileToSave.getAbsolutePath();
            return path;
        }
        return null;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
