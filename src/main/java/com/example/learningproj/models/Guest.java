package com.example.learningproj.models;

public class Guest extends User {
     private String expiryDate="2026-03-20";
     public String getExpiryDate() {
        return expiryDate;
     }
     public void setExpiryDate(String expiryDate) {
         this.expiryDate = expiryDate;
     }
    @Override
    public String getRole() {
        return "GUEST";
    }
    @Override
    public String getWelcomeMessage() {
        return "Welcome guest!";
    }
}
