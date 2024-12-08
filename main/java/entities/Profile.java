package entities;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Profile {
    @JsonProperty
    private String profilePhotoPath;
    @JsonProperty
    private String coverPhotoPath;
    @JsonProperty
    private String bio;

    public Profile(){}
    
    Profile(ProfileBuilder builder) {
        this.profilePhotoPath = builder.profilePhotoPath;
        this.coverPhotoPath = builder.coverPhotoPath;
        this.bio = builder.bio;
    }
    
    public static ProfileBuilder builder() {
        return new ProfileBuilder();
    }
    
    public String getProfilePhotoPath() {
        return profilePhotoPath;
    }

    public void setProfilePhotoPath(String profilePhotoPath) {
        this.profilePhotoPath = profilePhotoPath;
    }

    public String getCoverPhotoPath() {
        return coverPhotoPath;
    }

    public void setCoverPhotoPath(String coverPhotoPath) {
        this.coverPhotoPath = coverPhotoPath;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public String toString() {
        return "Profile{" + "profilePhotoPath=" + profilePhotoPath + ", coverPhotoPath=" + coverPhotoPath + ", bio=" + bio + '}';
    }
}
