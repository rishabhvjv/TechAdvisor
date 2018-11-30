package com.techadvisor.techadvisor.POJO;

/**
 * Created by test on 10/14/2018.
 */

public class User {

    String Name,Email;

    public User(){}

    public User(String name, String email) {
        Name = name;
        Email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
