package com.momsdeli.online.request;

import lombok.Data;

/**
 * @author Shahbaz Khan
 * @date 16/08/2024
 */

@Data
public class ShippingAddressRequest {

    private String street;

    private String city;

    private String state;

    private String postalCode;

    private String country;

    private Long orderId;
}
