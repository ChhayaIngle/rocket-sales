package com.example.registration.service;

import com.example.registration.entity.LeaveAttendance;
import com.example.registration.repository.LeaveAttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeaveAttendanceService {

    @Autowired
    private LeaveAttendanceRepository repository;

    public LeaveAttendance createOrUpdateLeaveAttendance(LeaveAttendance leaveAttendance) {
        return repository.save(leaveAttendance);
    }

    public Optional<LeaveAttendance> getLeaveAttendanceById(Long id) {
        return repository.findById(id);
    }

    public void deleteLeaveAttendance(Long id) {
        repository.deleteById(id);
    }

    public List<LeaveAttendance> getAllLeaveAttendances() {
        return repository.findAll();
    }
}
