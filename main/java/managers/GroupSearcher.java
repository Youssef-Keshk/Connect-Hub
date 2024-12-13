package managers;

import databases.GroupDatabase;
import entities.Group;
import java.util.ArrayList;
import java.util.Iterator;


public class GroupSearcher implements SearchGeneratorImplementor<Group>{
    private final ArrayList<Group> groups;
    
    public GroupSearcher() {
        GroupDatabase groupDatabase = new GroupDatabase();
        groups = groupDatabase.getAllRecords();
    }
    

    @Override
    public ArrayList<Group> search(String searchKey) {
        searchKey = searchKey.toLowerCase();
        ArrayList<Group> matchingGroups = new ArrayList<>();
        ArrayList<Group> toRemove = new ArrayList<>();

        // Users with username similar to searchkey
        for(Group group : groups) {
            if(group.getGroupName().toLowerCase().equals(searchKey)) {
                matchingGroups.add(group);
                toRemove.add(group);
            }
        }
        
        groups.removeAll(toRemove);
        toRemove.clear();
        
        // Users with username starts with searchkey
        for(Group group : groups) {
            if(group.getGroupName().toLowerCase().startsWith(searchKey)) {
                matchingGroups.add(group);
                toRemove.add(group);
            }
        }
        
        groups.removeAll(toRemove);
        toRemove.clear();
        
        // Users with username ends by searchkey
        for(Group group : groups) {
            if(group.getGroupName().toLowerCase().endsWith(searchKey)) {
                matchingGroups.add(group);
                toRemove.add(group);
            }
        }
        
        return matchingGroups;
    }
    
}
