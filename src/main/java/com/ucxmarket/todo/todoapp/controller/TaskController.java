package com.ucxmarket.todo.todoapp.controller;

import com.ucxmarket.todo.todoapp.repository.entity.Task.Status;
import com.ucxmarket.todo.todoapp.repository.entity.Task;
import com.ucxmarket.todo.todoapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins ="http://localhost:4200",allowedHeaders = "*")
@RequestMapping("/api")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping("/tasks")
    public List<Task> getAll() {
        return taskService.getAllTasks();
    }
    @GetMapping(value = "/tasks", params = {"title"})
    public List<Task> getTasksBy(String title) {
        return taskService.getTaskByTitle(title);
    }

    @GetMapping(value = "/tasks", params = {"status"})
    public List<Task> getAllTaskBy(@RequestParam Status status) {
        return taskService.getTaskByStatus(status);
    }

    @GetMapping("/tasks/{id}")
    public Optional<Task> getOne(@PathVariable Integer id) {
        return this.taskService.getById(id);
    }
    @PostMapping("/tasks")
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }
    @PutMapping("/tasks/{id}")
    public Task updateTask(@RequestBody Task task, @PathVariable Integer id) {
        return taskService.updateTask(id, task);
    }
    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@PathVariable Integer id) {
        taskService.deleteById(id);
    }
}
