package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.service.impl.VisitServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class VisitServiceTest {

    @Autowired
    private VisitServiceImpl visitService;

    @Test
    public void testFindAll() {
        List<VisitTO> visits = visitService.findAll();
        assertNotNull(visits);
        assertFalse(visits.isEmpty());
    }

    @Test
    public void testFindById() {
        Long id = 1L; // Przykładowe ID
        VisitTO visit = visitService.findById(id);
        assertNotNull(visit);
        assertEquals(id, visit.getId());
    }

    @Test
    public void testFindVisitsOfPatientById() {
        Long id = 1L; // Przykładowe ID pacjenta
        List<VisitTO> visits = visitService.findVisitsOfPatientById(id);
        assertNotNull(visits);
        assertFalse(visits.isEmpty());
        visits.forEach(visit -> assertEquals(id, visit.getPatient().getId()));
    }

    @Test
    public void testFindPatientsVisits() {
        Long visitsCount = 0L; // Przykładowa liczba wizyt
        List<VisitTO> visits = visitService.findPatientsVisits(visitsCount);
        assertNotNull(visits);
        assertFalse(visits.isEmpty());

        Long visitsCount2 = 1000000000000L;
        List<VisitTO> visits2 = visitService.findPatientsVisits(visitsCount2);
        assertNull(visits2);
    }
}
