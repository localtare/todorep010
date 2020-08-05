package com.ucxmarket.todo.todoapp.service;


import com.ucxmarket.todo.todoapp.repository.UserRepository;

import com.ucxmarket.todo.todoapp.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public Optional<User> getById(Integer id) {
        return this.userRepository.findById(id);
    }

    public void deleteById(Integer id) {
        this.userRepository.deleteById(id);
    }

    public User createUser(User user) {
        return this.userRepository.save(user);
    }

    public User updateUser(Integer id, User user) {
        return this.userRepository.save(user);
    }
    public List<User> getUserByActiveStatus(User.ActiveStatus activeStatus){
        return this.userRepository.getUserByActiveStatus(activeStatus);
    }

    public List<User> getUserByName(String name){
        return this.userRepository.getUserByName(name);
    }

}
