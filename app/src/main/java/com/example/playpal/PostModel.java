package com.example.playpal;

public class PostModel {
    int profileImage, sportProficiencyImage;
    String profileName, profileNickname, profileBriefDescription, sportType, meetingTime, meetingPlace, postDescription;

    public PostModel(int profileImage, int sportProficiencyImage, String profileName, String profileNickname,
                     String profileBriefDescription, String sportType, String meetingTime,
                     String meetingPlace, String postDescription) {
        this.profileImage = profileImage;
        this.sportProficiencyImage = sportProficiencyImage;
        this.profileName = profileName;
        this.profileNickname = profileNickname;
        this.profileBriefDescription = profileBriefDescription;
        this.sportType = sportType;
        this.meetingTime = meetingTime;
        this.meetingPlace = meetingPlace;
        this.postDescription = postDescription;
    }

    public int getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(int profileImage) {
        this.profileImage = profileImage;
    }

    public int getSportProficiencyImage() {
        return sportProficiencyImage;
    }

    public void setSportProficiencyImage(int sportProficiencyImage) {
        this.sportProficiencyImage = sportProficiencyImage;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileNickname() {
        return profileNickname;
    }

    public void setProfileNickname(String profileNickname) {
        this.profileNickname = profileNickname;
    }

    public String getProfileBriefDescription() {
        return profileBriefDescription;
    }

    public void setProfileBriefDescription(String profileBriefDescription) {
        this.profileBriefDescription = profileBriefDescription;
    }

    public String getSportType() {
        return sportType;
    }

    public void setSportType(String sportType) {
        this.sportType = sportType;
    }

    public String getMeetingTime() {
        return meetingTime;
    }

    public void setMeetingTime(String meetingTime) {
        this.meetingTime = meetingTime;
    }

    public String getMeetingPlace() {
        return meetingPlace;
    }

    public void setMeetingPlace(String meetingPlace) {
        this.meetingPlace = meetingPlace;
    }

    public String getPostDescription() {
        return postDescription;
    }

    public void setPostDescription(String postDescription) {
        this.postDescription = postDescription;
    }
}

