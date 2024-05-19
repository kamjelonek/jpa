package com.capgemini.wsb.service;

import static org.mockito.Mockito.*;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.service.impl.PatientServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientServiceImpl patientService;

    @Autowired
    private PatientDao patientDao;

    @Test
    public void testFindAll() {
        List<PatientTO> patients = patientService.findAll();
        assertNotNull(patients);
        assertFalse(patients.isEmpty());
    }

    @Test
    public void testFindById() {
        Long id = 1L; // Przykładowe ID
        PatientTO patient = patientService.findById(id);
        assertNotNull(patient);
        assertEquals(id, patient.getId());
    }

    @Test
    public void testFindByFirstName() {
        String name = "pACJENt"; // Przykładowe imię w bazie jes Pacjent
        List<PatientTO> patients = patientService.findByFirstName(name);
        assertNotNull(patients);
        assertFalse(patients.isEmpty());
        patients.forEach(patient -> assertTrue(patient.getFirstName().toLowerCase().contains(name.toLowerCase())));
    }

    @Test
    public void testFindByLastName() {
        String name = "W"; // Przykładowe nazwisko w bazie jest Dwa
        List<PatientTO> patients = patientService.findByLastName(name);
        assertNotNull(patients);
        assertFalse(patients.isEmpty());
        patients.forEach(patient -> assertTrue(patient.getLastName().toLowerCase().contains(name.toLowerCase())));
    }

    @Test
    public void testFindByDodanaKolumna() {
        Long dodanaKolumnaIn = 101L; // Przykładowa wartość w bazie sa 101,102, i 103
        List<PatientTO> patients = patientService.findByDodanaKolumna(dodanaKolumnaIn);
        assertNotNull(patients);
        assertFalse(patients.isEmpty());
        patients.forEach(patient -> assertEquals(dodanaKolumnaIn, patient.getDodanaKolumna()));
    }

    @Test
    public void testFindByDodanaKolumnaMniejszaNiz() {
        Long dodanaKolumnaIn = 110L; // Przykładowa wartość w bazie sa 101,102, i 103
        List<PatientTO> patients = patientService.findByDodanaKolumnaMniejszaNiz(dodanaKolumnaIn);
        assertNotNull(patients);
        assertFalse(patients.isEmpty());
        patients.forEach(patient -> assertTrue(patient.getDodanaKolumna() < dodanaKolumnaIn));
    }

    @Test
    public void testFindByDodanaKolumnaWiekszaNiz() {
        Long dodanaKolumnaIn = 1L; // Przykładowa wartość w bazie sa 101,102, i 103
        List<PatientTO> patients = patientService.findByDodanaKolumnaWiekszaNiz(dodanaKolumnaIn);
        assertNotNull(patients);
        assertFalse(patients.isEmpty());
        patients.forEach(patient -> assertTrue(patient.getDodanaKolumna() > dodanaKolumnaIn));
    }

    @Test
    public void testFindPatientsWithMoreVisits() {
        Long visitsCount = 1L; // Przykładowa liczba wizyt w bazie sa 1 pacjet z 1 wizyta i 2 pacjentow z dwoma wizytami
        List<PatientTO> patients = patientService.findPatientsWithMoreVisits(visitsCount);
        assertNotNull(patients);
        assertFalse(patients.isEmpty());
        //patients.forEach(patient -> assertTrue(patient.getVisits().size() > visitsCount));
    }





    @Test
    public void testFindAllPatients() {
        // utwórz pacjenta
        PatientEntity patient = new PatientEntity();
        patient.setFirstName("Jan");
        patient.setLastName("Kowalski");
        patient.setTelephoneNumber("123456789");
        patient.setEmail("jan.kowalski@example.com");
        patient.setPatientNumber("12345");
        patient.setDateOfBirth(LocalDate.of(1980, 1, 1));
        patient.setDodanaKolumna(123L);

        List<PatientTO> patients0 = patientService.findAll();
        int patientsCount = patients0.size();

        // zapisz pacjenta
        final PatientEntity savedPatient = patientDao.save(patient);

        // sprawdź, czy znaleziony pacjent jest taki sam jak zapisany
        Assertions.assertThat(savedPatient).isNotNull();
        Assertions.assertThat(savedPatient.getId()).isNotNull();

        // sprawdź, czy metoda findAll zwraca listę pacjentów
        List<PatientTO> patients = patientService.findAll();
        Assertions.assertThat(patients).isNotEmpty();
        Assertions.assertThat(patients.size()).isEqualTo(1 + patientsCount);

        // usuń pacjenta
        patientDao.delete(savedPatient.getId());

        // sprawdź, czy metoda findAll zwraca listę pacjentów
        patients = patientService.findAll();
        Assertions.assertThat(patients.size()).isEqualTo(patientsCount);
    }




/*

    @Test
    @Transactional
    public void testDeletePatient() {
        // utwórz pacjenta, lekarza i wizytę
        PatientEntity patient = createPatient();
        DoctorEntity doctor = createDoctor();
        VisitEntity visit = createVisit(patient, doctor);

        // usuń pacjenta
        patientRepository.delete(patient);

        // sprawdź, czy wizyty zostały usunięte
        VisitEntity deletedVisit = visitRepository.findById(visit.getId());
        assertNull(deletedVisit);

        // sprawdź, czy lekarze nie zostali usunięci
        DoctorEntity existingDoctor = doctorRepository.findById(doctor.getId());
        assertNotNull(existingDoctor);
    }
*/






}
