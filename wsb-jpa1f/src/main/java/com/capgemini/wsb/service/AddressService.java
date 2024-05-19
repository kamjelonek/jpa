package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.AddressTO;

import java.util.List;

public interface AddressService
{
    public List<AddressTO> findAll();
    public AddressTO findById(final Long id);
}
