package com.momsdeli.online.request;

import jakarta.validation.constraints.NotBlank;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */
public class NotificationRequest {

    @NotBlank
    private String user; // This could be the username

    @NotBlank
    private String type; // e.g., Order Status, Promotion

    @NotBlank
    private String message;

    private boolean isRead;
}
