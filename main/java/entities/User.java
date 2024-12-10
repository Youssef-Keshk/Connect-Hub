package entities;

import enums.UserStatus;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonProperty;


public class User {
    @JsonProperty
    private String userId;
    @JsonProperty
    private String email;
    @JsonProperty
    private String username;
    @JsonProperty
    private String password;
    @JsonProperty
    private UserStatus status ;
    @JsonProperty
    private LocalDate dateOfBirth;
    @JsonProperty
    private Profile profile;

    public User(){}
    
    User(UserBuilder builder) {
        this.userId = builder.userId;
        this.email = builder.email;
        this.username = builder.username;
        this.password = builder.password;
        this.status = builder.status;
        this.dateOfBirth = builder.dateOfBirth;
        this.profile = builder.profile;
    }
    
    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public String getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Profile getProfile() {
        return profile;
    }  

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", email=" + email + ", username=" + username + ", password=" + password + ", status=" + status + ", dateOfBirth=" + dateOfBirth + ", profile=" + profile + '}';
    }
    
}
