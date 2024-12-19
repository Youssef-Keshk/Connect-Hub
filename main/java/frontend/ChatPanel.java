package frontend;

import databases.FilePaths;
import entities.ChatMessage;
import entities.Friendship;
import entities.User;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.MediaTracker;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;


public class ChatPanel extends javax.swing.JPanel {
    private final MainFrame parent;
    private final User primaryUser;
    private final User secondaryUser;
    private Friendship friendship;
    private Timer chatUpdateTimer; 
    
    public ChatPanel(MainFrame parent, String secondaryUserId) {
        this.parent = parent;
        this.primaryUser = parent.getUser();
        this.secondaryUser = parent.getAccountManager().getRecord(secondaryUserId);
        this.friendship = parent.getFriendshipManager().getFriendshipOfTwoUsers(primaryUser.getUserId(), secondaryUserId);
        
        initComponents();
        addProfileData();
        addSendIcon();
        addChatPanels();
        startChatUpdateTimer();
    }
    
    public void addProfileData() {
        usernameLabel.setText(secondaryUser.getUsername());
        addProfilePic(secondaryUser.getProfile().getProfilePhotoPath());
    }
    
    public void addProfilePic(String photoPath) {
        try {
            ImageIcon icon = new ImageIcon(photoPath);
            if (icon.getImageLoadStatus() == MediaTracker.COMPLETE) {
                Image image = icon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
                profilePicLabel.setIcon(new ImageIcon(image));
            } else {
                profilePicLabel.setText("No Image");
            }
        } catch (Exception e) {
            profilePicLabel.setText("No Image");
        }
    }

    public void addSendIcon() {
        try {
            ImageIcon icon = new ImageIcon(FilePaths.SEND_ICON_FILEPATH);
            if (icon.getImageLoadStatus() == MediaTracker.COMPLETE) {
                Image image = icon.getImage().getScaledInstance(40, 16, Image.SCALE_SMOOTH);
                sendButton.setIcon(new ImageIcon(image));
            } else {
                sendButton.setText("No Image");
            }
        } catch (Exception e) {
            sendButton.setText("No Image");
        }
    }
    
