/**
 * Author: Shahbaz Ali
 * Email: shahbazkhaniq@gmail.com
 * Date: 2/27/2024$
 * Time: 11:18 PM$
 * Project Name: MomsDeliBackendCore$
 */


package com.momsdeli.online.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class UserDTO {
    private Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String password;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String role;

    @NotBlank
    @Pattern(regexp = "\\d{10}", message = "Mobile phone number must be 10 digits")
    private String mobilePhone;

    private List<AddressDTO> addressList;

    private List<PaymentInformationDTO> paymentInformations;

    private LocalDateTime createdAt;
}
