package com.momsdeli.online.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ShippingAddressDTO {

    @JsonProperty("id")
    private Long id;

    @NotBlank(message = "Street is mandatory")
    @JsonProperty("street")
    private String street;

    @NotBlank(message = "City is mandatory")
    @JsonProperty("city")
    private String city;

    @NotBlank(message = "State is mandatory")
    @JsonProperty("state")
    private String state;

    @NotBlank(message = "Postal code is mandatory")
    @JsonProperty("postal_code")
    private String postalCode;

    @NotBlank(message = "Country is mandatory")
    @JsonProperty("country")
    private String country;

    @NotNull(message = "Order is mandatory")
    @JsonProperty("order")
    private OrderDTO order;
}
