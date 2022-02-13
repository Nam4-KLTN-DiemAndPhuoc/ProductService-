package com.example.productservice.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;


@Data
@ToString
public class Category {

    private long id;
    private long parentCategoryId;

    private String name;

}
