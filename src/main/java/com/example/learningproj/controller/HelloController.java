package com.example.learningproj.controller;

import com.example.learningproj.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class  HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello Spring!";
    }
    @GetMapping("/hello/{number}")
            public String getsquare(@PathVariable int number) {
        return "the square is"+ number*number;
    }
    @GetMapping("hello/cube/{num}")
    public String getcube(@PathVariable int num) {
        return "the cube is"+ (num*num*num);
    }
    @GetMapping("hello/greet/{name}")
    public String getgreet(@PathVariable String name) {
        return "Hello "+name;
    }
    @GetMapping("/hello/age/{birthyear}")
    public String getage(@PathVariable int birthyear) {
        return "Your age is " + (2025 - birthyear);
    }
    @GetMapping("hello/sum")
    public String getsum(@RequestParam int num1, @RequestParam int num2) {
        return "Your sum is " + (num1 + num2);
    }
    @GetMapping ("hello/details/{name}")
    public Map<String, Object> getdetails(@PathVariable String name) {

        Map<String, Object> map = new HashMap<>();
        map.put("name",name);
        map.put("age",2025);
        map.put("birthyear",2025);
        map.put("message", "Welcome to Spring Boot!");
        return map;
    }
    @GetMapping("hello/user/{name}/{age}")
    public User getuser(@PathVariable String name, @PathVariable int age) {
        return new User(name,age);
    }
}
