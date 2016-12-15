package com.michaelwu.collegeapp.Model;

/**
 * Created by csaper6 on 12/9/16.
 */
public class Guardian extends Person {
    private int age;
    private String occupation;

    public Guardian(String FName, String LName, int age, String occupation) {
        this.LName=LName;
        this.FName=FName;
        this.age = age;
        this.occupation = occupation;
    }

    public Guardian(int age, String occupation) {
        this.age = age;
        this.occupation = occupation;
    }
    public Guardian() {
        this.age = 24;
        this.occupation = "TempConstructionWorker";
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
