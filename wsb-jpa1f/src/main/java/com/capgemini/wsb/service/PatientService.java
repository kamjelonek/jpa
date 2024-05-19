package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.entity.PatientEntity;

import java.util.List;

public interface PatientService
{
    public List<PatientTO> findAll();
    public PatientTO findById(final Long id);
    public List<PatientTO> findByFirstName(final String firstName);
    public List<PatientTO> findByLastName(final String lastName);

    public List<PatientTO> findByDodanaKolumna(final Long kolumna);
    public List<PatientTO> findByDodanaKolumnaMniejszaNiz(final Long kolumna);
    public List<PatientTO> findByDodanaKolumnaWiekszaNiz(final Long kolumna);

    public List<PatientTO> findPatientsWithMoreVisits(final Long x);

    PatientEntity savePatient(PatientEntity patient);
    void deletePatient(Long id);
}
