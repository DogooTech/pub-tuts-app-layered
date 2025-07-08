package com.koder.course.applayered.validator;

import com.koder.course.applayered.exception.ProductNameExistingException;
import com.koder.course.applayered.repository.ProductEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class ProductValidator {

    private final ProductEntityRepository productEntityRepository;

    // Validates if a product with the given name already exists.
    // If it does, it throws the ProductNameExistingException exception
    public void validateProductName(String productName) {
        log.info("Validating product name: {}", productName);
        boolean exists = productEntityRepository.existsByNameIgnoreCase(productName);
        if (exists) {
            log.error("Product name already exists: {}", productName);
            throw new ProductNameExistingException("Product name already exists: " + productName);
        }
        log.info("Product name is valid: {}", productName);
    }


}
