package com.example.productservice.entity;

import com.example.productservice.vo.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String avatar;

    @Column(name = "supplierId")
    private Long supplierId;
    private double price;
    private float discount;
    private int warranty;
    @Column(name = "createdAt")
    private Date createdAt;

    private String description;

    @Column(name = "createdBy")
    private Long createdBy;

    @Column(name = "updatedBy")
    private Long updatedBy;

    @Column(name = "updatedAt")
    private Date updatedAt;

    @Column(name = "deletedAt")
    private Date deletedAt;

    @Column(name = "deletedBy")
    private Long deletedBy;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<Image> images;

    private int viewNumber;
    private Long categoryId;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<Attribute> attributeList;
}
