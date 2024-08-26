package com.example.registration.service;

import com.example.registration.entity.ManualAttendance;
import com.example.registration.repository.ManualAttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManualAttendanceService {

    @Autowired
    private ManualAttendanceRepository manualAttendanceRepository;

    public ManualAttendance createOrUpdateManualAttendance(ManualAttendance manualAttendance) {
        return manualAttendanceRepository.save(manualAttendance);
    }

    public ManualAttendance getManualAttendanceById(Long id) {
        return manualAttendanceRepository.findById(id).orElse(null);
    }

    public List<ManualAttendance> getAllManualAttendances() {
        return manualAttendanceRepository.findAll();
    }

    public void deleteManualAttendance(Long id) {
        manualAttendanceRepository.deleteById(id);
    }
}
