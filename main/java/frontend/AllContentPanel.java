package frontend;

import entities.Content;
import entities.Post;
import entities.Story;
import java.awt.Dimension;
import java.util.ArrayList;


public class AllContentPanel extends javax.swing.JPanel {
    private final MainFrame parent;
    private final String userId;
    
    public AllContentPanel(MainFrame parent, String userId) {
        this.parent = parent;
        this.userId = userId;
        
        initComponents();
        setPreferredSize(new Dimension(460, 600));
        contentPanel.setLayout(new javax.swing.BoxLayout(contentPanel, javax.swing.BoxLayout.Y_AXIS));
        
        addPanels();
    }
    
    public void addPanels() {
        contentPanel.add(getStoryCarouselPanel());
        ArrayList<Post> posts = parent.getContentManager().getPosts(userId);
        for(Post post : posts)
            contentPanel.add(getItemContentPanel(post));
    }
    
    public StoryCarouselPanel getStoryCarouselPanel() {
        ArrayList<Story> stories = parent.getContentManager().getStories(userId);
        ArrayList<ItemContentPanel> itemContentPanels = new ArrayList<>();
        for(Story story : stories) {
            itemContentPanels.add(getItemContentPanel(story));
        }
        return new StoryCarouselPanel(itemContentPanels);
    }
    
    public ItemContentPanel getItemContentPanel(Content c) {
        return new ItemContentPanel(parent, c);
    }
    
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(460,600); // Width and height for the panel
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        contentPanel = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        contentPanel.setLayout(new javax.swing.BoxLayout(contentPanel, javax.swing.BoxLayout.LINE_AXIS));
        jScrollPane1.setViewportView(contentPanel);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentPanel;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
