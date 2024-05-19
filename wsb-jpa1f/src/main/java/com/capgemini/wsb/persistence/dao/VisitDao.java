package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VisitDao extends Dao<VisitEntity, Long>
{
    //@Query("SELECT v FROM VisitEntity v WHERE v.patient.id IN (SELECT v.patient.id FROM VisitEntity v GROUP BY v.patient.id HAVING COUNT(v.patient.id) > :x)"
    List<VisitEntity> findPatientsVisits(@Param("x") Long x);

    //@Query("SELECT v.patient.id FROM VisitEntity v GROUP BY v.patient.id HAVING COUNT(v.patient.id) = :x")
    List<Long> findPatientIdWithCount(@Param("x") Long x);


}
