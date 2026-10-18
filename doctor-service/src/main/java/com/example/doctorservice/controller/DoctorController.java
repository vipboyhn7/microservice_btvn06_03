package com.example.doctorservice.controller;

import com.example.doctorservice.entity.Doctor;
import com.example.doctorservice.repository.DoctorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    private final DoctorRepository doctorRepository;

    public DoctorController(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @GetMapping
    public List<DoctorSummary> getDoctors() {
        return doctorRepository.findAll().stream()
                .map(doctor -> new DoctorSummary(
                        doctor.getId(),
                        doctor.getName(),
                        doctor.getSpecialization()))
                .toList();
    }

    public record DoctorSummary(Long id, String name, String specialization) {
    }
}
