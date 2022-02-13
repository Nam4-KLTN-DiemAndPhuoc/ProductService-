package com.example.productservice.repository;

import com.example.productservice.entity.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AttributeRepository extends JpaRepository<Attribute, Long> {
    List<Attribute> findByProductId(Long id);
}
