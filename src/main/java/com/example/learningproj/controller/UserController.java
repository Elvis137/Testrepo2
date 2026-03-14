package com.example.learningproj.controller;

import com.example.learningproj.exception.InvalidAgeException;
import com.example.learningproj.models.User;
import com.example.learningproj.service.UserService;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class  UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/status")
    public String checkStatus()
    {
        return "User system is functional!";
    }
    @GetMapping("/all")
    public List<User> getAllUsers()
    {
        return userService.getList();
    }
    @PostMapping ("/adduser")
    public String addUser(@Valid @RequestBody User user)
    {
        userService.addUser(user);
        return "User"+ user.getName()+ "added!";
    }
    @GetMapping("/user/{id}")
    public User getUserByName(@PathVariable("id") Long id) {
        return userService.getUser(id);

    }
    @DeleteMapping ("/delete/{id}")

        public User deleteUserByName(@PathVariable("id") Long id)
        {
           return userService.deleteUser(id);
        }

    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody User newDetails) {
        return userService.updateUser(id, newDetails);
    }
    @GetMapping ("/get/{age}")
    public List<User> getUserByAge(@PathVariable("age") int age) throws InvalidAgeException
    {
        return userService.getUserByAge(age);
    }

}
