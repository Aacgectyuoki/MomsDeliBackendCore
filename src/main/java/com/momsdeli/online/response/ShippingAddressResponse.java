package com.momsdeli.online.response;

import lombok.Data;

/**
 * @author Shahbaz Khan
 * @date 16/08/2024
 */

@Data
public class ShippingAddressResponse {

    private Long id;

    private String street;

    private String city;

    private String state;

    private String postalCode;

    private String country;

    private OrderResponse order;
}
