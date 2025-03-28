package com.example.playpal;

import java.util.ArrayList;

public class User
{
    String username, firstName, lastName, userDescription;
    int[] postIdList;
    ArrayList<SportInterest> sportInterestList;

    public User(String username, String firstName, String lastName, String userDescription, int[] postIdList, ArrayList<SportInterest> sportInterestList)
    {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userDescription = userDescription;
        this.postIdList = postIdList;
        this.sportInterestList = sportInterestList;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public int[] getPostIdList() {
        return postIdList;
    }

    public ArrayList<SportInterest> getSportInterestList() {
        return sportInterestList;
    }

}
