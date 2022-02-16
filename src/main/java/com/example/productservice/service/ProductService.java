package com.example.productservice.service;


import com.example.productservice.entity.Product;
import com.example.productservice.vo.Product_Category_Supplier;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    List<Product_Category_Supplier> findAll(Pageable pageable);
    Product findById(Long id);
    List<Product_Category_Supplier> findByCategoryid(Long categoryId, Pageable pageable);
    List<Product_Category_Supplier> findByName(String name, Pageable pageable);
    List<Product_Category_Supplier> findByCategoryAndNameLike(Long categoryId,String name, Pageable pageable);
    List<Product_Category_Supplier> findBySupplierId(Long id, Pageable pageable);
    Product_Category_Supplier addProduct(Product product);
    Product_Category_Supplier update(Product product);
    Product delete(Long id,Long idUser);
    List<Product_Category_Supplier>findByCategoryIdAndSupplierId(Long idCategory, Long idSupplier,Pageable pageable);
    List<Product_Category_Supplier>findByCategoryAndSupplierAndName(Long idCategory, Long idSupplier,String name,Pageable pageable);

}
