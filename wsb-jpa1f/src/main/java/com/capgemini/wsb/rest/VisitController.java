package com.capgemini.wsb.rest;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.rest.exception.EntityNotFoundException;
import com.capgemini.wsb.rest.exception.ValueNotFoundException;
import com.capgemini.wsb.service.VisitService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VisitController
{

    private final VisitService visitService;


    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    //@GetMapping("/visits")
    @GetMapping("/visit")
    List<VisitTO> findAll() {
        final List<VisitTO> visit = visitService.findAll();
        if(visit != null)
        {
            return visit;
        }
        throw new EntityNotFoundException(0L);
    }



    @GetMapping("/visit/{id}")
    VisitTO findById(@PathVariable final Long id) {
        final VisitTO visit = visitService.findById(id);
        if(visit != null)
        {
            return visit;
        }
        throw new EntityNotFoundException(id);
    }

    @GetMapping("/visits-of-patient-by-id/{Id}")
    List<VisitTO> findVisitsOfPatientById(@PathVariable final Long Id) {
        final List<VisitTO> patient = visitService.findVisitsOfPatientById(Id);
        if(patient != null)
        {
            return patient;
        }
        throw new ValueNotFoundException(Id.toString());
    }


    @GetMapping("/patients-visits/{visits}")
    List<VisitTO> findPatientsVisits(@PathVariable final Long visits) {
        final List<VisitTO> patient = visitService.findPatientsVisits(visits);
        if(patient != null)
        {
            return patient;
        }
        throw new ValueNotFoundException(visits.toString());
    }


}
