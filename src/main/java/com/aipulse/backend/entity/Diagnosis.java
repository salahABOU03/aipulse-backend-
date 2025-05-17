package com.aipulse.backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Diagnosis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int bpm;

    private boolean risk;

    private String result; // ✅ Ajouter ce champ pour le message du modèle

    private LocalDateTime timestamp;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getBpm() { return bpm; }
    public void setBpm(int bpm) { this.bpm = bpm; }

    public boolean isRisk() { return risk; }
    public void setRisk(boolean risk) { this.risk = risk; }

    public String getResult() { return result; }
    public void setResult(String result) { this.result = result; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}
