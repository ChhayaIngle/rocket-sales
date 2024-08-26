package com.example.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.registration.entity.Attendance;
import com.example.registration.repository.AttendanceRepository;

import java.util.Optional;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public Attendance getAttendanceById(Long id) {
        return attendanceRepository.findById(id).orElse(null);
    }

    public Attendance createOrUpdateAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    public boolean deleteAttendance(Long id) {
        attendanceRepository.deleteById(id);
        return false;
    }
}
