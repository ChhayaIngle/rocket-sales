package com.example.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.registration.entity.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
}
