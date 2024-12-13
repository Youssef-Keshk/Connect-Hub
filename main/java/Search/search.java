/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Search;

import databases.AccountDatabase;
import databases.GroupDatabase;
import entities.Group;
import entities.User;
import java.util.ArrayList;

/**
 *
 * @author moham
 */
public class search {
    private final AccountDatabase accountDatabase;
    private final GroupDatabase groupDatabase;

    public search(AccountDatabase accountDatabase, GroupDatabase groupDatabase) {
        this.accountDatabase = accountDatabase;
        this.groupDatabase = groupDatabase;
    }

    public ArrayList<String> searchByUsername(String username) {
        ArrayList<String> matchingUsernames = new ArrayList<>();
        ArrayList<User> allUsers = accountDatabase.getAllRecords();

        for (User user : allUsers) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                matchingUsernames.add(user.getUsername());
            }
        }
    return matchingUsernames;
    }

    public ArrayList<String> searchByGroupName(String groupName) {
        ArrayList<String> matchingGroups = new ArrayList<>();
        ArrayList<String> allGroupNames = groupDatabase.getAllGroupNames();

        for (String name : allGroupNames) {
            if (name.equalsIgnoreCase(groupName)) {
                matchingGroups.add(name);
            }
        }
    return matchingGroups;
    }
}
