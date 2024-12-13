package frontend;

import managers.*;
import databases.FilePaths;
import entities.*;

import javax.swing.*;
import java.awt.*;

import java.io.File;
import java.util.ArrayList;
import enums.ContentType;



public class NewsFeedPanel extends javax.swing.JPanel {
    private final MainFrame parent;
    private String userId;
    private ArrayList<String> friendsIDs;
    private final ContentManager contentManager;
    private final AccountManager accountManager;
    private final FriendshipManager friendshipManager;
    private String newContentPhotopath = "";
    
    public NewsFeedPanel(MainFrame parent) {
        initComponents();
        this.parent = parent;
        friendshipManager = parent.getFriendshipManager();
        contentManager = parent.getContentManager();
        accountManager = parent.getAccountManager();
        friendsContentPanel.setLayout(new javax.swing.BoxLayout(friendsContentPanel, javax.swing.BoxLayout.Y_AXIS)); 
    }
    
    public void startNewsFeed() {
        resetLabels();    
        userId = parent.getUser().getUserId();
        friendsIDs = friendshipManager.getAllFriends(userId);
        addPanels();
    }
    
    public void resetLabels() {
        newContentTextArea.setText("What's on your mind ?");
        newContentTextArea.setForeground(Color.gray);
        friendsContentPanel.removeAll();
        friendsPanel.removeAll();
        suggestedFriendsPanel.removeAll();
        revalidate();
        repaint();
    }
    
    public void addPanels() {
        addFriendsPanel();
        addSuggestedFriendsPanel();
        addFriendsPosts();
    }
    
    public void addFriendsPanel() {
    ArrayList<String> friendsIds = friendshipManager.getAllFriends(userId);
    ArrayList<User> friends = new ArrayList<>();
        for(String id : friendsIds) {
            friends.add(accountManager.getRecord(id));
            System.out.println(accountManager.getRecord(id));
        }
    friendsPanel.removeAll();

    // Create the SuggestedFriendsPanel instance
    AllFriendsPanel Afp = new AllFriendsPanel(friends, parent, true);

    // Add the SuggestedFriendsPanel to the parent panel
    friendsPanel.setLayout(new BorderLayout()); // Ensure proper layout
    friendsPanel.add(Afp, BorderLayout.CENTER);

    // Refresh the UI
    friendsPanel.revalidate();
    friendsPanel.repaint();
    }
    
    public void addSuggestedFriendsPanel() {
        ArrayList<String> suggestedIds = friendshipManager.suggestFriends(userId);
        ArrayList<User> suggestedFriends = new ArrayList<>();
        for(String id : suggestedIds) {
            suggestedFriends.add(accountManager.getRecord(id));
        }
        
        suggestedFriendsPanel.removeAll();

    // Create the SuggestedFriendsPanel instance
    SuggestedFriendsPanel sfp = new SuggestedFriendsPanel(suggestedFriends, parent);

    // Add the SuggestedFriendsPanel to the parent panel
    suggestedFriendsPanel.setLayout(new BorderLayout()); // Ensure proper layout
    suggestedFriendsPanel.add(sfp, BorderLayout.CENTER);

    // Refresh the UI
    suggestedFriendsPanel.revalidate();
    suggestedFriendsPanel.repaint();
    }
    
    public void addFriendsPosts() {
        ArrayList<Post> posts = contentManager.getFriendsPosts(friendsIDs);
        if(posts.isEmpty()) {
            JLabel label = new JLabel("No posts yet");

            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setVerticalAlignment(SwingConstants.CENTER);
            label.setFont(new Font("Arial", Font.BOLD, 24));
            friendsContentPanel.add(label, BorderLayout.CENTER);
        }
        else {
            for(Post post : posts)
                addPost(post);
        }
    }
    
    public void addPost(Post post) {
        ItemContentPanel icp = new ItemContentPanel(parent, post);
        friendsContentPanel.add(icp);
    }
    
