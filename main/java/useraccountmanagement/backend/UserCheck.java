package main.java.useraccountmanagement.backend;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserCheck {

    public boolean Checkemailformat(String email) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@([a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean Checkpasswaedformat(String email){
        String regex="^[A-Za-z0-9@$#]{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean Checkemailrepeat(UserAccountManagement userAccountManagement,String email){
        for (int i = 0; i <userAccountManagement.getUsers().size() ; i++) {
            if (userAccountManagement.getUsers().get(i).getEmail().equals(email)){
                return false;
            }
        }
        return true;
    }

}
