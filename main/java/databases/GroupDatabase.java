package databases;

import entities.Group;

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

}
