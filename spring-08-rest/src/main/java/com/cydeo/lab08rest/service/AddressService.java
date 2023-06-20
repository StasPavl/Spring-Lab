package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.AddressDTO;

import java.util.List;

public interface AddressService {
    List<AddressDTO> getListOfAddress();
    AddressDTO save(AddressDTO addressDTO);
    AddressDTO update(AddressDTO addressDTO);
    List<AddressDTO> getAddressStartWith(String pattern);
    List<AddressDTO> getAddressByCustomerId(Long id);
    List<AddressDTO> getAddressByIdAndByName(Long id, String name);
}
