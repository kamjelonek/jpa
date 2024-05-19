package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.DoctorTO;

import java.util.List;

public interface DoctorService
{
    public List<DoctorTO> findAll();
    public DoctorTO findById(final Long id);
}