    private void startChatUpdateTimer() {
        int updateInterval = 1000; // 1000 ms = 1 seconds

        chatUpdateTimer = new Timer(updateInterval, new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                parent.getFriendshipManager().refresh();
                friendship = parent.getFriendshipManager().getFriendshipOfTwoUsers(primaryUser.getUserId(), secondaryUser.getUserId());
                addChatPanels();
            }
        });
        
        chatUpdateTimer.start(); // Start the timer
    }
    
    public void addChatPanels() {
        chatsContainerPanel.removeAll();
        chatsContainerPanel.setLayout(new javax.swing.BoxLayout(chatsContainerPanel, javax.swing.BoxLayout.Y_AXIS));
        
        ArrayList<ChatMessage> chatMessages = friendship.getChat().getMessages();
        
        if (chatMessages.isEmpty()) {
            JLabel label = new JLabel("No messages yet");

            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setVerticalAlignment(SwingConstants.CENTER);
            label.setFont(new Font("Arial", Font.BOLD, 24));
            chatsContainerPanel.add(label, BorderLayout.CENTER);
        }
        
        for(ChatMessage cm : chatMessages) {
            if(cm.getMessageSenderId().equals(primaryUser.getUserId()))
                addPrimaryChatBarPanel(cm.getMessage());
            else if(cm.getMessageSenderId().equals(secondaryUser.getUserId()))
                addSecondaryChatBarPanel(cm.getMessage());
        }
        
        repaint();
        revalidate();
    }
    
    public void addPrimaryChatBarPanel(String text) {
        PrimaryChatBarPanel pcbp = new PrimaryChatBarPanel(text);
        pcbp.setAlignmentX(Component.LEFT_ALIGNMENT);
        chatsContainerPanel.add(javax.swing.Box.createHorizontalGlue());
        chatsContainerPanel.add(pcbp);
        chatsContainerPanel.add(javax.swing.Box.createVerticalStrut(5)); // Add space between messages
    }

    
    public void addSecondaryChatBarPanel(String text) {
        SecondaryChatBarPanel scbp = new SecondaryChatBarPanel(text);
        scbp.setAlignmentX(Component.RIGHT_ALIGNMENT);
        chatsContainerPanel.add(javax.swing.Box.createHorizontalGlue());        
        chatsContainerPanel.add(scbp);
        chatsContainerPanel.add(javax.swing.Box.createVerticalStrut(5)); // Add space between messages
    }
    
    public void handleMessage() {
        if(chatTextField.getText().equals("Chat...") && chatTextField.getForeground().equals(Color.GRAY))
            return;

        parent.getFriendshipManager().addMessage(friendship, primaryUser.getUserId(), chatTextField.getText());

        chatTextField.setText("Chat...");
        chatTextField.setForeground(Color.GRAY);
        
        addChatPanels();
    }
    
    @Override
    protected void finalize() throws Throwable {
        // Make sure to stop the timer when the chat panel is disposed or no longer needed
        if (chatUpdateTimer != null) {
            chatUpdateTimer.stop();
        }
        super.finalize();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        profileDataPanel = new javax.swing.JPanel();
        profilePicLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        chatTextField = new javax.swing.JTextField();
        sendButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        chatsContainerPanel = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        profileDataPanel.setPreferredSize(new java.awt.Dimension(400, 50));
        profileDataPanel.setLayout(new java.awt.BorderLayout());

        profilePicLabel.setText("pic");
        profilePicLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 102)));
        profilePicLabel.setMaximumSize(new java.awt.Dimension(60, 16));
        profilePicLabel.setMinimumSize(new java.awt.Dimension(60, 16));
        profilePicLabel.setPreferredSize(new java.awt.Dimension(60, 40));
        profileDataPanel.add(profilePicLabel, java.awt.BorderLayout.LINE_START);

        usernameLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        usernameLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        usernameLabel.setText("username");
        profileDataPanel.add(usernameLabel, java.awt.BorderLayout.CENTER);

        add(profileDataPanel, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setPreferredSize(new java.awt.Dimension(60, 40));
        jPanel2.setLayout(new java.awt.BorderLayout());

        chatTextField.setText("Chat...");
        chatTextField.setForeground(Color.GRAY);
        chatTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        chatTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        chatTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        chatTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chatTextFieldActionPerformed(evt);
            }
        });
        jPanel2.add(chatTextField, java.awt.BorderLayout.CENTER);
        chatTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (chatTextField.getText().equals("Chat...")) {
                    chatTextField.setText("");
                    chatTextField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (chatTextField.getText().isEmpty()) {
                    chatTextField.setText("Chat...");
                    chatTextField.setForeground(Color.GRAY);
                }
            }
        });

        sendButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        sendButton.setContentAreaFilled(false);
        sendButton.setPreferredSize(new java.awt.Dimension(40, 18));
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });
        jPanel2.add(sendButton, java.awt.BorderLayout.LINE_END);

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_END);

        chatsContainerPanel.setMaximumSize(new java.awt.Dimension(400, 300));
        chatsContainerPanel.setMinimumSize(new java.awt.Dimension(400, 300));
        chatsContainerPanel.setPreferredSize(new java.awt.Dimension(400, 300));
        chatsContainerPanel.setLayout(new javax.swing.BoxLayout(chatsContainerPanel, javax.swing.BoxLayout.LINE_AXIS));
        jScrollPane1.setViewportView(chatsContainerPanel);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        handleMessage();
        parent.getNotificationManager().createMessageNotification(primaryUser, secondaryUser.getUserId());
    }//GEN-LAST:event_sendButtonActionPerformed

    private void chatTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chatTextFieldActionPerformed
        handleMessage();
        parent.getNotificationManager().createMessageNotification(primaryUser, secondaryUser.getUserId());
    }//GEN-LAST:event_chatTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField chatTextField;
    private javax.swing.JPanel chatsContainerPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel profileDataPanel;
    private javax.swing.JLabel profilePicLabel;
    private javax.swing.JButton sendButton;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
