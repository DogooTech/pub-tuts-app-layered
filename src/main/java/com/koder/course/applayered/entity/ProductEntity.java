package com.koder.course.applayered.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID uuid;
    private String name;
    private String sku;
    private BigDecimal price;
    private String desc;
    private String status;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private UUID userId;
}