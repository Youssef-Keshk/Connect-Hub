package group;


import databases.DatabaseHandler;
import databases.FilePaths;
import entities.Post;

import java.util.ArrayList;

public class PostsDatabase extends DatabaseHandler<Grouppost> implements FilePaths {
    public PostsDatabase() {
        super(GROUPS_POSTS, Grouppost.class);
    }

    public ArrayList<Grouppost> getrecordesofuser(String groupid,String AuthorId) {
        ArrayList<Grouppost> recordesofuser = new ArrayList<>();
        for (int i = 0; i < getAllRecords().size(); i++) {
            if (getAllRecords().get(i).getGroupid().equals(groupid)&&
                getAllRecords().get(i).getAuthorId().equals(AuthorId)) {
                recordesofuser.add(getAllRecords().get(i));
            }
        }
        return recordesofuser;
    }

    public ArrayList<Grouppost> getrecordesofuser(String groupid) {
        ArrayList<Grouppost> recordesofuser = new ArrayList<>();
        for (int i = 0; i < getAllRecords().size(); i++) {
            if (getAllRecords().get(i).getGroupid().equals(groupid)) {
                recordesofuser.add(getAllRecords().get(i));
            }
        }
        return recordesofuser;
    }


}
