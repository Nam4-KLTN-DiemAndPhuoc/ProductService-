package com.example.productservice.controller;

import com.example.productservice.entity.Attribute;
import com.example.productservice.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attribute")
public class AttributeController {

    @Autowired
    private AttributeService service;

    @PostMapping
    public List<Attribute> addAttribute(@RequestBody List<Attribute> attributes){
        return  service.addAttribute(attributes);
    }

    @PostMapping("/update")
    public List<Attribute> updateAttribute(@RequestBody List<Attribute> attributes){
        return  service.updateAttribute(attributes);
    }

    @GetMapping("/product/{id}")
    public List<Attribute> findByProductId(@PathVariable Long id){
        return service.findByProduct(id);
    }

    @GetMapping("/{id}")
    public Attribute findById(@PathVariable Long id){
        return  service.findById(id);
    }
}
