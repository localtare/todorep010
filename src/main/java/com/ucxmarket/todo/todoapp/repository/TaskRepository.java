package com.ucxmarket.todo.todoapp.repository;

import com.ucxmarket.todo.todoapp.repository.entity.Task.Status;
import com.ucxmarket.todo.todoapp.repository.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    List<Task> getTaskByTitle(String title);
    List<Task> getTaskByStatus(Status status);
}

