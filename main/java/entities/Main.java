package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import managers.ContentManager;
import managers.FriendshipManager;
import managers.UserManager;


public class Main {
    public static void main(String[] args) {
        Profile profile = Profile.builder()
                .bio("Hello")
                .profilePhotoPath("src\\main\\java\\icons\\image.jpeg")
                .coverPhotoPath("src\\main\\java\\icons\\image.jpeg")
                .build();
        
        User user = User.builder()
                .dateOfBirth(LocalDate.now())
                .email("youssef@gmail.com")
                .password("keshk")
                .username("Youssef-Keshk")
                .profile(profile)
                .build();
        
        
        Story s = new Story("U4", "Good afternoon", "src\\main\\java\\icons\\image.jpeg");
        Post p = new Post("U1", "Hello", "src\\main\\java\\icons\\image.jpeg");
        
        UserManager um = new UserManager();
        FriendshipManager fm = new FriendshipManager();
        ContentManager cm = new ContentManager();
        
        cm.addPost(p);
        cm.addStory(s);
        
        ArrayList<Content> c = cm.get();
        ArrayList<Friendship> f = fm.get();
        //ArrayList<User> u = um.get();
        
        
        for(Content cont : c)
            System.out.println(cont);
        
        for(Friendship cont : f)
            System.out.println(cont);
        
//        for(User cont : u)
//            System.out.println(cont);
    }
}
