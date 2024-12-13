package group;

import java.util.ArrayList;

public class Group {
  private   String ID;
  private  String name;
  private String description;
  private String photo;
  private String primaryadmin;
  private ArrayList<String> otheradmins;
  private ArrayList<String> members;


    public Group(Groupbuilder builder) {
        this.ID = builder.getID();
        this.name = builder.getName();
        this.description = builder.getDescription();
        this.photo = builder.getPhoto();
        this.primaryadmin = builder.getPrimaryadmin();
        this.otheradmins = builder.getOtheradmins();
        this.members = builder.getMembers();
    }

    public static Groupbuilder builder() {
        return new Groupbuilder();
    }

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
}
