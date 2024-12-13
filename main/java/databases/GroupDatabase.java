package databases;

import entities.Group;
import java.util.ArrayList;

public class GroupDatabase extends DatabaseHandler<Group>{
    
    public GroupDatabase() {
        super(FilePaths.GROUPS_FILEPATH, Group.class);
    }
    
    public boolean contains(String groupId) {
        for(Group group : records) 
            if(group.getGroupId().equals(groupId))
                return true;
        return false;
    }
    
    public Group getRecord(String groupId) {
        for(Group group : records)
            if(group.getGroupId().equals(groupId))
                return group;
        return null;
    }
    
    public ArrayList<String> getAllGroupNames() {
    ArrayList<String> groupNames = new ArrayList<>();
        for (Group group : records) {
            groupNames.add(group.getGroupName());
        }

    return groupNames;
}

}
