/**
 * Author: Shahbaz Ali
 * Email: shahbazkhaniq@gmail.com
 * Date: 2/27/2024$
 * Time: 11:12 PM$
 * Project Name: MomsDeliBackendCore$
 */


package com.momsdeli.online.dto;

import lombok.Data;

@Data
public class AddressDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNumber;

}
