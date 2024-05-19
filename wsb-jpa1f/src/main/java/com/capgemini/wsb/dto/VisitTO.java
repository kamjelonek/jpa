package com.capgemini.wsb.dto;

import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.MedicalTreatmentEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class VisitTO implements Serializable
{
    private Long id;
    private String description;
    private LocalDateTime time;

    private DoctorEntity doctor;
    private PatientEntity patient;

    private List<MedicalTreatmentEntity> medicalTreatments = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public LocalDateTime getTime() { return time; }

    public void setTime(LocalDateTime time) { this.time = time; }



    public List<MedicalTreatmentEntity> getMedicalTreatments() { return medicalTreatments; }
    public void setMedicalTreatments(List<MedicalTreatmentEntity> medicalTreatments) { this.medicalTreatments = medicalTreatments; }

    public DoctorEntity getDoctor() { return doctor; }
    public void setDoctor(DoctorEntity visits) { this.doctor = visits; }

    public PatientEntity getPatient() { return patient; }
    public void setPatient(PatientEntity visits) { this.patient = visits; }


}
