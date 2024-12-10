package frontend;

import entities.Content;
import managers.AccountManager;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.MediaTracker;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import javax.swing.ImageIcon;


public class ItemContentPanel extends javax.swing.JPanel {
    private final String username;
    private final String profilePath;
    private final String imagePath;
    private final LocalDateTime time;
    private final String text;

    public ItemContentPanel(MainFrame parent, Content content) {
        String userId = content.getAuthorId();
        AccountManager accountManager = parent.getAccountManager();
        
        
        username = accountManager.getUsername(userId);
        profilePath = accountManager.getRecord(userId).getProfile().getProfilePhotoPath();
        
        if(username.isEmpty() || profilePath.isEmpty())
            throw new InputMismatchException(userId);
        imagePath = content.getImagePath();
        time = content.getPublishDate();
        text = content.getText();
        
        initComponents();
//      setMinimumSize(new Dimension(80,236));
        setMaximumSize(new Dimension(429,236));
        setPreferredSize(new Dimension(429, 236));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        //setBorder(BorderFactory.createLineBorder(Color.BLUE));
        setLabels();
    }
    
    public void setLabels() {
        usernameLabel.setText(username);
        dateLabel.setText(time.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
        textArea.setText(text);
 
        setProfilePic();
        setImage();
    }
        
    
    private void setProfilePic() {
        if (profilePath == null || profilePath.isEmpty()) {
            profilePicLabel.setText("No Image");
            return;
        }
        try {
            ImageIcon icon = new ImageIcon(profilePath);
            if (icon.getImageLoadStatus() == MediaTracker.COMPLETE) {
                Image image = icon.getImage().getScaledInstance(60, 40, Image.SCALE_SMOOTH);
                profilePicLabel.setIcon(new ImageIcon(image));
            }else {
                profilePicLabel.setText("No Image");
            }
        } catch (Exception e) {
            profilePicLabel.setText("No Image");
        }
    }
    
    private void setImage() {
        if (imagePath == null || imagePath.isEmpty()) {
            imageLabel.setText("No Image");
            return;
        }
    try {
        ImageIcon icon = new ImageIcon(imagePath);
        if (icon.getImageLoadStatus() == MediaTracker.COMPLETE) {
            Image image = icon.getImage().getScaledInstance(220, 150, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(image));
        }else {
            imageLabel.setText("No Image");
        }
    } catch (Exception e) {
        imageLabel.setText("No Image");
        
        }
    }
    
//    @Override
//    public Dimension getPreferredSize() {
//        return new Dimension(429,236); // Width and height for the panel
//        
//    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usernameAndTypePanel = new javax.swing.JPanel();
        profilePicLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        textAndImagePanel = new javax.swing.JPanel();
        imageLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();

        profilePicLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profilePicLabel.setMaximumSize(new java.awt.Dimension(60, 16));
        profilePicLabel.setMinimumSize(new java.awt.Dimension(60, 16));
        profilePicLabel.setPreferredSize(new java.awt.Dimension(60, 16));

        usernameLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        usernameLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        usernameLabel.setText("username");

        dateLabel.setFont(new java.awt.Font("Arial", 2, 10)); // NOI18N
        dateLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dateLabel.setText("date");
        dateLabel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout usernameAndTypePanelLayout = new javax.swing.GroupLayout(usernameAndTypePanel);
        usernameAndTypePanel.setLayout(usernameAndTypePanelLayout);
        usernameAndTypePanelLayout.setHorizontalGroup(
            usernameAndTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usernameAndTypePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(profilePicLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(usernameAndTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(usernameAndTypePanelLayout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(dateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(usernameAndTypePanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        usernameAndTypePanelLayout.setVerticalGroup(
            usernameAndTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usernameAndTypePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(usernameAndTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, usernameAndTypePanelLayout.createSequentialGroup()
                        .addGap(0, 18, Short.MAX_VALUE)
                        .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(usernameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(profilePicLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        imageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout textAndImagePanelLayout = new javax.swing.GroupLayout(textAndImagePanel);
        textAndImagePanel.setLayout(textAndImagePanelLayout);
        textAndImagePanelLayout.setHorizontalGroup(
            textAndImagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, textAndImagePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        textAndImagePanelLayout.setVerticalGroup(
            textAndImagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        textArea.setEditable(false);
        textArea.setBackground(new java.awt.Color(204, 204, 255));
        textArea.setColumns(20);
        textArea.setLineWrap(true);
        textArea.setRows(5);
        textArea.setText("no text");
        textArea.setWrapStyleWord(true);
        textArea.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textArea.setFocusable(false);
        jScrollPane1.setViewportView(textArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textAndImagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(usernameAndTypePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(usernameAndTypePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textAndImagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel profilePicLabel;
    private javax.swing.JPanel textAndImagePanel;
    private javax.swing.JTextArea textArea;
    private javax.swing.JPanel usernameAndTypePanel;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
