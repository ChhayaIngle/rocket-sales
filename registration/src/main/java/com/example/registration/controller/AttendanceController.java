package com.example.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.registration.entity.Attendance;
import com.example.registration.service.AttendanceService;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    /**
     * Retrieve attendance by ID.
     * 
     * @param id the ID of the attendance record
     * @return the attendance record or 404 if not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<Attendance> getAttendanceById(@PathVariable Long id) {
        Attendance attendance = attendanceService.getAttendanceById(id);
        return attendance != null ? 
            new ResponseEntity<>(attendance, HttpStatus.OK) : 
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Create a new attendance record.
     * 
     * @param attendance the attendance data to create
     * @return the created attendance record
     */
    @PostMapping
    public ResponseEntity<Attendance> createAttendance(@RequestBody Attendance attendance) {
        Attendance createdAttendance = attendanceService.createOrUpdateAttendance(attendance);
        return new ResponseEntity<>(createdAttendance, HttpStatus.CREATED);
    }

    /**
     * Update an existing attendance record.
     * 
     * @param id the ID of the attendance record to update
     * @param attendance the updated attendance data
     * @return the updated attendance record or 404 if not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<Attendance> updateAttendance(@PathVariable Long id, @RequestBody Attendance attendance) {
        attendance.setId(id);  // Ensure the ID is set for the update operation
        Attendance updatedAttendance = attendanceService.createOrUpdateAttendance(attendance);
        return updatedAttendance != null ? 
            new ResponseEntity<>(updatedAttendance, HttpStatus.OK) : 
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Delete an attendance record by ID.
     * 
     * @param id the ID of the attendance record to delete
     * @return no content response
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttendance(@PathVariable Long id) {
        boolean isDeleted = attendanceService.deleteAttendance(id);
        return isDeleted ? 
            new ResponseEntity<>(HttpStatus.NO_CONTENT) : 
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
