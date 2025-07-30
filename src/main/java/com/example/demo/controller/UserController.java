package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

  private final UserRepository userRepository;

  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @GetMapping
  public List<User> getUsers() {
    return userRepository.findAll();
  }

  @PostMapping
  public User addUser(@RequestBody User user) {
    return userRepository.save(user);
  }

  @GetMapping("/{id}")
  public User getUserById(@PathVariable Integer id) {
    return userRepository.findById(id).orElse(null);
  }
}
