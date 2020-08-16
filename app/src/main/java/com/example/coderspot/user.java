package com.example.coderspot;

public class user
{
    public String fname,lname,email,phno,dob,team,position;

    public user(String fname, String email, String phno, String dob, String team, String position){
        //constructor for getng the value from db
        //TOBO
        this.fname = fname;
        this.dob = dob;
        this.email = email;
        this.phno = phno;
        this.team = team;
        this.position = position;
    }



}
