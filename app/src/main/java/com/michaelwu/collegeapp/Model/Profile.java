package com.michaelwu.collegeapp.Model;

import java.util.Date;

/**
 * Created by csaper6 on 12/7/16.
 */
public class Profile {
    private String FirstName;
    private String LastName;
    private Date birthday;

    public Profile(String firstName, String lastName, Date birthday) {
        FirstName = firstName;
        LastName = lastName;
        this.birthday = birthday;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
