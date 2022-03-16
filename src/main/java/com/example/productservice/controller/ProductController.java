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

    @GetMapping("/asc")
    public List<Product_Category_Supplier> findAllAsc(@RequestParam int page,@RequestParam int limit){
        Pageable pageable= PageRequest.of(page-1, limit);
        return service.findAllOrderPriceAsc(pageable);
    }

    @GetMapping("/desc")
    public List<Product_Category_Supplier> findAllDesc(@RequestParam int page,@RequestParam int limit){
        Pageable pageable= PageRequest.of(page-1, limit);
        return service.findAllOrderPriceDesc(pageable);
    }

    @GetMapping("/category/{id}")
    public List<Product_Category_Supplier> findByCategory(@PathVariable Long id,@RequestParam int page,@RequestParam int limit){
        Pageable pageable= PageRequest.of(page-1, limit);
        return service.findByCategoryid(id, pageable);
    }

    @GetMapping("/category/asc/{id}")
    public List<Product_Category_Supplier> findByCategoryAsc(@PathVariable Long id,@RequestParam int page,@RequestParam int limit){
        Pageable pageable= PageRequest.of(page-1, limit);
        return service.findByCategoryidAsc(id, pageable);
    }

    @GetMapping("/category/desc/{id}")
    public List<Product_Category_Supplier> findByCategoryDesc(@PathVariable Long id,@RequestParam int page,@RequestParam int limit){
        Pageable pageable= PageRequest.of(page-1, limit);
        return service.findByCategoryDesc(id, pageable);
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

    @GetMapping("/search")
    public List<Product_Category_Supplier> findByName(@RequestParam String name,@RequestParam int page,@RequestParam int limit){
        Pageable pageable= PageRequest.of(page-1, limit);
        return service.findByName(name,pageable);
    }

    @GetMapping("/search/asc")
    public List<Product_Category_Supplier> findByNameAsc(@RequestParam String name,@RequestParam int page,@RequestParam int limit){
        Pageable pageable= PageRequest.of(page-1, limit);
        return service.findByNameAsc(name,pageable);
    }

    @GetMapping("/search/desc")
    public List<Product_Category_Supplier> findByNameDesc(@RequestParam String name,@RequestParam int page,@RequestParam int limit){
        Pageable pageable= PageRequest.of(page-1, limit);
        return service.findByNameDesc(name,pageable);
    }

    @GetMapping("/category/{id}/{name}")
    public List<Product_Category_Supplier> findByCategoryAndNameLike(@PathVariable Long id, @PathVariable String name,
                                                   @RequestParam int page, @RequestParam int limit){
        Pageable pageable= PageRequest.of(page-1, limit);
        return service.findByCategoryAndNameLike(id,name,pageable);
    }

    @GetMapping("/category/asc/{id}/{name}")
    public List<Product_Category_Supplier> findByCategoryAndNameLikeAsc(@PathVariable Long id, @PathVariable String name,
                                                                     @RequestParam int page, @RequestParam int limit){
        Pageable pageable= PageRequest.of(page-1, limit);
        return service.findByCategoryAndNameLikeAsc(id,name,pageable);
    }

    @GetMapping("/category/desc/{id}/{name}")
    public List<Product_Category_Supplier> findByCategoryAndNameLikeDesc(@PathVariable Long id, @PathVariable String name,
                                                                        @RequestParam int page, @RequestParam int limit){
        Pageable pageable= PageRequest.of(page-1, limit);
        return service.findByCategoryAndNameLikeDesc(id,name,pageable);
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

    @GetMapping("/top3")
    public List<Product_Category_Supplier> findTop3ProductByviewNumber(){
        return  service.findTop3ProductByviewNumber();
    }
}