    public String getNewPath(String title) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY); // Ensure user chooses only files not directories
        fileChooser.setDialogTitle(title);
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png"));
        int userSelection = fileChooser.showOpenDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            String path = fileToSave.getAbsolutePath();
            return path;
        }
        return null;
    }
    
    public void createContent(String text, ContentType type) {
        contentManager.createContent(type, userId, text, newContentPhotopath);
        newContentPhotopath = "";
        newContentTextArea.setText("What's on your mind ?");
        newContentTextArea.setForeground(Color.GRAY);    
    }
    
    public void viewStories() {
        ArrayList<Story> stories = contentManager.getFriendsStories(friendsIDs);
        if(stories.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No stories to show!", "Message", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        ArrayList<ItemContentPanel> icps = new ArrayList<>();
        for(Story story : stories) {
            icps.add(new ItemContentPanel(parent, story));
        }
        StoryCarouselPanel carouselPanel = new StoryCarouselPanel(icps);
        
        StoriesDialoge dialog = new StoriesDialoge(parent, "Stories", true);
        dialog.viewStoryCarousel(carouselPanel);                 
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        profileButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        storiesButton = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        notificationsButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        contentContainerPanel = new javax.swing.JPanel();
        newContentPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        newContentTextArea = new javax.swing.JTextArea();
        postButton = new javax.swing.JButton();
        storyButton = new javax.swing.JButton();
        uploadButton = new javax.swing.JButton();
        friendsContentPanel = new javax.swing.JPanel();
        friendsPanel = new javax.swing.JPanel();
        suggestedFriendsPanel = new javax.swing.JPanel();
        groupsPanel = new javax.swing.JPanel();
        suggestedGroupsPanel = new javax.swing.JPanel();

        jPanel1.setBackground(new java.awt.Color(200, 200, 200));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 255), 2, true));

        profileButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        profileButton.setForeground(new java.awt.Color(102, 0, 255));
        profileButton.setText("Profile");
        profileButton.setBorder(null);
        profileButton.setBorderPainted(false);
        profileButton.setContentAreaFilled(false);
        profileButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        profileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileButtonActionPerformed(evt);
            }
        });

        refreshButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        refreshButton.setForeground(new java.awt.Color(102, 0, 255));
        refreshButton.setText("Refresh");
        refreshButton.setToolTipText("");
        refreshButton.setBorder(null);
        refreshButton.setBorderPainted(false);
        refreshButton.setContentAreaFilled(false);
        refreshButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        logoutButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        logoutButton.setForeground(new java.awt.Color(102, 0, 0));
        logoutButton.setText("Log out");
        logoutButton.setBorder(null);
        logoutButton.setBorderPainted(false);
        logoutButton.setContentAreaFilled(false);
        logoutButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        storiesButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        storiesButton.setForeground(new java.awt.Color(102, 0, 255));
        storiesButton.setText("Stories");
        storiesButton.setToolTipText("");
        storiesButton.setBorder(null);
        storiesButton.setBorderPainted(false);
        storiesButton.setContentAreaFilled(false);
        storiesButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        storiesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                storiesButtonActionPerformed(evt);
            }
        });

        searchButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        searchButton.setForeground(new java.awt.Color(102, 0, 255));
        searchButton.setText("Search");
        searchButton.setToolTipText("");
        searchButton.setBorder(null);
        searchButton.setBorderPainted(false);
        searchButton.setContentAreaFilled(false);
        searchButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        notificationsButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        notificationsButton.setForeground(new java.awt.Color(102, 0, 255));
        notificationsButton.setText("Notifs");
        notificationsButton.setToolTipText("");
        notificationsButton.setBorder(null);
        notificationsButton.setBorderPainted(false);
        notificationsButton.setContentAreaFilled(false);
        notificationsButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        notificationsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notificationsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(refreshButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(profileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(storiesButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(notificationsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(profileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(storiesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(notificationsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        contentContainerPanel.setMaximumSize(new java.awt.Dimension(586, 382));

        newContentPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 255), 1, true));

        newContentTextArea.setText("What's on your mind ?");
        newContentTextArea.setForeground(Color.GRAY);
        newContentTextArea.setColumns(20);
        newContentTextArea.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        newContentTextArea.setLineWrap(true);
        newContentTextArea.setRows(5);
        newContentTextArea.setWrapStyleWord(true);
        newContentTextArea.setSelectionEnd(3);
        newContentTextArea.setSelectionStart(3);
        jScrollPane2.setViewportView(newContentTextArea);
        newContentTextArea.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (newContentTextArea.getText().equals("What's on your mind ?")) {
                    newContentTextArea.setText("");
                    newContentTextArea.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (newContentTextArea.getText().isEmpty()) {
                    newContentTextArea.setText("What's on your mind ?");
                    newContentTextArea.setForeground(Color.GRAY);
                }
            }
        });

        postButton.setBackground(new java.awt.Color(102, 0, 255));
        postButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        postButton.setText("Post");
        postButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                postButtonActionPerformed(evt);
            }
        });

        storyButton.setBackground(new java.awt.Color(102, 0, 255));
        storyButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        storyButton.setText("Story");
        storyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                storyButtonActionPerformed(evt);
            }
        });

        uploadButton.setBorderPainted(false);
        uploadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout newContentPanelLayout = new javax.swing.GroupLayout(newContentPanel);
        newContentPanel.setLayout(newContentPanelLayout);
        newContentPanelLayout.setHorizontalGroup(
            newContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newContentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(newContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(postButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uploadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(storyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(245, 245, 245))
        );
        newContentPanelLayout.setVerticalGroup(
            newContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newContentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(newContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(newContentPanelLayout.createSequentialGroup()
                        .addComponent(uploadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(postButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(storyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        friendsContentPanel.setLayout(new javax.swing.BoxLayout(friendsContentPanel, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout contentContainerPanelLayout = new javax.swing.GroupLayout(contentContainerPanel);
        contentContainerPanel.setLayout(contentContainerPanelLayout);
        contentContainerPanelLayout.setHorizontalGroup(
            contentContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentContainerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(friendsContentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newContentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        contentContainerPanelLayout.setVerticalGroup(
            contentContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentContainerPanelLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(newContentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(friendsContentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane1.setViewportView(contentContainerPanel);

        friendsPanel.setMaximumSize(new java.awt.Dimension(198, 3348));

        javax.swing.GroupLayout friendsPanelLayout = new javax.swing.GroupLayout(friendsPanel);
        friendsPanel.setLayout(friendsPanelLayout);
        friendsPanelLayout.setHorizontalGroup(
            friendsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        friendsPanelLayout.setVerticalGroup(
            friendsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        suggestedFriendsPanel.setMaximumSize(new java.awt.Dimension(198, 3624));

        javax.swing.GroupLayout suggestedFriendsPanelLayout = new javax.swing.GroupLayout(suggestedFriendsPanel);
        suggestedFriendsPanel.setLayout(suggestedFriendsPanelLayout);
        suggestedFriendsPanelLayout.setHorizontalGroup(
            suggestedFriendsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 155, Short.MAX_VALUE)
        );
        suggestedFriendsPanelLayout.setVerticalGroup(
            suggestedFriendsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        groupsPanel.setMaximumSize(new java.awt.Dimension(198, 3348));

        javax.swing.GroupLayout groupsPanelLayout = new javax.swing.GroupLayout(groupsPanel);
        groupsPanel.setLayout(groupsPanelLayout);
        groupsPanelLayout.setHorizontalGroup(
            groupsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        groupsPanelLayout.setVerticalGroup(
            groupsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 181, Short.MAX_VALUE)
        );

        suggestedGroupsPanel.setMaximumSize(new java.awt.Dimension(198, 3624));

        javax.swing.GroupLayout suggestedGroupsPanelLayout = new javax.swing.GroupLayout(suggestedGroupsPanel);
        suggestedGroupsPanel.setLayout(suggestedGroupsPanelLayout);
        suggestedGroupsPanelLayout.setHorizontalGroup(
            suggestedGroupsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 153, Short.MAX_VALUE)
        );
        suggestedGroupsPanelLayout.setVerticalGroup(
            suggestedGroupsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(groupsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(suggestedGroupsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(suggestedFriendsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(friendsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(groupsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(friendsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(suggestedFriendsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(suggestedGroupsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void profileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileButtonActionPerformed
        parent.switchToProfilePage();
    }//GEN-LAST:event_profileButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        parent.switchToNewsFeedPage();
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        parent.logout();
        parent.switchToSignupPage();
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void postButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_postButtonActionPerformed
        String text = newContentTextArea.getText();
        createContent(text, ContentType.POST);
    }//GEN-LAST:event_postButtonActionPerformed

    private void storyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_storyButtonActionPerformed
        String text = newContentTextArea.getText();
        createContent(text, ContentType.STORY);
    }//GEN-LAST:event_storyButtonActionPerformed

    private void uploadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadButtonActionPerformed
        newContentPhotopath = getNewPath("Choose a photo");
    }//GEN-LAST:event_uploadButtonActionPerformed

    private void storiesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_storiesButtonActionPerformed
        viewStories();
    }//GEN-LAST:event_storiesButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        parent.switchToSearchPage();
    }//GEN-LAST:event_searchButtonActionPerformed

    private void notificationsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notificationsButtonActionPerformed
        parent.switchToNoficationsPage();
    }//GEN-LAST:event_notificationsButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentContainerPanel;
    private javax.swing.JPanel friendsContentPanel;
    private javax.swing.JPanel friendsPanel;
    private javax.swing.JPanel groupsPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton logoutButton;
    private javax.swing.JPanel newContentPanel;
    private javax.swing.JTextArea newContentTextArea;
    private javax.swing.JButton notificationsButton;
    private javax.swing.JButton postButton;
    private javax.swing.JButton profileButton;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JButton storiesButton;
    private javax.swing.JButton storyButton;
    private javax.swing.JPanel suggestedFriendsPanel;
    private javax.swing.JPanel suggestedGroupsPanel;
    private javax.swing.JButton uploadButton;
    // End of variables declaration//GEN-END:variables
}
