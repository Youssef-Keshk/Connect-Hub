package group;

import databases.UserCount;

import java.util.ArrayList;

public class Groupbuilder {
    private String ID;
    private String name;
    private String description;
    private String photo;
    private String groupAdmin;
    private String primaryadmin;
    private ArrayList<String> otheradmins;
    private ArrayList<String> members;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getGroupAdmin() {
        return groupAdmin;
    }

    public void setGroupAdmin(String groupAdmin) {
        this.groupAdmin = groupAdmin;
    }

    public String getPrimaryadmin() {
        return primaryadmin;
    }

    public void setPrimaryadmin(String primaryadmin) {
        this.primaryadmin = primaryadmin;
    }

    public ArrayList<String> getOtheradmins() {
        return otheradmins;
    }

    public void setOtheradmins(ArrayList<String> otheradmins) {
        this.otheradmins = otheradmins;
    }

    public ArrayList<String> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<String> members) {
        this.members = members;
    }

    public String getID() {
        return ID;
    }

    public Group build() {
        GroupCount groupCount = new GroupCount();
        this.ID=("G" + groupCount.incrementAndGetCount());
        return new Group(this);
    }
}
