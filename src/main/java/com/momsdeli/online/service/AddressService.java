package com.momsdeli.online.service;

import com.momsdeli.online.dto.AddressDTO;
import com.momsdeli.online.mapper.AddressMapper;
import com.momsdeli.online.model.Address;
import com.momsdeli.online.repository.AddressRepository;
import com.momsdeli.online.request.AddressRequest;
import com.momsdeli.online.response.AddressResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressMapper addressMapper;

    public AddressResponse addAddress(AddressRequest request) {
        Address address = addressMapper.requestToAddress(request);
        address = addressRepository.save(address);
        return addressMapper.addressToResponse(address);
    }

    public AddressResponse updateAddress(Long id, AddressRequest request) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found"));
        addressMapper.updateAddressFromDTO(request, address);
        address = addressRepository.save(address);
        return addressMapper.addressToResponse(address);
    }

    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }

    public AddressResponse getAddressById(Long id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found"));
        return addressMapper.addressToResponse(address);
    }

    public List<AddressResponse> getAllAddresses() {
        return addressRepository.findAll().stream()
                .map(addressMapper::addressToResponse)
                .collect(Collectors.toList());
    }
}
