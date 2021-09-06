package com.company;

import java.util.Random;

public class UserProfile {

    int userId;
    String name;
    String password;
    String email;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    @Override
    public String toString() {
        return "User id: " + this.userId + "Your username is " + this.name + ". Your password is "
                + this.password + " Your email is " + this.email;
    }
}
