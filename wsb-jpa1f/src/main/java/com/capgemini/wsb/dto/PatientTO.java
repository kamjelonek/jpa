package com.capgemini.wsb.dto;

import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.persistence.entity.AddressEntity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PatientTO implements Serializable
{
    private Long id;
    private String firstName;
    private String lastName;
    private String telephoneNumber;
    private String email;
    private String patientNumber;
    private LocalDate dateOfBirth;
    private Long dodanaKolumna;
    private AddressEntity address;
    //private List<VisitEntity> visits = new ArrayList<>();


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFirstName() {
        return this.firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getTelephoneNumber() { return this.telephoneNumber; }
    public void setTelephoneNumber(String telephoneNumber) { this.telephoneNumber = telephoneNumber; }
    public String getEmail() { return this.email; }
    public void setEmail(String email) { this.email = email; }
    public String getPatientNumber() {
        return patientNumber;
    }
    public void setPatientNumber(String patientNumber) { this.patientNumber = patientNumber; }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }




    public Long getDodanaKolumna() {
        return dodanaKolumna;
    }
    public void setDodanaKolumna(Long dodanaKolumna) {
        this.dodanaKolumna = dodanaKolumna;
    }

    public AddressEntity getAddress() { return address; }
    public void setAddress(AddressEntity address) {
        this.address = address;
    }



    //public List<VisitEntity> getVisits() { return visits; }
    //public void setVisits(List<VisitEntity> visits) { this.visits = visits; }



}
