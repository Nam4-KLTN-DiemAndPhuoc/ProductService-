package com.example.productservice.vo;

import lombok.Data;

@Data
public class Supplier {
    private Long id;
    private String supplierName;
    private String phoneNumber;
    private String street;
    private String wards;
    private String district;
    private String city;
}
