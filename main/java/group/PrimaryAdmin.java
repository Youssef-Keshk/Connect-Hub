package group;

import entities.Post;

public class PrimaryAdmin extends Groupmanger {
    private Manageposts manageposts;

    public PrimaryAdmin() {
        super();
        Manageposts Manageposts = new Manageposts(this.getPostsDatabase());
    }

    public Group upgradeuser(Group group, String ID) {
        if(this.getGroupDatabase().contains(group.getID())) {
            if (group.getMembers().contains(ID)) {
                group.getMembers().remove(ID);
                group.getOtheradmins().add(ID);
                refresh();
            }
        }
        return group;
    }

    public  Group demoteAdmin(Group group,String ID) {
        if(this.getGroupDatabase().contains(group.getID())) {
            if (group.getOtheradmins().contains(ID)) {
                group.getOtheradmins().remove(ID);
                group.getMembers().add(ID);
                refresh();
            }
        }
        return group;
    }

    public  Group removeanymember(Group group,String ID) {
        if(this.getGroupDatabase().contains(group.getID())) {
            if (group.getMembers().contains(ID)) {
                group.getMembers().remove(ID);
                refresh();
            } else if (group.getOtheradmins().contains(ID)) {
                group.getOtheradmins().remove(ID);
                refresh();
            }
        }
        return group;
    }

    public  boolean deletegroup(Group group) {
        if(this.getGroupDatabase().contains(group.getID())) {
            getGroupDatabase().removeRecord(group);
                refresh();
                return true;
        }
        return false;
    }




}
