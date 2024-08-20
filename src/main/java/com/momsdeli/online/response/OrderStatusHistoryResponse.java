package com.momsdeli.online.response;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */

@Data
public class OrderStatusHistoryResponse {

    private Long id;
    private String order;
    private String status;
    private LocalDateTime changedAt;
}
