package com.momsdeli.online.dto;

import lombok.Data;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */

@Data
public class NotificationDTO {

    private Long id;
    private String user; // This could be the username or a UserDTO
    private String type; // e.g., Order Status, Promotion
    private String message;
    private boolean isRead;
}
