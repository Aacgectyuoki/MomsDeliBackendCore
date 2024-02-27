/**
 * Author: Shahbaz Ali
 * Email: shahbazkhaniq@gmail.com
 * Date: 2/27/2024$
 * Time: 11:14 PM$
 * Project Name: MomsDeliBackendCore$
 */


package com.momsdeli.online.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PaymentInformationDTO {

    private String cardholderName;
    private String cardNumber;
    private LocalDate expirationDate;
    private String cvv;
}
