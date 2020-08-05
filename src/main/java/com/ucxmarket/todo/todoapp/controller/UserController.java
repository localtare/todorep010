package com.ucxmarket.todo.todoapp.controller;

import com.ucxmarket.todo.todoapp.repository.entity.User;
import com.ucxmarket.todo.todoapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins ="http://localhost:4200",allowedHeaders = "*")
@RequestMapping("/api")


public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService= userService;
    }
    @GetMapping("/users")
    public List<User> getAll() {
        return userService.getAllUsers();
    }
    @GetMapping(value = "/users", params = {"name"})
    public List<User> getUsersBy(String name) {
        return userService.getUserByName(name);
    }

    @GetMapping(value = "/users", params = {"activeStatus"})
    public List<User> getAllUserBy(@RequestParam User.ActiveStatus activeStatus) {
        return userService.getUserByActiveStatus(activeStatus);
    }

    @GetMapping("/users/{id}")
    public Optional<User> getOne(@PathVariable Integer id) {
        return this.userService.getById(id);
    }
    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
    @PutMapping("/users/{id}")
    public User updateUser(@RequestBody User user, @PathVariable Integer id) {
        return userService.updateUser(id, user);
    }
    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteById(id);
    }








}
