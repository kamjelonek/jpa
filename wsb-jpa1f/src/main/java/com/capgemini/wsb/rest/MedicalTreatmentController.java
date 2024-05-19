package com.capgemini.wsb.rest;

import com.capgemini.wsb.dto.MedicalTreatmentTO;
import com.capgemini.wsb.rest.exception.EntityNotFoundException;
import com.capgemini.wsb.service.MedicalTreatmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MedicalTreatmentController
{

    private final MedicalTreatmentService medicalTreatmentService;


    public MedicalTreatmentController(MedicalTreatmentService medicalTreatmentService) {
        this.medicalTreatmentService = medicalTreatmentService;
    }


    //@GetMapping("/medicaltreatments")
    @GetMapping("/medicaltreatment")
    List<MedicalTreatmentTO> findAll() {
        final List<MedicalTreatmentTO> medicalTreatments = medicalTreatmentService.findAll();
        if(medicalTreatments != null)
        {
            return medicalTreatments;
        }
        throw new EntityNotFoundException(0L);
    }


    @GetMapping("/medicaltreatment/{id}")
    MedicalTreatmentTO findById(@PathVariable final Long id) {
        final MedicalTreatmentTO medicalTreatment = medicalTreatmentService.findById(id);
        if(medicalTreatment != null)
        {
            return medicalTreatment;
        }
        throw new EntityNotFoundException(id);
    }
}
