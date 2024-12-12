package group;

public class Member extends Groupmanger{
    public Member(){
        super();
    }

    public boolean leave(Group group,String id){
        if(getGroupDatabase().contains(group.getID())){
            if (group.getMembers().contains(id)){
                group.getMembers().remove(id);
                return true;
            }
        }
        return false;
    }

    public void addpost(Grouppost post) {
        getPostsDatabase().getAllRecords().add(post);
        refresh();
    }

}
