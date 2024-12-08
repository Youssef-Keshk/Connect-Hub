package entities;

// Builder creational pattern for profile

public class ProfileBuilder {
    public String profilePhotoPath = "";
    public String coverPhotoPath = "";
    public String bio = "";    
    
    
    public ProfileBuilder profilePhotoPath(String profilePhotoPath) {
            this.profilePhotoPath = profilePhotoPath;
            return this;
        }

    public ProfileBuilder coverPhotoPath(String coverPhotoPath) {
        this.coverPhotoPath = coverPhotoPath;
        return this;
    }

    public ProfileBuilder bio(String bio) {
        this.bio = bio;
        return this;
    }

    public Profile build() {
        return new Profile(this);
    }
}
