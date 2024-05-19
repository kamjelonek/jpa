package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.stream.Collectors;

import java.util.List;


@Service
@Transactional
public class PatientServiceImpl implements PatientService
{
    private final PatientDao patientDao;

    @Autowired
    public PatientServiceImpl(PatientDao pPatientDao)
    {
        patientDao = pPatientDao;
    }


    @Override
    public List<PatientTO> findAll() {
        final List<PatientEntity> entities = patientDao.findAll();
        List<PatientTO> result = new ArrayList<>();

        for (PatientEntity patientEntity : entities) {
            result.add(PatientMapper.mapToTO(patientEntity));
        }
        return result;
    }


    @Override
    public PatientTO findById(Long id) {
        final PatientEntity entity = patientDao.findOne(id);
        return PatientMapper.mapToTO(entity);
    }

    @Override
    public List<PatientTO> findByFirstName(String name) {
        //final List<PatientEntity> entities = patientDao.findAll();
        final List<PatientEntity> entities = patientDao.findByFirstName(name);
        List<PatientTO> result = new ArrayList<>();

        for (PatientEntity patientEntity : entities) {
            //if (patientEntity.getFirstName().toLowerCase().contains(name.toLowerCase())) {
                result.add(PatientMapper.mapToTO(patientEntity));
            //}
        }
        return result.isEmpty() ? null : result;
    }

    @Override
    public List<PatientTO> findByLastName(String name) {
        //final List<PatientEntity> entities = patientDao.findAll();
        final List<PatientEntity> entities = patientDao.findByLastName(name);
        List<PatientTO> result = new ArrayList<>();

        for (PatientEntity patientEntity : entities){
            //if (patientEntity.getLastName().toLowerCase().contains(name.toLowerCase())) {
                result.add(PatientMapper.mapToTO(patientEntity));
            //}
        }
        return result.isEmpty() ? null : result;
    }

    @Override
    public List<PatientTO> findByDodanaKolumna(final Long dodanaKolumnaIn) {
        //final List<PatientEntity> entities = patientDao.findAll();
        final List<PatientEntity> entities = patientDao.findByDodanaKolumna(dodanaKolumnaIn);
        List<PatientTO> result = new ArrayList<>();

        for (PatientEntity patientEntity : entities) {
                //if (patientEntity.getDodanaKolumna() == dodanaKolumnaIn) {
                result.add(PatientMapper.mapToTO(patientEntity));
            //}
        }
        return result.isEmpty() ? null : result;
    }


    @Override
    public List<PatientTO> findByDodanaKolumnaMniejszaNiz(final Long dodanaKolumnaIn) {
        //final List<PatientEntity> entities = patientDao.findAll();
        final List<PatientEntity> entities = patientDao.findByDodanaKolumnaMniejszaNiz(dodanaKolumnaIn);
        List<PatientTO> result = new ArrayList<>();

        for (PatientEntity patientEntity : entities) {
            //if (patientEntity.getDodanaKolumna() < dodanaKolumnaIn) {
                result.add(PatientMapper.mapToTO(patientEntity));
            //}
        }
        return result.isEmpty() ? null : result;
    }


    @Override
    public List<PatientTO> findByDodanaKolumnaWiekszaNiz(final Long dodanaKolumnaIn) {
        //final List<PatientEntity> entities = patientDao.findAll();
        final List<PatientEntity> entities = patientDao.findByDodanaKolumnaWiekszaNiz(dodanaKolumnaIn);
        List<PatientTO> result = new ArrayList<>();

        for (PatientEntity patientEntity : entities) {
            //if (patientEntity.getDodanaKolumna() > dodanaKolumnaIn) {
                result.add(PatientMapper.mapToTO(patientEntity));
            //}
        }
        return result.isEmpty() ? null : result;
    }


    @Override
    public List<PatientTO> findPatientsWithMoreVisits(final Long x) {
        final List<PatientEntity> entities = patientDao.findPatientsWithMoreVisits(x);
        List<PatientTO> result = new ArrayList<>();

        for (PatientEntity patientEntity : entities) {
                    result.add(PatientMapper.mapToTO(patientEntity));
                }
        return result.isEmpty() ? null : result;
    }

    @Override
    public PatientEntity savePatient(PatientEntity patient) {
        return patientDao.save(patient);
    }

    @Override
    public void deletePatient(Long id) {
        patientDao.delete(id);

    }


}
