package com.momsdeli.online.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */

@Data
public class OrderStatusHistoryRequest {

    @NotBlank
    private String order; // This could be the order ID

    @NotBlank
    private String status; // e.g., PENDING, SHIPPED, DELIVERED
}
