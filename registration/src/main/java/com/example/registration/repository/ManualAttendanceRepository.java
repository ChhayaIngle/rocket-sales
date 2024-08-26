package com.example.registration.repository;

import com.example.registration.entity.ManualAttendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManualAttendanceRepository extends JpaRepository<ManualAttendance, Long> {
}
