package com.example.registration.controller;

import com.example.registration.entity.LeaveAttendance;
import com.example.registration.service.LeaveAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/leave-attendance")
public class LeaveAttendanceController {

    @Autowired
    private LeaveAttendanceService leaveAttendanceService;

    @PostMapping
    public ResponseEntity<LeaveAttendance> createLeaveAttendance(@RequestBody LeaveAttendance leaveAttendance) {
        LeaveAttendance createdLeaveAttendance = leaveAttendanceService.createOrUpdateLeaveAttendance(leaveAttendance);
        return new ResponseEntity<>(createdLeaveAttendance, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeaveAttendance> getLeaveAttendanceById(@PathVariable Long id) {
        Optional<LeaveAttendance> leaveAttendance = leaveAttendanceService.getLeaveAttendanceById(id);
        return leaveAttendance.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<LeaveAttendance>> getAllLeaveAttendances() {
        List<LeaveAttendance> leaveAttendances = leaveAttendanceService.getAllLeaveAttendances();
        return ResponseEntity.ok(leaveAttendances);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLeaveAttendance(@PathVariable Long id) {
        leaveAttendanceService.deleteLeaveAttendance(id);
        return ResponseEntity.noContent().build();
    }
}
