package com.example.playpal.datatypes;

/**
 * This class serves as an assisting class to facilitate user data storage.
 */
public class User {
    // TODO: maybe store aboutMe and sportInterests - not sure if applicable for our first version.
    // User is able to update their aboutMe and sportInterests in the EditProfile screen
    private String nickname, firstName, lastName, aboutMe;
    private SportInterest[] sportInterests;

    // Need to keep one empty constructor for the Firebase data storage.
    public User() {
    }

    public User(String nickname, String firstName, String lastName) {
        this.nickname = nickname;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters are used during setValue(new User(...))
    public String getNickname() {
        return nickname;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
