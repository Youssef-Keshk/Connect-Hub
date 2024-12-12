package group;

import databases.Count;
import databases.FilePaths;

import java.util.Calendar;

public class GroupCount extends Count implements FilePaths {

    public GroupCount() {
        super(GROUPS_COUNT_FILEPATH);
    }
}
