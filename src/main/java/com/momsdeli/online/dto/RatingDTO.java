/**
 * Author: Shahbaz Ali
 * Email: shahbazkhaniq@gmail.com
 * Date: 2/27/2024$
 * Time: 11:16 PM$
 * Project Name: MomsDeliBackendCore$
 */


package com.momsdeli.online.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RatingDTO {

    private Long id;
    @NotNull
    private Long userId;
    @NotNull
    private Long productId;
    @NotNull
    private double rating;
    private LocalDateTime createdAt;
}
