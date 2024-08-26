package com.example.registration.repository;

import com.example.registration.entity.TaskManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskManagementRepository extends JpaRepository<TaskManagement, String> {
}
