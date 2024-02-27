/**
 * Author: Shahbaz Ali
 * Email: shahbazkhaniq@gmail.com
 * Date: 2/27/2024$
 * Time: 11:55 PM$
 * Project Name: MomsDeliBackendCore$
 */


package com.momsdeli.online.mapper;

import com.momsdeli.online.dto.PaymentInformationDTO;
import com.momsdeli.online.model.PaymentInformation;

public class PaymentInformationMapper {

    public static PaymentInformationDTO toDTO(PaymentInformation paymentInformation) {
        PaymentInformationDTO dto = new PaymentInformationDTO();
        dto.setCardholderName(paymentInformation.getCardholderName());
        dto.setCardNumber(paymentInformation.getCardNumber());
        dto.setExpirationDate(paymentInformation.getExpirationDate());
        dto.setCvv(paymentInformation.getCvv());
        return dto;
    }

    public static PaymentInformation toEntity(PaymentInformationDTO dto) {
        PaymentInformation paymentInformation = new PaymentInformation();
        paymentInformation.setCardholderName(dto.getCardholderName());
        paymentInformation.setCardNumber(dto.getCardNumber());
        paymentInformation.setExpirationDate(dto.getExpirationDate());
        paymentInformation.setCvv(dto.getCvv());
        return paymentInformation;
    }
}
