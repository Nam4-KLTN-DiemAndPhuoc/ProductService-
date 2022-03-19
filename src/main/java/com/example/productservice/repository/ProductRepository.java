package com.example.productservice.repository;

import com.example.productservice.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByDeletedAtIsNull(Pageable pageable);
    List<Product> findByCategoryIdAndDeletedAtIsNull(Long id, Pageable pageable);
    List<Product> findBySupplierIdAndDeletedAtIsNull(Long id, Pageable pageable);

    List<Product> findByNameContainingAndDeletedAtIsNull(String name,Pageable pageable);
    List<Product> findProductsByNameContainingAndDeletedAtIsNullOrderByPriceAsc(String ten,Pageable pageable);
    List<Product> findProductsByNameContainingAndDeletedAtIsNullOrderByPriceDesc(String ten,Pageable pageable);

    List<Product> findByDeletedAtIsNullOrderByPriceAsc(Pageable pageable);
    List<Product> findByDeletedAtIsNullOrderByPriceDesc(Pageable pageable);

    List<Product> findByCategoryIdAndDeletedAtIsNullOrderByPriceDesc(Long id, Pageable pageable);
    List<Product> findByCategoryIdAndDeletedAtIsNullOrderByPriceAsc(Long id, Pageable pageable);

    List<Product> findByCategoryIdAndNameContainingAndDeletedAtIsNullOrderByPriceDesc(Long id,String name, Pageable pageable);
    List<Product> findByCategoryIdAndNameContainingAndDeletedAtIsNullOrderByPriceAsc(Long id,String name, Pageable pageable);



    List<Product> findByCategoryIdAndNameContainingAndDeletedAtIsNull(Long id,String name, Pageable pageable);

    List<Product> findByCategoryIdAndSupplierIdAndDeletedAtIsNull(Long idCategory,Long idSupplier, Pageable pageable);
    List<Product> findByCategoryIdAndSupplierIdAndNameContainingAndDeletedAtIsNull(Long idCategory,Long idSupplier, String name,Pageable pageable);

    @Query(value = "SELECT *  FROM productdb.product order by view_number desc limit 3", nativeQuery = true)
    List<Product> findTop3ProductByviewNumber();
}
