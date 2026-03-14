package com.example.learningproj.models;

public class Admin extends User  implements Describable {
     private String permission="delete_users";

    @Override
    public String describe() {
        return " admin described";
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
    public String getPermission() {
        return permission;
    }
    @Override
    public String getRole() {
        return "ADMIN";
    }
    @Override
    public String getWelcomeMessage() {
        return "Welcome admin!";
    }
}
