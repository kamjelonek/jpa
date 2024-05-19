package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.MedicalTreatmentTO;

import java.util.List;

public interface MedicalTreatmentService
{
    public List<MedicalTreatmentTO> findAll();
    public MedicalTreatmentTO findById(final Long id);
}
