package com.koder.course.applayered.mapper;

import com.koder.course.applayered.dto.ProductRequest;
import com.koder.course.applayered.entity.ProductEntity;
import com.koder.course.applayered.dto.ProductResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class ProductMapper {

    public ProductResponse toProductResponse(ProductEntity entity) {
        return new ProductResponse(
                entity.getUuid(),
                entity.getName(),
                entity.getSku(),
                entity.getPrice(),
                entity.getDesc(),
                entity.getStatus(),
                entity.getCreatedDate(),
                entity.getModifiedDate()
        );
    }

    // Converts a ProductRequest to a ProductEntity with default status is INIT
    public ProductEntity toProductEntity(ProductRequest request, String userId) {

        LocalDateTime now = LocalDateTime.now();

        return new ProductEntity(
                null,
                request.getUuid(),
                request.getName(),
                request.getSku(),
                request.getPrice(),
                request.getDesc(),
                "INIT", // Default status
                now,
                now,
                UUID.fromString(userId) // Assuming userId is a valid UUID string
        );
    }
}