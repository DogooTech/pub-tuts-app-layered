package com.koder.course.applayered.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequest {

    @NotNull
    private UUID uuid;

    @NotBlank
    private String name;

    @NotBlank
    private String sku;

    @NotNull
    @Positive
    private BigDecimal price;

    @NotBlank
    private String desc;
}