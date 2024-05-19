package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.VisitDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class VisitDaoImpl extends AbstractDao<VisitEntity, Long> implements VisitDao
{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<VisitEntity> findPatientsVisits(Long x) {
        return entityManager.createQuery("SELECT v FROM VisitEntity v WHERE v.patient.id IN (SELECT v.patient.id FROM VisitEntity v GROUP BY v.patient.id HAVING COUNT(v.patient.id) > :x)", VisitEntity.class)
                .setParameter("x", x)
                .getResultList();
    }

    // pomocnicza dla zrozumienia JPQL
    @Override
    public List<Long> findPatientIdWithCount(Long x) {
        return entityManager.createQuery("SELECT v.patient.id FROM VisitEntity v GROUP BY v.patient.id HAVING COUNT(v.patient.id) > :x", Long.class)
                .setParameter("x", x)
                .getResultList();
    }



}
