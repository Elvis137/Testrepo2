package com.example.learningproj.service;

import com.example.learningproj.exception.InvalidAgeException;
import com.example.learningproj.models.User;
import com.example.learningproj.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
public final UserRepository userRepository;
 public UserService(UserRepository userRepository) {
     this.userRepository = userRepository;
 }
    public List<User> getList() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }
    public User getUser(Long id)
    {
        User user=userRepository.findById(id).orElse(null);
        if(user!=null)
        {
            return user;
        }

      return null;

    }
    public User deleteUser(Long id) {
        // 1. Find the user first using our existing method
        User foundUser = getUser(id);

        // 2. If the user exists, remove them from the list
        if (foundUser != null) {
            userRepository.deleteById(id);
        }

        // 3. Return the user (or null if they weren't found)
        return foundUser;
    }

    public User updateUser(Long id, User newDetails) {
        // 1. Find the user
        User user = userRepository.findById(id).orElse(null);

        if (user != null) {
            // 2. Change the data in the object
            user.setAge(newDetails.getAge());

            // 3. Save the modified object back to the database
            return userRepository.save(user);
        }
        return null;
    }

public List<User>getUserByAge(int age) throws InvalidAgeException {
     if(age<0||age>100) {
         throw new InvalidAgeException("Invalid age");
     }

     return userRepository.findByAge(age);
}
}
