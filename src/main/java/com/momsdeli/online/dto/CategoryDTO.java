/**
 * Author: Shahbaz Ali
 * Email: shahbazkhaniq@gmail.com
 * Date: 2/27/2024$
 * Time: 11:12 PM$
 * Project Name: MomsDeliBackendCore$
 */


package com.momsdeli.online.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CategoryDTO {
    private Long id;
    @NotNull
    @Size(max = 50)
    private String name;
    private Long parentCategoryId;
    private Integer level;
}
