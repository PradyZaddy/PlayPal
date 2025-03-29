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

    String userId;

    int profilePictureImageId;
    int closeButtonImageId;
    int saveButtonImageId;
    int yesButtonImageId;

    public PostModel (String name, String userName, String userDescription, String userId, String sportType, String gameDate, String gameLocation)
    {
        this.name = name;
        this.userName = userName;
        this.userDescription = userDescription;
        this.userId = userId;
        this.sportType = sportType ; // i.e. sportType, TODO: need to standardize
        this.gameDate = gameDate; // i.e. time
        this.gameLocation = gameLocation; // i.e. place
    }

    public PostModel(String userId, String sportType, String gameDate, String gameLocation, String name, String userName)
    {
        this.userId = userId;
        this.sportType = sportType;
        this.gameDate = gameDate;
        this.gameLocation = gameLocation;

        this.name = name;
        this.userName = userName;
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

    public String getUserId() {
        return userId;
    }
}

