package com.capgemini.wsb.rest;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.rest.exception.EntityNotFoundException;
import com.capgemini.wsb.rest.exception.ValueNotFoundException;
import com.capgemini.wsb.service.PatientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientController
{

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }



    //@GetMapping("/patients")
    @GetMapping("/patient")
    List<PatientTO> findAll() {
        final List<PatientTO> patient = patientService.findAll();
        if(patient != null)
        {
            return patient;
        }
        throw new EntityNotFoundException(0L);
    }


    @GetMapping("/patient/{id}")
    PatientTO findById(@PathVariable final Long id) {
        final PatientTO patient = patientService.findById(id);
        if(patient != null)
        {
            return patient;
        }
        throw new EntityNotFoundException(id);
    }


    @GetMapping("/patient-firstname/{firstName}")
    List<PatientTO> findByFirstName(@PathVariable final String firstName) {

        final List<PatientTO> patient = patientService.findByFirstName(firstName);
        if(patient != null)
        {
            return patient;
        }
        throw new ValueNotFoundException(firstName);
    }


    @GetMapping("/patient-lastname/{lastName}")
    List<PatientTO> findByLastName(@PathVariable final String lastName) {

        final List<PatientTO> patient = patientService.findByLastName(lastName);
        if(patient != null)
        {
            return patient;
        }
        throw new ValueNotFoundException(lastName);
    }

    @GetMapping("/dodana-kolumna/{dodanaKolumna}")
    List<PatientTO> findByDodanaKolumna(@PathVariable final Long dodanaKolumna) {
        final List<PatientTO> patient = patientService.findByDodanaKolumna(dodanaKolumna);
        if(patient != null)
        {
            return patient;
        }
        throw new ValueNotFoundException(dodanaKolumna.toString());
    }


    @GetMapping("/dodana-kolumna-mniejsza-niz/{dodanaKolumna}")
    List<PatientTO> findByDodanaKolumnaMniejszaNiz(@PathVariable final Long dodanaKolumna) {
        final List<PatientTO> patient = patientService.findByDodanaKolumnaMniejszaNiz(dodanaKolumna);
        if(patient != null)
        {
            return patient;
        }
        throw new ValueNotFoundException(dodanaKolumna.toString());
    }

    @GetMapping("/dodana-kolumna-wieksza-niz/{dodanaKolumna}")
    List<PatientTO> findByDodanaKolumnaWiekszaNiz(@PathVariable final Long dodanaKolumna) {
        final List<PatientTO> patient = patientService.findByDodanaKolumnaWiekszaNiz(dodanaKolumna);
        if(patient != null)
        {
            return patient;
        }
        throw new ValueNotFoundException(dodanaKolumna.toString());
    }

    @GetMapping("/patients-with-more-visits/{x}")
    List<PatientTO> findPatientsWithMoreVisits(@PathVariable final Long x) {
        final List<PatientTO> patient = patientService.findPatientsWithMoreVisits(x);
        if(patient != null)
        {
            return patient;
        }
        throw new ValueNotFoundException(x.toString());
    }
}
