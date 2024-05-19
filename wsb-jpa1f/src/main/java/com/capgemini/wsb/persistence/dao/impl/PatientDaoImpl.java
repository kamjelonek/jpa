package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao
{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<PatientEntity> findByDodanaKolumna(Long dodanaKolumnaIn) {
        return entityManager.createQuery("SELECT p FROM PatientEntity p WHERE p.dodanaKolumna = :dodanaKolumnaIn", PatientEntity.class)
                .setParameter("dodanaKolumnaIn", dodanaKolumnaIn)
                .getResultList();
    }


    @Override
    public List<PatientEntity> findByDodanaKolumnaMniejszaNiz(Long dodanaKolumnaIn) {
        return entityManager.createQuery("SELECT p FROM PatientEntity p WHERE p.dodanaKolumna < :dodanaKolumnaIn", PatientEntity.class)
                .setParameter("dodanaKolumnaIn", dodanaKolumnaIn)
                .getResultList();
    }

    @Override
    public List<PatientEntity> findByDodanaKolumnaWiekszaNiz(Long dodanaKolumnaIn) {
        return entityManager.createQuery("SELECT p FROM PatientEntity p WHERE p.dodanaKolumna > :dodanaKolumnaIn", PatientEntity.class)
                .setParameter("dodanaKolumnaIn", dodanaKolumnaIn)
                .getResultList();
    }



    @Override
    public List<PatientEntity> findByFirstName(String name) {
        return entityManager.createQuery("SELECT p FROM PatientEntity p WHERE LOWER(p.firstName) LIKE LOWER(:name)", PatientEntity.class)
                .setParameter("name", "%" + name + "%")
                .getResultList();
    }

    @Override
    public List<PatientEntity> findByLastName(String name) {
        return entityManager.createQuery("SELECT p FROM PatientEntity p WHERE LOWER(p.lastName) LIKE LOWER(:name)", PatientEntity.class)
                .setParameter("name", "%" + name + "%")
                .getResultList();
    }



    public List<PatientEntity> findPatientsWithMoreVisits(Long x) {
        return entityManager.createQuery(
                        "SELECT p FROM PatientEntity p WHERE p.id IN (" +
                                "SELECT v.patient.id FROM VisitEntity v GROUP BY v.patient.id HAVING COUNT(v.patient.id) > :x" +
                                ")", PatientEntity.class)
                .setParameter("x", x)
                .getResultList();
    }


}
