package com.koder.course.applayered.api;

import com.koder.course.applayered.dto.ProductRequest;
import com.koder.course.applayered.dto.ProductResponse;
import com.koder.course.applayered.service.ProductService;
import com.koder.course.applayered.validator.ProductValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ProductApisImpl implements ProductApis{

    private final ProductService productService;
    private final ProductValidator productValidator;

    @Override
    public ResponseEntity<ProductResponse> createProduct(ProductRequest request) {

        productValidator.validateProductName(request.getName());

        //UserId here is hardcoded for simplicity,
        // in a real application it should be fetched from the security context or request header
        return new ResponseEntity<>(productService.saveProduct(request, UUID.randomUUID().toString()), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ProductResponse> getProduct(UUID uuid) {
        return null;
    }

    @Override
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        return null;
    }

    @Override
    public ResponseEntity<ProductResponse> updateProduct(UUID uuid, ProductRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteProduct(UUID uuid) {
        return null;
    }
}
