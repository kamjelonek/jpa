package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.MedicalTreatmentTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.mapper.MedicalTreatmentMapper;
import com.capgemini.wsb.mapper.VisitMapper;
import com.capgemini.wsb.persistence.dao.MedicalTreatmentDao;
import com.capgemini.wsb.persistence.entity.MedicalTreatmentEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.service.MedicalTreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class MedicalTreatmentServiceImpl implements MedicalTreatmentService
{
    private final MedicalTreatmentDao medicalTreatmentDao;

    @Autowired
    public MedicalTreatmentServiceImpl(MedicalTreatmentDao pMedicalTreatmentDao)
    {
        medicalTreatmentDao = pMedicalTreatmentDao;
    }


    @Override
    public List<MedicalTreatmentTO> findAll() {
        final List<MedicalTreatmentEntity> entities = medicalTreatmentDao.findAll();
        List<MedicalTreatmentTO> result = new ArrayList<>();

        for (MedicalTreatmentEntity medicalTreatmentEntity : entities) {
            result.add(MedicalTreatmentMapper.mapToTO(medicalTreatmentEntity));
        }
        return result.isEmpty() ? null : result;
    }

    @Override
    public MedicalTreatmentTO findById(Long id) {
        final MedicalTreatmentEntity entity = medicalTreatmentDao.findOne(id);
        return MedicalTreatmentMapper.mapToTO(entity);
    }
}
