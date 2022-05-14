package com.example.productservice.controller;

import com.example.productservice.entity.Attribute;
import com.example.productservice.entity.Product;
import com.example.productservice.service.AttributeService;
import com.example.productservice.service.ProductService;
import com.example.productservice.vo.Product_Category_Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {
    @Autowired
    private ProductService service;

    @Autowired
    private AttributeService attributeService;

    @PostMapping("/product/add")
    public Product_Category_Supplier add(@RequestBody Product product){
        return service.addProduct(product);
    }
    @GetMapping("/product-delete")
    public List<Product_Category_Supplier> findByDeletedAt(  @RequestParam int page, @RequestParam int limit){
        Pageable pageable= PageRequest.of(page-1, limit);
        return service.findByDeletedAt(pageable);
    }

    @PostMapping("/product/update")
    public Product_Category_Supplier update(@RequestBody Product product){
        return service.update(product);
    }
    @GetMapping("/{id}")
    public Product_Category_Supplier findByProductId(@PathVariable Long id){
        return service.findByProductId(id);
    }
    @PostMapping("/product/delete/{id}")
    public Product delete(@PathVariable Long id, @RequestBody Long idUser){
        return service.delete(id,idUser);
    }

    @PostMapping("/attribute/add")
    public List<Attribute> addAttribute(@RequestBody List<Attribute> attributes){
        return  attributeService.addAttribute(attributes);
    }

    @PostMapping("/attribute/update")
    public List<Attribute> updateAttribute(@RequestBody List<Attribute> attributes){
        return  attributeService.updateAttribute(attributes);
    }


}
