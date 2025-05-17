package com.aipulse.backend.controller;

import com.aipulse.backend.entity.Diagnosis;
import com.aipulse.backend.repository.DiagnosisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/diagnosis")
@CrossOrigin(origins = "*")
public class DiagnosisController {

    @Autowired
    private DiagnosisRepository diagnosisRepository;

    @PostMapping
    public Diagnosis saveDiagnosis(@RequestBody Diagnosis diagnosis) {
        diagnosis.setTimestamp(LocalDateTime.now());
        return diagnosisRepository.save(diagnosis);
    }

    @GetMapping
    public List<Diagnosis> getAll() {
        return diagnosisRepository.findAll();
    }
}
