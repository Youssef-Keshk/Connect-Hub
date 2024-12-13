package group;

import managers.Manager;

public class Groupmanger implements Manager {
    private static Groupmanger instance;
    private final GroupDatabase groupDatabase;
    private final PostsDatabase postsDatabase;


    public Groupmanger() {
      this.postsDatabase = new PostsDatabase();
        groupDatabase = new GroupDatabase();
    }

    public static Groupmanger getInstance() {
        if(instance == null) {
            instance = new Groupmanger();
        }

        return instance;
    }

    public GroupDatabase getGroupDatabase() {
        return groupDatabase;
    }

    public PostsDatabase getPostsDatabase() {
        return postsDatabase;
    }

    @Override
    public void refresh() {
        groupDatabase.refreshRecords();
    }

    @Override
    public void save() {
      groupDatabase.saveRecords();
    }

}
