package group;

public class Manageposts {
 private PostsDatabase db;
    public Manageposts(PostsDatabase db) {
        this.db = db;
    }

    public void addpost(Grouppost post) {
     db.getAllRecords().add(post);
      db.refreshRecords();
    }

    public void deletepost(Grouppost post) {
       db.getAllRecords().remove(post);
        db.refreshRecords();
    }

    public  void  editpost(Grouppost post,String branch,String Text) {
        if(db.getAllRecords().contains(post)) {
            if (branch.equals("Text")){
                post.setText(Text);
              db.refreshRecords();
            }
            else if (branch.equals("Photo")){
                post.setImagePath(Text);
               db.refreshRecords();
            }
        }

    }
}
