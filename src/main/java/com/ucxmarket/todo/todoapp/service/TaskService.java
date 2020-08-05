package com.ucxmarket.todo.todoapp.service;

import com.ucxmarket.todo.todoapp.repository.entity.Task.Status;
import com.ucxmarket.todo.todoapp.repository.TaskRepository;
import com.ucxmarket.todo.todoapp.repository.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return this.taskRepository.findAll();
    }

    public Optional<Task> getById(Integer id) {
        return this.taskRepository.findById(id);
    }

    public void deleteById(Integer id) {
        this.taskRepository.deleteById(id);
    }

    public Task createTask(Task task) {
        return this.taskRepository.save(task);
    }

    public Task updateTask(Integer id, Task task) {
        return this.taskRepository.save(task);
    }

    public List<Task> getTaskByStatus(Status status) {
        return this.taskRepository.getTaskByStatus(status);
    }

    public List<Task> getTaskByTitle(String title) {
        return this.taskRepository.getTaskByTitle(title);
    }
}

