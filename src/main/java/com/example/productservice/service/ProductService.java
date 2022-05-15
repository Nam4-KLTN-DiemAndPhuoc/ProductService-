package com.example.productservice.service;


import com.example.productservice.entity.Product;
import com.example.productservice.vo.Product_Category_Supplier;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    List<Product_Category_Supplier> findAll(Pageable pageable);
    List<Product_Category_Supplier> findByDeletedAt(Pageable pageable);

    Product findById(Long id);
    Product_Category_Supplier findByProductId(Long id);

    List<Product_Category_Supplier> findByCategoryid(Long categoryId, Pageable pageable);
    List<Product_Category_Supplier> findByName(String name, Pageable pageable);
    List<Product_Category_Supplier> findByCategoryAndNameLike(Long categoryId,String name, Pageable pageable);
    List<Product_Category_Supplier> findBySupplierAndNameLike(Long categoryId,String name, Pageable pageable);

    List<Product_Category_Supplier> findBySupplierId(Long id, Pageable pageable);
    ///
    Product_Category_Supplier addProduct(Product product);
    List<Product_Category_Supplier> findByDeletedAtIsNulldOrderByUpdatedAtDesc(Pageable pageable);
    Product_Category_Supplier update(Product product);
    Product delete(Long id,Long idUser);
    List<Product_Category_Supplier>findByCategoryIdAndSupplierId(Long idCategory, Long idSupplier,Pageable pageable);
    List<Product_Category_Supplier>findByCategoryAndSupplierAndName(Long idCategory, Long idSupplier,String name,Pageable pageable);

    List<Product_Category_Supplier> findTop3ProductByviewNumber();

    List<Product_Category_Supplier> findAllOrderPriceAsc(Pageable pageable);
    List<Product_Category_Supplier> findAllOrderPriceDesc(Pageable pageable);

    List<Product_Category_Supplier> findByCategoryidAsc(Long categoryId, Pageable pageable);
    List<Product_Category_Supplier> findByCategoryDesc(Long categoryId, Pageable pageable);


    List<Product_Category_Supplier> findByCategoryAndNameLikeAsc(Long categoryId,String name, Pageable pageable);
    List<Product_Category_Supplier> findByCategoryAndNameLikeDesc(Long categoryId,String name, Pageable pageable);

    List<Product_Category_Supplier> findByNameAsc(String name, Pageable pageable);
    List<Product_Category_Supplier> findByNameDesc(String name, Pageable pageable);

    ///

    List<Product_Category_Supplier> findByCategoryidDeleted(Long categoryId, Pageable pageable);
    List<Product_Category_Supplier> findByNameDeleted(String name, Pageable pageable);
    List<Product_Category_Supplier> findByCategoryAndNameLikeDeleted(Long categoryId,String name, Pageable pageable);
    List<Product_Category_Supplier> findBySupplierAndNameLikeDeleted(Long categoryId,String name, Pageable pageable);

    List<Product_Category_Supplier> findBySupplierIdDeleted(Long id, Pageable pageable);
    List<Product_Category_Supplier>findByCategoryIdAndSupplierIdDeleted(Long idCategory, Long idSupplier,Pageable pageable);
    List<Product_Category_Supplier>findByCategoryAndSupplierAndNameDeleted(Long idCategory, Long idSupplier,String name,Pageable pageable);

}
