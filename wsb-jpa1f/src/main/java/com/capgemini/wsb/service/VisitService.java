package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;

import java.util.List;

public interface VisitService
{
    public List<VisitTO> findAll();
    public VisitTO findById(final Long id);
    public List<VisitTO> findVisitsOfPatientById(final Long id);

    public List<VisitTO> findPatientsVisits(final Long visits);
    //public List<VisitTO> findPatientIdWithCount(final Long visits);
}
