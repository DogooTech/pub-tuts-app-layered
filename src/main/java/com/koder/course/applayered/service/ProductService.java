package com.koder.course.applayered.service;

import com.koder.course.applayered.dto.ProductRequest;
import com.koder.course.applayered.dto.ProductResponse;
import com.koder.course.applayered.entity.ProductEntity;
import com.koder.course.applayered.mapper.ProductMapper;
import com.koder.course.applayered.repository.ProductEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductMapper productMapper;
    private final ProductEntityRepository productRepository;

    // Method to save a product from ProductRequest
    // no reactive implementation here, just a simple save
    // return ProductResponse
    public ProductResponse saveProduct(ProductRequest productRequest, String userId) {
        log.info("Saving product: {}", productRequest);
        ProductEntity productEntity = productMapper.toProductEntity(productRequest, userId);
        ProductEntity savedProduct = productRepository.save(productEntity);
        log.info("Product saved successfully: {}", savedProduct);
        return productMapper.toProductResponse(savedProduct);
    }

}
