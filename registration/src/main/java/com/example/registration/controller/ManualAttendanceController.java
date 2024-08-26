package com.example.registration.controller;

import com.example.registration.entity.ManualAttendance;
import com.example.registration.service.ManualAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/manual-attendance")
public class ManualAttendanceController {

    @Autowired
    private ManualAttendanceService manualAttendanceService;

    @GetMapping("/{id}")
    public ResponseEntity<ManualAttendance> getManualAttendanceById(@PathVariable Long id) {
        ManualAttendance manualAttendance = manualAttendanceService.getManualAttendanceById(id);
        if (manualAttendance != null) {
            return new ResponseEntity<>(manualAttendance, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<ManualAttendance>> getAllManualAttendances() {
        List<ManualAttendance> manualAttendances = manualAttendanceService.getAllManualAttendances();
        return new ResponseEntity<>(manualAttendances, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ManualAttendance> createManualAttendance(@RequestBody ManualAttendance manualAttendance) {
        ManualAttendance createdManualAttendance = manualAttendanceService.createOrUpdateManualAttendance(manualAttendance);
        return new ResponseEntity<>(createdManualAttendance, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ManualAttendance> updateManualAttendance(@PathVariable Long id, @RequestBody ManualAttendance manualAttendance) {
        manualAttendance.setId(id);
        ManualAttendance updatedManualAttendance = manualAttendanceService.createOrUpdateManualAttendance(manualAttendance);
        if (updatedManualAttendance != null) {
            return new ResponseEntity<>(updatedManualAttendance, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteManualAttendance(@PathVariable Long id) {
        manualAttendanceService.deleteManualAttendance(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
