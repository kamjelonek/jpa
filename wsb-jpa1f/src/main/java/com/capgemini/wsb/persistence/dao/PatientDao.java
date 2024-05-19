package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientDao extends Dao<PatientEntity, Long>
{

    //@Query("SELECT p FROM PatientEntity p WHERE p.dodanaKolumna = :dodanaKolumnaIn")
    List<PatientEntity> findByDodanaKolumna(@Param("dodanaKolumnaIn") Long dodanaKolumnaIn);

    //@Query("SELECT p FROM PatientEntity p WHERE p.dodanaKolumna < :dodanaKolumnaIn")
    List<PatientEntity> findByDodanaKolumnaMniejszaNiz(@Param("dodanaKolumnaIn") Long dodanaKolumnaIn);

    //@Query("SELECT p FROM PatientEntity p WHERE p.dodanaKolumna > :dodanaKolumnaIn")
    List<PatientEntity> findByDodanaKolumnaWiekszaNiz(@Param("dodanaKolumnaIn") Long dodanaKolumnaIn);


    //@Query("SELECT p FROM PatientEntity p WHERE LOWER(p.firstName) LIKE LOWER(%:name%)")
    List<PatientEntity> findByFirstName(@Param("name") String name);

    //@Query("SELECT p FROM PatientEntity p WHERE LOWER(p.lastName) LIKE LOWER(%:name%)")
    List<PatientEntity> findByLastName(@Param("name") String name);

    //@Query("SELECT p FROM PatientEntity p WHERE p.id IN (" + "SELECT v.patient.id FROM VisitEntity v GROUP BY v.patient.id HAVING COUNT(v.patient.id) > :x")
    List<PatientEntity> findPatientsWithMoreVisits(Long x);

}
