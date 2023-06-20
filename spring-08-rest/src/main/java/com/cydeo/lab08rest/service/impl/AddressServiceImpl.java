package com.cydeo.lab08rest.service.impl;

import com.cydeo.lab08rest.dto.AddressDTO;
import com.cydeo.lab08rest.entity.Address;
import com.cydeo.lab08rest.entity.Customer;
import com.cydeo.lab08rest.mapper.MapperUtil;
import com.cydeo.lab08rest.repository.AddressRepository;
import com.cydeo.lab08rest.repository.CustomerRepository;
import com.cydeo.lab08rest.service.AddressService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final CustomerRepository customerRepository;
    private final MapperUtil mapperUtil;

    public AddressServiceImpl(AddressRepository addressRepository, CustomerRepository customerRepository, MapperUtil mapperUtil) {
        this.addressRepository = addressRepository;
        this.customerRepository = customerRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<AddressDTO> getListOfAddress() {
        return addressRepository.findAll().stream().map(address -> mapperUtil.convert(address,new AddressDTO())).collect(Collectors.toList());
    }

    @Override
    public AddressDTO save(AddressDTO addressDTO) {
        Address savedAddress = addressRepository.save(mapperUtil.convert(addressDTO, new Address()));
        return mapperUtil.convert(savedAddress, new AddressDTO());
    }

    @Override
    public AddressDTO update(AddressDTO addressDTO) {
        Address address = addressRepository.findById(addressDTO.getId()).orElseThrow(() -> new RuntimeException("Address not found"));
        Address savedAddress = addressRepository.save(mapperUtil.convert(addressDTO, new Address()));
        return mapperUtil.convert(savedAddress, new AddressDTO());
    }

    @Override
    public List<AddressDTO> getAddressStartWith(String pattern) {
        List<Address> listAddress = addressRepository.findAllByStreetStartingWith(pattern);
        return listAddress.stream().map(address -> mapperUtil.convert(address,new AddressDTO())).collect(Collectors.toList());
    }

    @Override
    public List<AddressDTO> getAddressByCustomerId(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        List<Address> address = addressRepository.findAllByCustomer(customer);

        return address.stream().map(address1 -> mapperUtil.convert(address1,new AddressDTO())).collect(Collectors.toList());
    }

    @Override
    public List<AddressDTO> getAddressByIdAndByName(Long id, String name) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
        List<Address> address = addressRepository.findAllByCustomerAndName(customer, name);

        return address.stream().map(address1 -> mapperUtil.convert(address1, new AddressDTO())).collect(Collectors.toList());
    }
}
