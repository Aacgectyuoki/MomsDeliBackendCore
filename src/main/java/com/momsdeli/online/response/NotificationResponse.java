package com.momsdeli.online.response;

import lombok.Data;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */

@Data
public class NotificationResponse {

    private Long id;
    private String user;
    private String type;
    private String message;
    private boolean isRead;
}
