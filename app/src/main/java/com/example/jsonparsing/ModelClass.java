package com.example.jsonparsing;

public class ModelClass {
    private String id,firstName,lastName,gender,eyecolor,haircolor,typee;

    public ModelClass(String id,String firstName, String lastName,String gender,String eyecolor,String HairColor,String type) {
        this.id=id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender=gender;
        this.eyecolor=eyecolor;
        this.haircolor=HairColor;
        typee=type;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public String getId() {
        return id;
    }
    public String getGender() {
        return gender;
    }
    public  String getEyecolor(){
        return eyecolor;
    }

    public String getHaircolor() {
        return haircolor;
    }

    public String getTypee() {
        return typee;
    }

    public void setFirstName(String newName)
    {
        this.firstName=newName;
    }
    public void setLastName(String lastName)
    {
        this.lastName=lastName;
    }
}
