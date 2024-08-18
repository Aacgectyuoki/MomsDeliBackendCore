package com.momsdeli.online.service;

import com.momsdeli.online.dto.ShippingAddressDTO;
import com.momsdeli.online.mapper.ShippingAddressMapper;
import com.momsdeli.online.model.ShippingAddress;
import com.momsdeli.online.repository.ShippingAddressRepository;
import com.momsdeli.online.request.ShippingAddressRequest;
import com.momsdeli.online.response.ShippingAddressResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShippingAddressService {

    @Autowired
    private ShippingAddressRepository shippingAddressRepository;

    @Autowired
    private ShippingAddressMapper shippingAddressMapper;

    public ShippingAddressResponse addShippingAddress(ShippingAddressRequest request) {
        ShippingAddress shippingAddress = shippingAddressMapper.requestToShippingAddress(request);
        shippingAddress = shippingAddressRepository.save(shippingAddress);
        return shippingAddressMapper.shippingAddressToResponse(shippingAddress);
    }

    public ShippingAddressResponse updateShippingAddress(Long id, ShippingAddressRequest request) {
        ShippingAddress shippingAddress = shippingAddressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shipping Address not found"));
        shippingAddressMapper.updateShippingAddressFromDTO(request, shippingAddress);
        shippingAddress = shippingAddressRepository.save(shippingAddress);
        return shippingAddressMapper.shippingAddressToResponse(shippingAddress);
    }

    public void deleteShippingAddress(Long id) {
        shippingAddressRepository.deleteById(id);
    }

    public ShippingAddressResponse getShippingAddressById(Long id) {
        ShippingAddress shippingAddress = shippingAddressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shipping Address not found"));
        return shippingAddressMapper.shippingAddressToResponse(shippingAddress);
    }

    public List<ShippingAddressResponse> getAllShippingAddresses() {
        return shippingAddressRepository.findAll().stream()
                .map(shippingAddressMapper::shippingAddressToResponse)
                .collect(Collectors.toList());
    }
}
