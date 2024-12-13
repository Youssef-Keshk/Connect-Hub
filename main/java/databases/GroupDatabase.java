package group;

import databases.DatabaseHandler;
import databases.FilePaths;
import entities.User;

public class GroupDatabase extends DatabaseHandler<Group> implements FilePaths {
    public GroupDatabase() {
        super(GROUPS_FILEPATH, Group.class);
    }

    public boolean contains(String groupId) {
        for (int i = 0; i < getAllRecords().size(); i++) {
            if (getAllRecords().get(i).getID().equals(groupId)) {
                return true;
            }
        }
        return false;
    }

    public int searchgroup(String groupID) {
        for (int i = 0; i < getAllRecords().size(); i++) {
            if (getAllRecords().get(i).getID().equals(groupID)) {
                return i;
            }
        }
        return -1;
    }

    public int searchgroupadmin(String AdminID) {
        for (int i = 0; i < getAllRecords().size(); i++) {
            if (getAllRecords().get(i).getPrimaryadmin().equals(AdminID)) {
                return i;
            }
        }
        return -1;
    }

    public int searchgroupuser(String UserID) {
        for (int i = 0; i < getAllRecords().size(); i++) {
            if (getAllRecords().get(i).getMembers().contains(UserID)) {
                return i;
            }
        }
        return -1;
    }

    public  int searchgroupadmins(String admin) {
        for (int i = 0; i < getAllRecords().size(); i++) {
            if (getAllRecords().get(i).getPrimaryadmin().equals(admin)) {
                return i;
            }
        }
        return -1;
    }

}
