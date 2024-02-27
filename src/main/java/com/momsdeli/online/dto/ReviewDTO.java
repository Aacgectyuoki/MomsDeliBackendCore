/**
 * Author: Shahbaz Ali
 * Email: shahbazkhaniq@gmail.com
 * Date: 2/27/2024$
 * Time: 11:17 PM$
 * Project Name: MomsDeliBackendCore$
 */


package com.momsdeli.online.dto;

import com.momsdeli.online.model.Product;
import com.momsdeli.online.model.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReviewDTO {

    private Long id;
    private User user;
    private Product product;
    private double rating;
    private LocalDateTime createdAt;

}
