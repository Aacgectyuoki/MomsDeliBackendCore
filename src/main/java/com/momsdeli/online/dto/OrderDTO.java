package com.momsdeli.online.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */

@Data
public class OrderDTO {

    private Long id;
    private String user; // This could be the username or a UserDTO
    private BigDecimal totalPrice;
    private String status;
    private List<OrderItemDTO> orderItems;
}
