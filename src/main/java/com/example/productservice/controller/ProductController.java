package com.example.productservice.controller;

import com.example.productservice.entity.Product;
import com.example.productservice.service.ProductService;
import com.example.productservice.vo.Product_Category_Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product_Category_Supplier> findAll(@RequestParam int page,@RequestParam int limit){
        Pageable pageable= PageRequest.of(page-1, limit);
        return service.findAll(pageable);
    }
    @GetMapping("/category/{id}")
    public List<Product_Category_Supplier> findByCategory(@PathVariable Long id,@RequestParam int page,@RequestParam int limit){
        Pageable pageable= PageRequest.of(page-1, limit);
        return service.findByCategoryid(id, pageable);
    }
    @GetMapping("/supplier/{id}")
    public List<Product_Category_Supplier> findBySupplierId(@PathVariable Long id,@RequestParam int page,@RequestParam int limit){
        Pageable pageable= PageRequest.of(page-1, limit);
        return service.findBySupplierId(id, pageable);
    }
    @GetMapping("/{id}")
    public Product findByid(@PathVariable Long id){
        return service.findById(id);
    }
    @GetMapping("/search/{name}")
    public List<Product_Category_Supplier> findByName(@PathVariable String name,@RequestParam int page,@RequestParam int limit){
        Pageable pageable= PageRequest.of(page-1, limit);
        return service.findByName(name,pageable);
    }
    @GetMapping("/category/{id}/{name}")
    public List<Product_Category_Supplier> findByCategoryAndNameLike(@PathVariable Long id, @PathVariable String name,
                                                   @RequestParam int page, @RequestParam int limit){
        Pageable pageable= PageRequest.of(page-1, limit);
        return service.findByCategoryAndNameLike(id,name,pageable);
    }
    @PostMapping("/add")
    public Product_Category_Supplier add(@RequestBody Product product){
        return service.addProduct(product);
    }
    @PostMapping("/update")
    public Product_Category_Supplier update(@RequestBody Product product){
        return service.update(product);
    }
    @PostMapping("/delete/{id}")
    public Product_Category_Supplier delete(@PathVariable Long id,@RequestBody Long idUser){
        return service.delete(id,idUser);
    }

    @GetMapping("/category/{idCategory}/supplier/{idSupplier}")
    public List<Product_Category_Supplier> findByCategoryAndSupplier(@PathVariable Long idCategory, @PathVariable Long idSupplier,
                                                                     @RequestParam int page, @RequestParam int limit){
        Pageable pageable= PageRequest.of(page-1, limit);
        return service.findByCategoryIdAndSupplierId(idCategory,idSupplier,pageable);
    }

    @GetMapping("/category/{idCategory}/supplier/{idSupplier}/name")
    public List<Product_Category_Supplier> findByCategoryAndSupplierAndName(@PathVariable Long idCategory, @PathVariable Long idSupplier, @RequestParam String name,
                                                                     @RequestParam int page, @RequestParam int limit){
        Pageable pageable= PageRequest.of(page-1, limit);
        return service.findByCategoryAndSupplierAndName(idCategory,idSupplier,name,pageable);
    }
}
