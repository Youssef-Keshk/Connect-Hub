package profilemanagement.frontend;

import profilemanagement.backend.ProfileManager;
import useraccountmanagement.backend.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.time.LocalDate;
import useraccountmanagement.backend.UserAccountManagement;

public class UserProfilePanel extends JPanel {
    private JLabel profilePicLabel;
    private JLabel coverPicLabel;
    private JTextArea bioTextArea;
    private JButton changeProfilePicButton;
    private JButton changeCoverPicButton;
    private JButton changeBioButton;
    private JButton changePasswordButton;

    private ProfileManager profileManager;
    private User user;

    public UserProfilePanel(User user, ProfileManager profileManager) {
        this.user = user;
        this.profileManager = profileManager;

        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // Cover Picture Panel
        coverPicLabel = new JLabel("Cover Photo", SwingConstants.CENTER);
        coverPicLabel.setPreferredSize(new Dimension(500, 200));
        coverPicLabel.setOpaque(true);
        coverPicLabel.setBackground(Color.LIGHT_GRAY);
        coverPicLabel.setFont(new Font("Arial", Font.BOLD, 16));
        coverPicLabel.setForeground(Color.DARK_GRAY);

        // Profile Picture and Bio Panel
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        profilePicLabel = new JLabel("Profile Pic", SwingConstants.CENTER);
        profilePicLabel.setPreferredSize(new Dimension(100, 100));
        profilePicLabel.setOpaque(true);
        profilePicLabel.setBackground(Color.GRAY);
        profilePicLabel.setFont(new Font("Arial", Font.BOLD, 12));
        profilePicLabel.setForeground(Color.WHITE);
        profilePicLabel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));

        bioTextArea = new JTextArea(5, 20);
        bioTextArea.setText("User bio goes here...");
        bioTextArea.setFont(new Font("Arial", Font.PLAIN, 14));
        bioTextArea.setLineWrap(true);
        bioTextArea.setWrapStyleWord(true);
        bioTextArea.setEditable(false);
        bioTextArea.setBorder(BorderFactory.createTitledBorder("Bio"));

        centerPanel.add(profilePicLabel, BorderLayout.WEST);
        centerPanel.add(new JScrollPane(bioTextArea), BorderLayout.CENTER);

        // Buttons Panel
        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        changeProfilePicButton = new JButton("Change Profile Photo");
        changeCoverPicButton = new JButton("Change Cover Photo");
        changeBioButton = new JButton("Change Bio");
        changePasswordButton = new JButton("Change Password");

        buttonPanel.add(changeProfilePicButton);
        buttonPanel.add(changeCoverPicButton);
        buttonPanel.add(changeBioButton);
        buttonPanel.add(changePasswordButton);

        // Add Components to Main Panel
        add(coverPicLabel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Add Button Actions
        addActionListeners();
    }

    private void addActionListeners() {
        changeProfilePicButton.addActionListener((ActionEvent e) -> {
            String photoPath = choosePhoto();
            if (photoPath != null) {
                addPhoto(photoPath, profilePicLabel);

                if (profileManager != null) {
                    try {
                        profileManager.updateProfilePhoto(user.getUserId(), photoPath);
                    } catch (Exception ex) {
                        showError("Error updating profile photo: " + ex.getMessage());
                    }
                } else {
                    showError("Profile Manager is not initialized.");
                }
            }
        });

        changeCoverPicButton.addActionListener((ActionEvent e) -> {
            String photoPath = choosePhoto();
            if (photoPath != null) {
                addPhoto(photoPath, coverPicLabel);

                if (profileManager != null) {
                    try {
                        profileManager.updateCoverPhoto(user.getUserId(), photoPath);
                    } catch (Exception ex) {
                        showError("Error updating cover photo: " + ex.getMessage());
                    }
                } else {
                    showError("Profile Manager is not initialized.");
                }
            }
        });

        changeBioButton.addActionListener((ActionEvent e) -> {
            String newBio = JOptionPane.showInputDialog(this, "Enter new bio:");
            if (newBio != null && !newBio.trim().isEmpty()) {
                bioTextArea.setText(newBio);

                if (profileManager != null) {
                    try {
                        profileManager.updateBio(user.getUserId(), newBio);
                    } catch (Exception ex) {
                        showError("Error updating bio: " + ex.getMessage());
                    }
                } else {
                    showError("Profile Manager is not initialized.");
                }
            }
        });

        changePasswordButton.addActionListener((ActionEvent e) -> {
            new ChangePasswordWindow(user);
        });
    }

    private String choosePhoto() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            return selectedFile.getAbsolutePath();
        }
        return null;
    }

    private void addPhoto(String photoPath, JLabel label) {
        ImageIcon imageIcon = new ImageIcon(photoPath);
        Image image = imageIcon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(image));
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("User Profile");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);

         String email = "example@test.com";
        String username = "testUser";
        String password = "password123";
        String status = "Active";
        LocalDate dateOfBirth = LocalDate.of(1995, 5, 15); // Example: May 15, 1995

        // Create an instance of the User class
        User newUser = new User( email, username, password, status, dateOfBirth);
        UserAccountManagement usermanager = new UserAccountManagement();
        ProfileManager profileManager = new ProfileManager(usermanager); 
        frame.add(new UserProfilePanel(newUser, profileManager));
        frame.setVisible(true);
    }
}
