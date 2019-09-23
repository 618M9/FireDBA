package com.firedba;

import android.location.Address;

public class Student
{
    private String Name;
    private String Age;

    //create constructor

     Student()
    {



    }
    public Student(String Name,String Age)
    {
        this.Name = Name;
        this.Age = Age;


    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }


}
