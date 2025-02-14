package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.mapper.DoctorMapper;
import com.capgemini.wsb.persistence.dao.DoctorDao;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class DoctorServiceImpl implements DoctorService
{
    private final DoctorDao doctorDao;

    @Autowired
    public DoctorServiceImpl(DoctorDao pDoctorDao)
    {
        doctorDao = pDoctorDao;
    }


    @Override
    public List<DoctorTO> findAll() {
        final List<DoctorEntity> entities = doctorDao.findAll();
        List<DoctorTO> result = new ArrayList<>();

        for (DoctorEntity doctorEntity : entities) {
            result.add(DoctorMapper.mapToTO(doctorEntity));
        }
        return result.isEmpty() ? null : result;
    }

    @Override
    public DoctorTO findById(Long id) {
        final DoctorEntity entity = doctorDao.findOne(id);
        return DoctorMapper.mapToTO(entity);
    }
}
