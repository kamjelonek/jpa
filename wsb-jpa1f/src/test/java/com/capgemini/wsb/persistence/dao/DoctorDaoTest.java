package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.dao.PatientDao;

import com.capgemini.wsb.persistence.entity.DoctorEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static com.capgemini.wsb.persistence.enums.Specialization.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

//@DataJpaTest
@SpringBootTest
public class DoctorDaoTest
{

    @Autowired
    private DoctorDao doctorDao;


    @Test
    public void testSaveAndFindDoctor() {
        // utwórz doktora
        DoctorEntity doctor = new DoctorEntity();
        doctor.setFirstName("Jan");
        doctor.setLastName("Kowalski");
        doctor.setTelephoneNumber("123456789");
        doctor.setEmail("jan.kowalski@example.com");
        doctor.setDoctorNumber("12345");
        doctor.setSpecialization(GP);

        long entitiesNumBefore = doctorDao.count();

        // zapisz doktora
        final DoctorEntity saved = doctorDao.save(doctor);

        // sprawdź, czy znaleziony doktor jest taki sam jak zapisany
        Assertions.assertThat(saved).isNotNull();
        Assertions.assertThat(saved.getId()).isNotNull();
        Assertions.assertThat(doctorDao.count()).isEqualTo(entitiesNumBefore+1);
    }



}
