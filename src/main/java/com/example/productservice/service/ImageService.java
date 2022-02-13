package com.example.productservice.service;

import com.example.productservice.entity.Image;

import java.util.List;

public interface ImageService {
    Image addImage(Image image);
    String deleteImage(Long id);
    List<Image> findByProduct(Long idProduct);
    Image getById(Long id);

}
