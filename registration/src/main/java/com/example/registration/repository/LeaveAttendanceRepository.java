package com.example.registration.repository;

import com.example.registration.entity.LeaveAttendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveAttendanceRepository extends JpaRepository<LeaveAttendance, Long> {
	
}
