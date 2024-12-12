package group;

public class Admin extends Groupmanger{
    private Manageposts manageposts;

    public Admin() {
        super();
        Manageposts Manageposts = new Manageposts(this.getPostsDatabase());
    }

     public boolean removemember(Group group,String userID) {
         if (getGroupDatabase().contains(group.getID())){
             if(group.getMembers().contains(userID)){
                 group.getMembers().remove(userID);
                 return true;
             }
         }
         return false;
     }

    public boolean adduser(Group group, String ID) {
        if(this.getGroupDatabase().contains(group.getID())) {
            if (!group.getMembers().contains(ID)) {
                group.getMembers().add(ID);
                return true;
            }
        }
        return false;
    }

    public void addpost(Grouppost post) {
        getPostsDatabase().getAllRecords().add(post);
        refresh();
    }

    public void deletepost(Grouppost post) {
        getPostsDatabase().getAllRecords().remove(post);
        refresh();
    }

    public  void  editpost(Grouppost post,String branch,String Text) {
        if(getPostsDatabase().getAllRecords().contains(post)) {
            if (branch.equals("Text")){
                post.setText(Text);
                refresh();
            }
            else if (branch.equals("Photo")){
                post.setImagePath(Text);
                refresh();
            }
        }

    }

}
