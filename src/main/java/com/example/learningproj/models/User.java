package com.example.learningproj.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity // Add this!
@Table(name = "users")
public   class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Min(value = 0, message = "Age cannot be negative")
    @Max(value = 120, message = "Age is too high")
    private int age;


    public String getRole() {
        return "USER";
    }
    public String getWelcomeMessage() {
        return "Welcome!";
    }
    // 1. Add a Default Constructor (No arguments)
    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

     public Long getId() {
        return id;
     }
    public String getName() {
        return name;
    }

    // 2. Add Setters so Jackson can "set" the values from JSON
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
if(age < 0||age > 120) {throw new IllegalArgumentException("Age is invalid");}
      else{  this.age = age;}
    }
//    public user getUSer()
//    {
//        return this.user;
//    }
}