package com.example.registration.service;

import com.example.registration.entity.TaskManagement;
import com.example.registration.repository.TaskManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskManagementService {

    @Autowired
    private TaskManagementRepository taskManagementRepository;

    public List<TaskManagement> getAllTasks() {
        return taskManagementRepository.findAll();
    }

    public TaskManagement getTaskById(String id) {
        return taskManagementRepository.findById(id).orElse(null);
    }

    public TaskManagement createTask(TaskManagement taskManagement) {
        return taskManagementRepository.save(taskManagement);
    }

    public TaskManagement updateTask(String id, TaskManagement taskDetails) {
        return taskManagementRepository.findById(id)
                .map(task -> {
                    task.setTitle(taskDetails.getTitle());
                    task.setLocation(taskDetails.getLocation());
                    task.setTask_status(taskDetails.getTask_status());
                    return taskManagementRepository.save(task);
                })
                .orElse(null);
    }

    public boolean deleteTask(String id) {
        return taskManagementRepository.findById(id)
                .map(task -> {
                    taskManagementRepository.delete(task);
                    return true;
                })
                .orElse(false);
    }
}
