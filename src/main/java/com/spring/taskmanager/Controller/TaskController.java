package com.spring.taskmanager.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.spring.taskmanager.model.Task;
import com.spring.taskmanager.service.TaskService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/user/{userId}")
    public Task createTask(@PathVariable int userId, @RequestBody Task task) {
        return taskService.createTask(userId, task);
    }

    @GetMapping("/user/{userId}")
    public List<Task> getTasksByUser(@PathVariable Long userId) {
        return taskService.getTasksByUser(userId);
    }

    @GetMapping("/{taskId}")
    public Optional<Task> getTaskById(@PathVariable Long taskId) {
        return taskService.getTaskById(taskId);
    }

    @PutMapping("/{taskId}")
    public Task updateTask(@PathVariable Long taskId, @RequestBody Task task) {
        return taskService.updateTask(taskId, task);
    }

    @DeleteMapping("/{taskId}")
    public void deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
    }
}