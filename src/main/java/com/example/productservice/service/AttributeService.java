package com.example.productservice.service;

import com.example.productservice.entity.Attribute;

import java.util.List;

public interface AttributeService {
    List<Attribute> addAttribute(List<Attribute> attributes);
    List<Attribute> updateAttribute(List<Attribute> attributes);
    List<Attribute> findByProduct(Long id);
    Attribute findById(Long id);
    Attribute update(Attribute attribute);
}
