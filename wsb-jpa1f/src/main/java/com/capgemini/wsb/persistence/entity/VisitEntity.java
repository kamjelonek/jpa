package com.capgemini.wsb.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "VISIT")
public class VisitEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;

	@Column(nullable = false)
	private LocalDateTime time;

	@ManyToOne
	@JoinColumn(name = "doctor_id", referencedColumnName = "id")
	//@JsonBackReference
	@JsonIgnore
	private DoctorEntity doctor;

	@ManyToOne
	@JoinColumn(name = "patient_id", referencedColumnName = "id")
	//@JsonBackReference
	@JsonIgnore
	private PatientEntity patient;

	@OneToMany(mappedBy = "visit_id")
	@JsonIgnore
	private List<MedicalTreatmentEntity> medicalTreatments = new ArrayList<>();



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}



	public DoctorEntity getDoctor() { return doctor; }
	public void setDoctor(DoctorEntity doctor) { this.doctor = doctor; }

	public PatientEntity getPatient() { return patient; }
	public void setPatient(PatientEntity patient) { this.patient = patient; }


    // tu jest problem z wyswietlaniem wielu elementow
	public List<MedicalTreatmentEntity> getMedicalTreatments() { return medicalTreatments; }
	public void setMedicalTreatments(List<MedicalTreatmentEntity> medicalTreatments) { this.medicalTreatments = medicalTreatments;	}

}
