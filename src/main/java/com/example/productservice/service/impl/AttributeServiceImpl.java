package com.example.productservice.service.impl;

import com.example.productservice.entity.Attribute;
import com.example.productservice.repository.AttributeRepository;
import com.example.productservice.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AttributeServiceImpl implements AttributeService {

    @Autowired
    private AttributeRepository repository;


    @Override
    public List<Attribute> addAttribute(List<Attribute> attributes) {
        return repository.saveAll(attributes);
    }

    @Override
    public List<Attribute> updateAttribute(List<Attribute> attributes) {
        return repository.saveAll(attributes);
    }

    @Override
    public List<Attribute> findByProduct(Long id) {
        return repository.findByProductId(id);
    }

    @Override
    public Attribute findById(Long id) {
        return repository.findById(id).get();
    }
}
