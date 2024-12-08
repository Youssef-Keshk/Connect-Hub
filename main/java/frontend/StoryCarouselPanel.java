package frontend;

import databases.FilePaths;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class StoryCarouselPanel extends javax.swing.JPanel {
    private CardLayout cardLayout;
    private Timer timer;
    private int progressValue = 0;
    private final int TIMER_INTERVAL = 5000; // 5 seconds

    public StoryCarouselPanel(ArrayList<ItemContentPanel> sps) {
        initComponents();
        setBorder(BorderFactory.createLineBorder(Color.BLUE));
        setupCarousel(sps);
        startAutoSwitch();
    }

    private void setupCarousel(ArrayList<ItemContentPanel> sps) {
        cardLayout = new CardLayout(); // Card Layout to switch between Story panels
        mainStoryPanel.setLayout(cardLayout);
        for (ItemContentPanel sp : sps) {
            sp.setBorder(BorderFactory.createEmptyBorder());
            mainStoryPanel.add(sp);
        }
    }

    private void startAutoSwitch() {
        timer = new Timer(50, new ActionListener() { // Update progress bar every 50ms
            @Override
            public void actionPerformed(ActionEvent e) {
                progressValue += 50;
                progressBar.setValue((int) ((double) progressValue / TIMER_INTERVAL * 100));

                if (progressValue >= TIMER_INTERVAL) {
                    progressValue = 0;
                    cardLayout.next(mainStoryPanel); // Switch to the next story
                }
            }
        });
        timer.start();
    }

    // Action listener for "Next" button
    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {
        cardLayout.next(mainStoryPanel); // Manual next
        resetProgressBar(); // Reset the progress bar
    }

    // Action listener for "Previous" button
    private void previousButtonActionPerformed(java.awt.event.ActionEvent evt) {
        cardLayout.previous(mainStoryPanel); // Manual previous
        resetProgressBar(); // Reset the progress bar
    }

    private void resetProgressBar() {
        progressValue = 0;
        progressBar.setValue(0);
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(429,296); // Width and height for the panel
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

    mainStoryPanel = new javax.swing.JPanel();
    nextButton = new javax.swing.JButton();
    previousButton = new javax.swing.JButton();
    progressBar = new JProgressBar();

    setLayout(new java.awt.BorderLayout());

    // Create a JLabel to indicate the stories section
    JLabel storyLabel = new JLabel("Stories", JLabel.CENTER);
    storyLabel.setFont(new Font("Arial", Font.BOLD, 20)); // Customize the font and size
    storyLabel.setForeground(Color.BLUE); // Set color for the label
    add(storyLabel, BorderLayout.NORTH); // Add the label to the top

    mainStoryPanel.setBackground(new java.awt.Color(255, 255, 255));
    add(mainStoryPanel, java.awt.BorderLayout.CENTER);

    try {
        ImageIcon icon = new ImageIcon(FilePaths.RIGHT_ARROW_ICON);
        if (icon.getImageLoadStatus() == MediaTracker.COMPLETE) {
            Image image = icon.getImage().getScaledInstance(40, 16, Image.SCALE_SMOOTH);
            nextButton.setIcon(new ImageIcon(image));
        } else {
            nextButton.setText("Next");
        }
    } catch (Exception e) {
        nextButton.setText("Next");
    }
    nextButton.setPreferredSize(new Dimension(30, 30));
    nextButton.setContentAreaFilled(false);
    nextButton.setBorderPainted(false);
    nextButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            nextButtonActionPerformed(evt);
        }
    });

    try {
        ImageIcon icon = new ImageIcon(FilePaths.LEFT_ARROW_ICON);
        if (icon.getImageLoadStatus() == MediaTracker.COMPLETE) {
            Image image = icon.getImage().getScaledInstance(40, 16, Image.SCALE_SMOOTH);
            previousButton.setIcon(new ImageIcon(image));
        } else {
            previousButton.setText("Previous");
        }
    } catch (Exception e) {
        previousButton.setText("Previous");
    }
    previousButton.setPreferredSize(new Dimension(30, 30));
    previousButton.setContentAreaFilled(false);
    previousButton.setBorderPainted(false);
    previousButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            previousButtonActionPerformed(evt);
        }
    });

    JPanel controlPanel = new JPanel(new BorderLayout());
    JPanel buttonPanel = new JPanel(); // Panel for buttons
    buttonPanel.add(previousButton);
    buttonPanel.add(nextButton);

    progressBar.setPreferredSize(new Dimension(150, 20));
    progressBar.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
    progressBar.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Padding to avoid touching edges
    progressBar.setStringPainted(false); // Disable percentage display

    controlPanel.add(buttonPanel, BorderLayout.CENTER);
    controlPanel.add(progressBar, BorderLayout.SOUTH);

    add(controlPanel, java.awt.BorderLayout.SOUTH);
}// </editor-fold>                        

    // Variables declaration                   
    private javax.swing.JPanel mainStoryPanel;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton previousButton;
    private javax.swing.JProgressBar progressBar;
    // End of variables declaration               
}
