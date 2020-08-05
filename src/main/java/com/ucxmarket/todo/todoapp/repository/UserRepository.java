package com.ucxmarket.todo.todoapp.repository;


import com.ucxmarket.todo.todoapp.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> getUserByActiveStatus(User.ActiveStatus activeStatus);

    List<User> getUserByName(String name);
}
