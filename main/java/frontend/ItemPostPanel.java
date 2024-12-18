package frontend;

import entities.Post;
import java.awt.Color;
import java.awt.Image;
import java.awt.MediaTracker;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import javax.swing.ImageIcon;
import managers.AccountManager;
import databases.FilePaths;



public class ItemPostPanel extends javax.swing.JPanel {
    private final MainFrame parent;
    private final String userId;
    private final Post post;
    private final String username;
    private final String profilePath;
    private final String imagePath;
    private final LocalDateTime time;
    private final String text;
    private boolean isLiked;
    
    public ItemPostPanel(MainFrame parent, Post post) {
        this.parent = parent;
        this.post = post;
        this.userId = parent.getUser().getUserId();
        String authorId = post.getAuthorId();
        AccountManager accountManager = parent.getAccountManager();
        
        
        username = accountManager.getUsername(authorId);
        profilePath = accountManager.getRecord(authorId).getProfile().getProfilePhotoPath();
        
        if(username.isEmpty() || profilePath.isEmpty())
            throw new InputMismatchException(authorId);
        imagePath = post.getImagePath();
        time = post.getPublishDate();
        text = post.getText();
        
        initComponents();
//      setMinimumSize(new Dimension(80,236));
//        setMaximumSize(new Dimension(429,236));
//        setPreferredSize(new Dimension(429, 236));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        //setBorder(BorderFactory.createLineBorder(Color.BLUE));
        setLabels();
    }
    
    public void setLabels() {
        usernameLabel.setText(username);
        dateLabel.setText(time.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
        textArea.setText(text);
        isLiked = post.getLike(userId) != null;
        
        setProfilePicLabel();
        setImageLabel();
        setLikeButton();
        setCommentField();
    }
    
    private void setProfilePicLabel() {
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
    
    private void setImageLabel() {
        if (imagePath == null || imagePath.isEmpty()) {
            imageLabel.setText("No Image");
            return;
        }
    try {
        ImageIcon icon = new ImageIcon(imagePath);
        if (icon.getImageLoadStatus() == MediaTracker.COMPLETE) {
            Image image = icon.getImage().getScaledInstance(330, 300, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(image));
        }else {
            imageLabel.setText("No Image");
        }
    } catch (Exception e) {
        imageLabel.setText("No Image");
        
        }
    }
    
    private void setLikeButton() {
        likesNumberLabel.setText(String.valueOf(post.getLikes().size()));
        
        
        String likeImagePath;
        if(isLiked)
            likeImagePath = FilePaths.FILLED_LIKE_PHOTO_FILEPATH;
        else 
            likeImagePath = FilePaths.LIKE_PHOTO_FILEPATH;
        
        if (likeImagePath == null || likeImagePath.isEmpty()) {
            likeButton.setText("No Image");
            return;
        }
        
        try {
            ImageIcon icon = new ImageIcon(likeImagePath);
            if (icon.getImageLoadStatus() == MediaTracker.COMPLETE) {
                Image image = icon.getImage().getScaledInstance(30, 16, Image.SCALE_SMOOTH);
                likeButton.setIcon(new ImageIcon(image));
            }else {
                likeButton.setText("No Image");
            }
        }catch (Exception e) {
            likeButton.setText("No Image");

            }
    }

    private void setCommentField() {
        commentTextArea.setText("Write a comment...");
        commentTextArea.setForeground(Color.GRAY);
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
        sendCommentButton = new javax.swing.JButton();
        viewCommentsButton = new javax.swing.JButton();
        likeButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        commentTextArea = new javax.swing.JTextArea();
        likesNumberLabel = new javax.swing.JLabel();

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

        sendCommentButton.setBackground(new java.awt.Color(102, 0, 255));
        sendCommentButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        sendCommentButton.setText("Send");
        sendCommentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendCommentButtonActionPerformed(evt);
            }
        });

        viewCommentsButton.setBackground(new java.awt.Color(242, 242, 242));
        viewCommentsButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        viewCommentsButton.setForeground(new java.awt.Color(102, 0, 255));
        viewCommentsButton.setText("Comments");
        viewCommentsButton.setToolTipText("");
        viewCommentsButton.setBorder(null);
        viewCommentsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewCommentsButtonActionPerformed(evt);
            }
        });

        likeButton.setBackground(new java.awt.Color(242, 242, 242));
        likeButton.setBorder(null);
        likeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                likeButtonActionPerformed(evt);
            }
        });

        commentTextArea.setText("Write a comment...");
        commentTextArea.setForeground(Color.GRAY);
        commentTextArea.setBackground(new java.awt.Color(242, 242, 242));
        commentTextArea.setColumns(20);
        commentTextArea.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        commentTextArea.setLineWrap(true);
        commentTextArea.setRows(5);
        jScrollPane2.setViewportView(commentTextArea);
        commentTextArea.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (commentTextArea.getText().equals("Write a comment...")) {
                    commentTextArea.setText("");
                    commentTextArea.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (commentTextArea.getText().isEmpty()) {
                    commentTextArea.setText("Write a comment...");
                    commentTextArea.setForeground(Color.GRAY);
                }
            }
        });

        likesNumberLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        likesNumberLabel.setText("0");

        javax.swing.GroupLayout textAndImagePanelLayout = new javax.swing.GroupLayout(textAndImagePanel);
        textAndImagePanel.setLayout(textAndImagePanelLayout);
        textAndImagePanelLayout.setHorizontalGroup(
            textAndImagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(textAndImagePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(textAndImagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(textAndImagePanelLayout.createSequentialGroup()
                        .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(textAndImagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sendCommentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(textAndImagePanelLayout.createSequentialGroup()
                                .addComponent(likeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(likesNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(viewCommentsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        textAndImagePanelLayout.setVerticalGroup(
            textAndImagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, textAndImagePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(textAndImagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(textAndImagePanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(sendCommentButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(viewCommentsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(textAndImagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(likeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(likesNumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)))
                    .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(usernameAndTypePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(textAndImagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(usernameAndTypePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textAndImagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sendCommentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendCommentButtonActionPerformed
        String commentText = commentTextArea.getText();
        if(commentText.equals("Write a comment...") || commentText.equals(""))
            return;
        parent.getContentManager().addComment(post.getContentId(), userId, commentText);
        setCommentField();
    }//GEN-LAST:event_sendCommentButtonActionPerformed

    private void viewCommentsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewCommentsButtonActionPerformed
        ViewCommentsDialog vcd = new ViewCommentsDialog(parent, post.getComments());
        vcd.setVisible(true);
    }//GEN-LAST:event_viewCommentsButtonActionPerformed

    private void likeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_likeButtonActionPerformed
        if(isLiked)
        parent.getContentManager().removeLike(post.getContentId(), userId);
        else
        parent.getContentManager().addLike(post.getContentId(), userId);

        isLiked = !isLiked;
        setLikeButton();
    }//GEN-LAST:event_likeButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea commentTextArea;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton likeButton;
    private javax.swing.JLabel likesNumberLabel;
    private javax.swing.JLabel profilePicLabel;
    private javax.swing.JButton sendCommentButton;
    private javax.swing.JPanel textAndImagePanel;
    private javax.swing.JTextArea textArea;
    private javax.swing.JPanel usernameAndTypePanel;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JButton viewCommentsButton;
    // End of variables declaration//GEN-END:variables
}
