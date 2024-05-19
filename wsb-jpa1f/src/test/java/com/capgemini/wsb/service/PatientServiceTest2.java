package com.capgemini.wsb.service;


import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.entity.AddressEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.service.impl.PatientServiceImpl;


import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.time.LocalDate;

public class PatientServiceTest2 {

    private PatientDao mockDao;
    private PatientService service;

    @Before
    public void setUp() {
        mockDao = mock(PatientDao.class);
        service = new PatientServiceImpl(mockDao);
    }

    @Test
    public void testFindPatientsByName() {
        String name = "Kowalski";
        AddressEntity addressEntity1 = new AddressEntity("line1", "line2","City1","55-555");

        List<PatientEntity> expectedPatients = Arrays.asList(new PatientEntity("Jan", "Kowalski", "123456789", "email@example.com","12345",LocalDate.of(1980, 1, 1),123L,addressEntity1));
        when(mockDao.findByLastName(name)).thenReturn(expectedPatients);

        List<PatientTO> result = service.findByLastName(name);

        verify(mockDao).findByLastName(name);
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertTrue(result.get(0).getLastName().contains(name));
    }

    @Test
    public void testFindPatientsWithMoreVisits() {
        Long visitsCount = 0L;

        AddressEntity addressEntity1 = new AddressEntity("line1", "line2","City1","55-555");
        AddressEntity addressEntity2 = new AddressEntity("line1", "line2","City2","44-444");
        AddressEntity addressEntity3 = new AddressEntity("line1", "line2","City3","33-333");

        List<PatientEntity> expectedPatients = Arrays.asList(
                new PatientEntity(
                        "Jan",
                        "Kowalski",
                        "123456789",
                        "email@example.com",
                        "12345",
                        LocalDate.of(1980, 1, 1),
                        123L,
                        addressEntity1),
                new PatientEntity(
                        "Jan",
                        "Kowalski",
                        "123456789",
                        "email@example.com",
                        "12345",
                        LocalDate.of(1980, 1, 1),
                        123L,
                        addressEntity1),
                new PatientEntity(
                        "Jan",
                        "Kowalski",
                        "123456789",
                        "email@example.com",
                        "12345",
                        LocalDate.of(1980, 1, 1),
                        123L,
                        addressEntity1)
        );
        when(mockDao.findPatientsWithMoreVisits(visitsCount)).thenReturn(expectedPatients);



        List<PatientTO> result = service.findPatientsWithMoreVisits(visitsCount);

        System.out.println("result.size() (powinno byc 3) = " + result.size());

        verify(mockDao).findPatientsWithMoreVisits(visitsCount);
        assertNotNull(result);
        assertFalse(result.isEmpty());

        System.out.println("Test");
        System.out.println("LastName = " + result.get(0).getLastName());
        System.out.println("Id = " + result.get(0).getId());
        //assertTrue(result.get(0).getId() > 0L);
    }

    @Test
    public void testSavePatient() {

        AddressEntity addressEntity1 = new AddressEntity("line1", "line2","City1","55-555");

        PatientEntity patient = new PatientEntity("Jan", "Kowalski", "123456789", "email@example.com","12345",LocalDate.of(1980, 1, 1),123L,addressEntity1);
        patient.setId(1L); // Zakładamy, że ID jest nadawane przez bazę danych po zapisie


        when(mockDao.save(patient)).thenReturn(patient);

        PatientEntity savedPatient = service.savePatient(patient);

        verify(mockDao).save(patient);
        assertNotNull(savedPatient);
        assertEquals(patient.getId(), savedPatient.getId());


        System.out.println("patient");
        System.out.println("LastName = " + patient.getLastName());
        System.out.println("Id = " + patient.getId());


        System.out.println("savedPatient");
        System.out.println("LastName = " + savedPatient.getLastName());
        System.out.println("Id = " + savedPatient.getId());


    }
}
