package com.momsdeli.online.dto;

import lombok.Data;

/**
 * @author Shahbaz Khan
 * @date 29/08/2024
 */
@Data
public class ProductImageDTO {
    private Long id;
    private String s3Url; // The URL of the image stored in S3
    private int sortOrder; // The order in which the image should be displayed
}
