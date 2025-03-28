package com.example.playpal;

public class SportInterest
{
    String sportType;
    String proficiency;

    public SportInterest(String sportType, String proficiency)
    {
        this.sportType = sportType;
        this.proficiency = proficiency;
    }

    public String getSportType()
    {
        return sportType;
    }

    public String getProficiency()
    {
        return proficiency;
    }
}
