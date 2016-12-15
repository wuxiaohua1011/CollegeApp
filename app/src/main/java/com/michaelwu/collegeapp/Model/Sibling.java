package com.michaelwu.collegeapp.Model;

/**
 * Created by csaper6 on 12/9/16.
 */
public class Sibling extends Person {
    private String relationship;
    private int age;

    public Sibling(String FName, String LName, String relationship, int age) {
        this.FName=FName;
        this.LName=LName;
        this.relationship = relationship;
        this.age = age;
    }

    public Sibling(String relationship, int age) {
        this.relationship = relationship;
        this.age = age;
    }

    public Sibling(){
        this.relationship="TempBrother";
        this.age=18;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
