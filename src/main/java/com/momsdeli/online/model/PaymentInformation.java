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

@Entity
@Table(name = "payment_information")
@Getter
@Setter
public class PaymentInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String cardholderName;
    private String cardNumber;
    private LocalDate expirationDate;
    private String cvv;
}
