package com.momsdeli.online.controller;

import com.momsdeli.online.request.AddressRequest;
import com.momsdeli.online.response.AddressResponse;
import com.momsdeli.online.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping
    public AddressResponse addAddress(@RequestBody AddressRequest request) {
        return addressService.addAddress(request);
    }

    @PutMapping("/{id}")
    public AddressResponse updateAddress(@PathVariable Long id, @RequestBody AddressRequest request) {
        return addressService.updateAddress(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Long id) {
        addressService.deleteAddress(id);
    }

    @GetMapping("/{id}")
    public AddressResponse getAddress(@PathVariable Long id) {
        return addressService.getAddressById(id);
    }

    @GetMapping
    public List<AddressResponse> getAllAddresses() {
        return addressService.getAllAddresses();
    }
}
