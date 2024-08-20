package com.momsdeli.online.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */

@Data
public class OrderStatusHistoryDTO {

    private Long id;
    private String order; // This could be the order ID or an OrderDTO
    private String status;
    private LocalDateTime changedAt;
}
