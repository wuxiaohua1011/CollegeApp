package com.michaelwu.collegeapp.Model;

/**
 * Created by csaper6 on 12/9/16.
 */
public abstract class Person {
    protected String FName,LName;

    public Person() {
        FName="TempMichael";
        LName="TempWu";
    }

    public Person(String FName, String LName) {
        this.FName = FName;
        this.LName = LName;
    }

    public String getFName() {
        return FName;
    }

    public String getLName() {
        return LName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }
}
