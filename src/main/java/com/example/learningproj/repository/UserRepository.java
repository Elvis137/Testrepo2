package com.example.learningproj.repository;

import com.example.learningproj.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
User findByName(String name);
List<User> findByAge(int age);
}
