package com.example.productservice.vo;

import com.example.productservice.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product_Category_Supplier {
    private Product product;
    private Category category;
    private Supplier supplier;
}
