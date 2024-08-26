package com.example.registration.controller;

import com.example.registration.entity.TaskManagement;
import com.example.registration.service.TaskManagementService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskManagementController {

    @Autowired
    private TaskManagementService taskService;

    @GetMapping
    public List<TaskManagement> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskManagement> getTaskById(@PathVariable String id) {
    	TaskManagement task = taskService.getTaskById(id);
        if (task != null) {
            return ResponseEntity.ok(task);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public TaskManagement createTask(@RequestBody TaskManagement taskmanagement) {
        return taskService.createTask(taskmanagement);
    }
    
//    @PostMapping
//    public ResponseEntity<User> createUser(@RequestBody TaskManagement taskmanagement) {
//        try {
//            User savedUser = TaskManagementService.createTaskManagement(taskmanagement);
//            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskManagement> updateTask(@PathVariable String id, @RequestBody TaskManagement taskDetails) {
    	TaskManagement updatedTask = taskService.updateTask(id, taskDetails);
        if (updatedTask != null) {
            return ResponseEntity.ok(updatedTask);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable String id) {
        boolean isDeleted = taskService.deleteTask(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
