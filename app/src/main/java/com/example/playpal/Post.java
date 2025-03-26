package com.example.playpal;

public class Post {
    String postId, sportType, proficiency, time, place, description;

    public Post() {

    }

    public Post(String postId, String sportType, String proficiency, String time, String place, String description) {
        this.postId = postId;
        this.sportType = sportType;
        this.proficiency = proficiency;
        this.time = time;
        this.place = place;
        this.description = description;
    }

    public Post(String sportType, String proficiency, String time, String place, String description) {
        this.sportType = sportType;
        this.proficiency = proficiency;
        this.time = time;
        this.place = place;
        this.description = description;
    }

    public String getPostId() {
        return postId;
    }

    public String getSportType() {
        return sportType;
    }

    public String getProficiency() {
        return proficiency;
    }

    public String getTime() {
        return time;
    }

    public String getPlace() {
        return place;
    }

    public String getDescription() {
        return description;
    }
}
