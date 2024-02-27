/**
 * Author: Shahbaz Ali
 * Email: shahbazkhaniq@gmail.com
 * Date: 2/27/2024$
 * Time: 7:48 PM$
 * Project Name: MomsDeliBackendCore$
 */


package com.momsdeli.online.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Embeddable
@Getter
@Setter
public class PaymentInformation {

    private String cardholderName;

    private String cardNumber;

    private LocalDate expirationDate;

    private String cvv;


}
