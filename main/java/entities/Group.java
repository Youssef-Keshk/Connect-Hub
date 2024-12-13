package entities;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Group {
    @JsonProperty
    private String groupId;
    @JsonProperty
    private String groupName;
    @JsonProperty
    private String description;
    @JsonProperty
    private String photoPath;
    @JsonProperty
    private String primaryAdminId;
    @JsonProperty
    private ArrayList<String> coAdminsIds;
    @JsonProperty
    private ArrayList<String> membersIds;


    public Group(){}
     
    public Group(Groupbuilder builder) {
        this.groupId = builder.groupId;
        this.groupName = builder.groupName;
        this.description = builder.description;
        this.photoPath = builder.photoPath;
        this.primaryAdminId = builder.primaryAdminId;
        this.coAdminsIds = new ArrayList<>();
        this.membersIds = new ArrayList<>();
    }

    public static Groupbuilder builder() {
        return new Groupbuilder();
    }

    public String getGroupId() {
        return groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getPrimaryAdminId() {
        return primaryAdminId;
    }

    public ArrayList<String> getCoAdminsIds() {
        return coAdminsIds;
    }

    public ArrayList<String> getMembersIds() {
        return membersIds;
    }
    
    public boolean addAdmin(String primaryAdminId) {
        if(this.primaryAdminId == null) {
            this.primaryAdminId = primaryAdminId;
            return true;
        }
        return false;
    }
    
    // Method to add new member to group
    public boolean addMember(String userId) {
        if(!membersIds.contains(userId) && !coAdminsIds.contains(userId) && !primaryAdminId.equals(userId)) {
            membersIds.add(userId);
            return true;
        }
        return false;
    }
    
    // Method to remove member from group
    public boolean removeMember(String memberId) {
        return membersIds.remove(memberId);
    }
    
    // Method to remove co-admin from group
    public boolean removeCoAdmin(String memberId) {
        return coAdminsIds.remove(memberId);
    }
    
    
    // Method to promote a user from member to co-admin
    public boolean promoteMember(String memberId) {
        if(!(membersIds.contains(memberId) && !coAdminsIds.contains(memberId) && !primaryAdminId.equals(memberId))) 
            return false;
        membersIds.remove(memberId);
        return coAdminsIds.add(memberId);
    }
    
    // Method to demote a user from co-admin to member
    public boolean demoteCoAdmin(String coAdminId) {
        if(!(!membersIds.contains(coAdminId) && coAdminsIds.contains(coAdminId) && !primaryAdminId.equals(coAdminId))) 
            return false;
        coAdminsIds.remove(coAdminId);
        return membersIds.add(coAdminId);
    }
    
    // Method to check if user is primary admin
    public boolean isPrimaryAdmin(String userId) {
        return primaryAdminId.equals(userId);
    }
    
    // Method to check if user is co-admin
    public boolean isCoAdmin(String userId) {
        return coAdminsIds.contains(userId);
    }
    
    // Method to check if user is has group authority
    public boolean hasAuthority(String userId) {
        return isPrimaryAdmin(userId) || isCoAdmin(userId);
    }
    
    
    @Override
    public String toString() {
        return "Group{" + "groupId=" + groupId 
                + ", groupName=" + groupName 
                + ", description=" + description 
                + ", photoPath=" + photoPath 
                + ", adminId=" + primaryAdminId 
                + ", coAdminsIds=" + coAdminsIds 
                + ", membersIds=" + membersIds + '}';
    }
    
    
}
