package entities;

import databases.GroupCount;

public class Groupbuilder {
  public String groupId;
  public String groupName;
  public String description;
  public String photoPath;
  public String primaryAdminId;
  
    public Groupbuilder groupId(String groupId) {
        this.groupId = groupId;
        return this;
    }
    
    public Groupbuilder groupName(String groupName) {
        this.groupName = groupName;
        return this;
    }
    
    public Groupbuilder description(String description) {
        this.description = description;
        return this;
    }
    
    public Groupbuilder photoPath(String photoPath) {
        this.photoPath = photoPath;
        return this;
    }
    
    public Groupbuilder primaryAdminId(String primaryAdminId) {
        this.primaryAdminId = primaryAdminId;
        return this;
    }


    public Group build() {
        GroupCount groupCount = new GroupCount();
        this.groupId = ("G" + groupCount.incrementAndGetCount());
        return new Group(this);
    }
}
