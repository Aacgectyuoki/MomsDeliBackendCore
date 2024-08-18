package com.momsdeli.online.controller;

import com.momsdeli.online.request.ShippingAddressRequest;
import com.momsdeli.online.response.ShippingAddressResponse;
import com.momsdeli.online.service.ShippingAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shipping-addresses")
public class ShippingAddressController {

    @Autowired
    private ShippingAddressService shippingAddressService;

    @PostMapping
    public ShippingAddressResponse addShippingAddress(@RequestBody ShippingAddressRequest request) {
        return shippingAddressService.addShippingAddress(request);
    }

    @PutMapping("/{id}")
    public ShippingAddressResponse updateShippingAddress(@PathVariable Long id, @RequestBody ShippingAddressRequest request) {
        return shippingAddressService.updateShippingAddress(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteShippingAddress(@PathVariable Long id) {
        shippingAddressService.deleteShippingAddress(id);
    }

    @GetMapping("/{id}")
    public ShippingAddressResponse getShippingAddress(@PathVariable Long id) {
        return shippingAddressService.getShippingAddressById(id);
    }

    @GetMapping
    public List<ShippingAddressResponse> getAllShippingAddresses() {
        return shippingAddressService.getAllShippingAddresses();
    }
}
