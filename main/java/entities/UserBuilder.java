package entities;

import authenticators.PasswordHasher;
import enums.UserStatus;
import databases.UserCount;
import java.time.LocalDate;

// Builder creational pattern for User
public class UserBuilder {
    public String userId;
    public String email;
    public String username;
    public String password;
    public UserStatus status ;
    public LocalDate dateOfBirth;
    public Profile profile;
    
    private UserBuilder userId(String userId) {
            this.userId = userId;
            return this;
        }
    
    public UserBuilder email(String email) {
            this.email = email;
            return this;
        }
    
    public UserBuilder username(String username) {
            this.username = username;
            return this;
        }
    
    public UserBuilder password(String password) {
            this.password = PasswordHasher.getHashedPassword(password);
            System.out.println(this.password);
            return this;
        }
    
    private UserBuilder status(UserStatus status) {
            this.status = status;
            return this;
        }
    
    public UserBuilder dateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }
    
    public UserBuilder profile(Profile profile) {
            this.profile = profile;
            return this;
        }
    
    public User build() {
        UserCount userCount = new UserCount();
        this.userId("U" + userCount.incrementAndGetCount());
        this.status(UserStatus.ONLINE);
        return new User(this);
    }
    
    
}
