package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.dao.PatientDao;

import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

//@DataJpaTest
@SpringBootTest
public class PatientDaoTest
{

    @Autowired
    private PatientDao patientDao;



    @Test
    public void testfindByDodanaKolumna() {
        Long dodanaKolumna = 101L;
        List<PatientEntity> patients = patientDao.findByDodanaKolumna(dodanaKolumna);
        assertNotNull(patients);
        assertFalse(patients.isEmpty());
        patients.forEach(patient -> assertEquals(dodanaKolumna, patient.getDodanaKolumna()));
    }


    @Test
    public void testfindByDodanaKolumnaMniejszaNiz() {
        Long dodanaKolumna = 103L;
        List<PatientEntity> patients = patientDao.findByDodanaKolumnaMniejszaNiz(dodanaKolumna);
        assertNotNull(patients);
        assertFalse(patients.isEmpty());
        patients.forEach(patient -> assertTrue(patient.getDodanaKolumna() < dodanaKolumna));
    }


    @Test
    public void testfindByDodanaKolumnaWiekszaNiz() {
        Long dodanaKolumna = 10L;
        List<PatientEntity> patients = patientDao.findByDodanaKolumnaWiekszaNiz(dodanaKolumna);
        assertNotNull(patients);
        assertFalse(patients.isEmpty());
        patients.forEach(patient -> assertTrue(patient.getDodanaKolumna() > dodanaKolumna));
    }




    @Test
    public void testFindByFirstName() {
        String name = "Pacjent2";
        List<PatientEntity> patients = patientDao.findByFirstName(name);
        assertNotNull(patients);
        assertFalse(patients.isEmpty());
        patients.forEach(patient -> assertTrue(patient.getFirstName().toLowerCase().contains(name.toLowerCase())));
    }

    @Test
    public void testFindByLastName() {
        String name = "Trzy";
        List<PatientEntity> patients = patientDao.findByLastName(name);
        assertNotNull(patients);
        assertFalse(patients.isEmpty());
        patients.forEach(patient -> assertTrue(patient.getLastName().toLowerCase().contains(name.toLowerCase())));
    }


    @Test
    public void testfindPatientsWithMoreVisits() {
        Long x = 0L;
        List<PatientEntity> patients = patientDao.findPatientsWithMoreVisits(x);
        assertNotNull(patients);
        assertFalse(patients.isEmpty());
        patients.forEach(patient -> assertTrue(patient.getId() > 0));

        Long x2 = 1000000000000L;
        List<PatientEntity> patients2 = patientDao.findPatientsWithMoreVisits(x2);
        assertTrue(patients2.isEmpty());
    }



    @Test
    public void testfindByDodanaKolumna2() {
        Long dodanaKolumna = 101L;
        //List<PatientEntity> patients = patientDao.findByDodanaKolumna(dodanaKolumna);
        List<PatientEntity> patients = patientDao.findByDodanaKolumna(dodanaKolumna);
        assertNotNull(patients);
        assertFalse(patients.isEmpty());
        patients.forEach(patient -> assertEquals(dodanaKolumna, patient.getDodanaKolumna()));
    }



    @Test
    public void testSaveAndFindPatient() {
        // utwórz pacjenta
        PatientEntity patient = new PatientEntity();
        patient.setFirstName("Jan");
        patient.setLastName("Kowalski");
        patient.setTelephoneNumber("123456789");
        patient.setEmail("jan.kowalski@example.com");
        patient.setPatientNumber("12345");
        patient.setDateOfBirth(LocalDate.of(1980, 1, 1));
        patient.setDodanaKolumna(123L);
        long entitiesNumBefore = patientDao.count();

        // zapisz pacjenta
        final PatientEntity saved = patientDao.save(patient);

        // sprawdź, czy znaleziony pacjent jest taki sam jak zapisany
        Assertions.assertThat(saved).isNotNull();
        Assertions.assertThat(saved.getId()).isNotNull();
        Assertions.assertThat(patientDao.count()).isEqualTo(entitiesNumBefore+1);
    }



}
