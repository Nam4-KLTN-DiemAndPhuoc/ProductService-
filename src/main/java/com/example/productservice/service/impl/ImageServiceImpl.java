package com.example.productservice.service.impl;

import com.example.productservice.entity.Image;
import com.example.productservice.repository.ImageRepository;
import com.example.productservice.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageRepository repository;

    @Override
    public Image addImage(Image image) {
        return repository.save(image);
    }

    @Override
    public String deleteImage(Long id) {
        repository.deleteById(id);
        return "Xóa thành công";
    }

    @Override
    public List<Image> findByProduct(Long idProduct) {
        return repository.findByProductId(idProduct);
    }

    @Override
    public Image getById(Long id) {
        return repository.findById(id).get();
    }
}
