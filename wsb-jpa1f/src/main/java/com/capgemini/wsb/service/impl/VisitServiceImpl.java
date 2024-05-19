package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.mapper.VisitMapper;
import com.capgemini.wsb.persistence.dao.VisitDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class VisitServiceImpl implements VisitService
{
    private final VisitDao visitDao;

    @Autowired
    public VisitServiceImpl(VisitDao pVisitDao)
    {
        visitDao = pVisitDao;
    }


    @Override
    public List<VisitTO> findAll() {
        final List<VisitEntity> entities = visitDao.findAll();
        List<VisitTO> result = new ArrayList<>();

        for (VisitEntity visitEntity : entities) {
            result.add(VisitMapper.mapToTO(visitEntity));
        }
        return result.isEmpty() ? null : result;
    }


    @Override
    public VisitTO findById(Long id) {
        final VisitEntity entity = visitDao.findOne(id);
        return VisitMapper.mapToTO(entity);
    }


    @Override
    public List<VisitTO> findVisitsOfPatientById(Long id) {
        final List<VisitEntity> entities = visitDao.findAll();
        List<VisitTO> result = new ArrayList<>();

        for (VisitEntity visitEntity : entities) {
            if (visitEntity.getPatient().getId() == id) {
                result.add(VisitMapper.mapToTO(visitEntity));
            }
        }
        return result.isEmpty() ? null : result;
    }

    @Override
    public List<VisitTO> findPatientsVisits(Long visits) {
        //final List<VisitEntity> entities = visitDao.findAll();
        final List<VisitEntity> entities = visitDao.findPatientsVisits(visits);
        List<VisitTO> result = new ArrayList<>();

        for (VisitEntity visitEntity : entities) {
            //System.out.println("\n 1 findPatientsVisits = " + visitEntity.getPatient().getVisits().stream().distinct().count() + "\n");
            //if (visitEntity.getPatient().getVisits().stream().distinct().count() > visits) {
                result.add(VisitMapper.mapToTO(visitEntity));
            //}
        }
        return result.isEmpty() ? null : result;
    }


/*
    @Override
    public List<VisitTO> findPatientIdWithCount(Long visits) {
        //final List<VisitEntity> entities = visitDao.findAll();
        System.out.println("\n 1 visitEntityId = " + visits + "\n");
        final List<Long> entities = visitDao.findPatientIdWithCount(visits);
        List<VisitTO> result = new ArrayList<>();

        System.out.println("\n 2 List entities = " + entities + "\n");
        for (Long visitEntityId : entities) {
            //if (visitEntity.getPatient().getVisits().stream().distinct().count() > visits) {
                //result.add(VisitMapper.mapToTO(visitEntity));
            System.out.println("\n 2 visitEntityId = " + visitEntityId + "\n");
            //}
        }
        return result.isEmpty() ? null : result;
    }
*/

}
