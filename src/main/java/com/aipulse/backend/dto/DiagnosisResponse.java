package com.aipulse.backend.dto;

public class DiagnosisResponse {
    private String message;
    private boolean risk;

    public DiagnosisResponse(String message, boolean risk) {
        this.message = message;
        this.risk = risk;
    }

    public String getMessage() {
        return message;
    }

    public boolean isRisk() {
        return risk;
    }
}