package com.koder.course.applayered.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponse {
    private UUID uuid;
    private String name;
    private String sku;
    private BigDecimal price;
    private String desc;
    private String status;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}