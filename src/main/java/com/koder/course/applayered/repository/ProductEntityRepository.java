package com.koder.course.applayered.repository;

import com.koder.course.applayered.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductEntityRepository extends JpaRepository<ProductEntity, Long> {

    boolean existsByNameIgnoreCase(String name);
}
