package com.example.learningproj;

import com.example.learningproj.models.Admin;
import com.example.learningproj.models.Guest;
import com.example.learningproj.models.User;

public class HelloWorld {
    public static void main(String[] args) {
//        Admin admin = new Admin();
//        admin.setName("Elvis");
//        admin.setPermission("delete_users");
//        admin.setAge(-50);
//        System.out.println(admin.getAge());
//        System.out.println(admin.getName());
//        System.out.println(admin.getPermission());

        HelloWorld hw = new HelloWorld();
        System.out.println(hw.Parse("123"));
        System.out.println(hw.Parse("hello"));

    }
    public String Parse(String a)
            {
                int b=0;

                try {
                    b = Integer.parseInt(a);
                    return String.valueOf(b);

                }
                catch (NumberFormatException e) {
                    return "invalid number";
                }

    }
       }
