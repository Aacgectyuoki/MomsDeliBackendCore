package com.momsdeli.online.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */

@Data
public class OrderRequest {

    @NotBlank
    private String user; // This could be the username

    @NotNull
    private List<OrderItemRequest> orderItems; // List of items in the order

    @NotBlank
    private String status;
}
