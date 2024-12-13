package managers;

import databases.GroupDatabase;
import entities.Group;

public class Groupmanger implements Manager {
    private static Groupmanger instance;
    private final GroupDatabase groupDatabase;

    public static Groupmanger getInstance() {
        if(instance == null) {
            instance = new Groupmanger();
        }
        return instance;
    } 
    
    private Groupmanger() {
        groupDatabase = new GroupDatabase();
    }
    
    @Override
    public void refresh() {
        groupDatabase.refreshRecords();
    }

    @Override
    public void save() {
      groupDatabase.saveRecords();
    }
    
    // Fetches Group by ID
    public Group getRecord(String groupId) {
        return groupDatabase.getRecord(groupId);
    }
    
    // Add new member to a group
    public boolean addMember(String groupId, String adminId, String userId) {
        Group group = getRecord(groupId);
        if(group == null)
            return false;
        if(group.hasAuthority(adminId)) { 
            boolean success = group.addMember(userId);
            if(success) save();
            return success;
        }
        return false;
    }
    
    // Remove member from a group
    public boolean removeMember(String groupId, String adminId, String userId) {
        Group group = getRecord(groupId);
        if(group == null)
            return false;
        if(group.hasAuthority(adminId)) {
            boolean success = group.removeMember(userId);
            if(success) save();
            return success;
        }
        return false;
    }
    
    // Remove co-admin from a group
    public boolean removeCoAdmin(String groupId, String adminId, String CoAdminId) {
        Group group = getRecord(groupId);
        if(group == null)
            return false;
        if(group.isPrimaryAdmin(adminId)) {
            boolean success = group.removeCoAdmin(CoAdminId);
            if(success) save();
            return success;
        }
        return false;
    }
    
    // Promte member of a group from member to co-admin
    public boolean promoteMember(String groupId, String adminId, String memberId) {
        Group group = getRecord(groupId);
        if(group == null)
            return false;
        if(group.isPrimaryAdmin(adminId)) {
            boolean success = group.promoteMember(memberId);
            if(success) save();
            return success;
        }
        return false;
    }
    
    // Demote member of a group from co-admin to member
    public boolean demoteCoAdmin(String groupId, String adminId, String CoAdminId) {
        Group group = getRecord(groupId);
        if(group == null)
            return false;
        if(group.isPrimaryAdmin(adminId)) {
            boolean success = group.demoteCoAdmin(CoAdminId);
            if(success) save();
            return success;
        }
        return false;
    }
   
    // Delete group from records
    public boolean deleteGroup(String groupId, String adminId) {
        Group group = getRecord(groupId);
        if(group == null)
            return false;
        if(group.isPrimaryAdmin(adminId))
            return groupDatabase.removeRecord(group);
        return false;
    }

}
