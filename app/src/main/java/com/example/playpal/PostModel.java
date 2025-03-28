package com.example.playpal;
public class PostModel
{
    private final String DEFAULT_VALUE_PLACEHOLDER = "default_value";
    String name;
    String userName;
    String userDescription;
    String gameTitle;
    String gameDate;
    String gameLocation;
    String sportType;

    int profilePictureImageId;
    int closeButtonImageId;
    int saveButtonImageId;
    int yesButtonImageId;

    public PostModel(String name, String userName, String userDescription, String gameTitle, String gameDate, String gameLocation) {
        this.name = name;
        this.userName = userName;
        this.userDescription = userDescription;
        this.gameTitle = gameTitle;
        this.gameDate = gameDate;
        this.gameLocation = gameLocation;
    }

    public PostModel(String sportType, String gameDate, String gameLocation) {
        this.name = DEFAULT_VALUE_PLACEHOLDER;
        this.userName = DEFAULT_VALUE_PLACEHOLDER;
        this.userDescription = DEFAULT_VALUE_PLACEHOLDER;
        this.profilePictureImageId = R.drawable.profile_picture_placeholder;
        this.sportType = sportType ; // i.e. sportType, TODO: need to standardize
        this.gameDate = gameDate; // i.e. time
        this.gameLocation = gameLocation; // i.e. place
    }

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public String getGameDate() {
        return gameDate;
    }

    public String getGameLocation() {
        return gameLocation;
    }

    public int getProfilePictureImageId() {
        return profilePictureImageId;
    }

    public int getCloseButtonImageId() {
        return closeButtonImageId;
    }

    public int getSaveButtonImageId() {
        return saveButtonImageId;
    }

    public int getYesButtonImageId() {
        return yesButtonImageId;
    }
}

