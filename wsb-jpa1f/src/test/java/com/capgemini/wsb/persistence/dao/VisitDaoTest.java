package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.dao.VisitDao;

import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static com.capgemini.wsb.persistence.enums.Specialization.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

//@DataJpaTest
@SpringBootTest
public class VisitDaoTest
{

    @Autowired
    private VisitDao visitDao;

    @Autowired
    private DoctorDao doctorDao;

    @Autowired
    private PatientDao patientDao;


    @Test
    public void testSaveAndFindAndDeleteVisit() {

        // utwórz pacjenta
        PatientEntity patient = new PatientEntity();
        patient.setFirstName("Jan");
        patient.setLastName("Kowalski");
        patient.setTelephoneNumber("123456789");
        patient.setEmail("jan.kowalski@example.com");
        patient.setPatientNumber("12345");
        patient.setDateOfBirth(LocalDate.of(1980, 1, 1));
        patient.setDodanaKolumna(123L);
        long entitiesNumBeforePatient = patientDao.count();

        // zapisz pacjenta
        final PatientEntity savedPatient = patientDao.save(patient);

        // sprawdź, czy znaleziony pacjent jest taki sam jak zapisany
        Assertions.assertThat(savedPatient).isNotNull();
        Assertions.assertThat(savedPatient.getId()).isNotNull();
        Assertions.assertThat(patientDao.count()).isEqualTo(entitiesNumBeforePatient+1);

        Long visitPatient = savedPatient.getId();


        // utwórz doktora
        DoctorEntity doctor = new DoctorEntity();
        doctor.setFirstName("Jan");
        doctor.setLastName("Kowalski");
        doctor.setTelephoneNumber("123456789");
        doctor.setEmail("jan.kowalski@example.com");
        doctor.setDoctorNumber("12345");
        doctor.setSpecialization(GP);

        long entitiesNumBeforeDoctor = doctorDao.count();

        // zapisz doktora
        final DoctorEntity savedDoctor = doctorDao.save(doctor);

        // sprawdź, czy znaleziony doktor jest taki sam jak zapisany
        Assertions.assertThat(savedDoctor).isNotNull();
        Assertions.assertThat(savedDoctor.getId()).isNotNull();
        Assertions.assertThat(doctorDao.count()).isEqualTo(entitiesNumBeforeDoctor+1);

        Long visitDoctor = savedDoctor.getId();


        // utwórz wizyte
        VisitEntity visit = new VisitEntity();
        visit.setDescription("Opis wizyty 1");
        visit.setTime(LocalDateTime.of(2024, 4, 15, 12,30,15));
        visit.setPatient(savedPatient);
        visit.setDoctor(savedDoctor);

        long entitiesNumBefore = visitDao.count();

        // zapisz wizyte
        final VisitEntity saved = visitDao.save(visit);

        // sprawdź, czy znaleziona wizyta jest taka sama jak zapisana
        Assertions.assertThat(saved).isNotNull();
        Assertions.assertThat(saved.getId()).isNotNull();
        Assertions.assertThat(visitDao.count()).isEqualTo(entitiesNumBefore+1);

        Long visitId = saved.getId();

        try {
            doctorDao.delete(savedDoctor.getId());
        } catch (Exception ex) { }
        Assertions.assertThat(doctorDao.count()).isEqualTo(entitiesNumBeforeDoctor+1);

        // Kaskadowe usuniecie encji Visits
        try {
            patientDao.delete(savedPatient.getId());
        } catch (Exception ex) { }
        Assertions.assertThat(patientDao.count()).isEqualTo(entitiesNumBeforePatient);


        //visitDao.delete(saved.getId());
        Assertions.assertThat(visitDao.count()).isEqualTo(entitiesNumBefore);

        doctorDao.delete(savedDoctor.getId());
        Assertions.assertThat(doctorDao.count()).isEqualTo(entitiesNumBeforeDoctor);

        //patientDao.delete(savedPatient.getId());
        Assertions.assertThat(patientDao.count()).isEqualTo(entitiesNumBeforePatient);

    }



}
