package com.example.productservice.controller;

import com.example.productservice.entity.Image;
import com.example.productservice.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/image")
@CrossOrigin
public class ImageController {
    @Autowired
    private ImageService imageService;

    @PostMapping
    public Image addImage(@RequestBody Image image){
        return imageService.addImage(image);
    }

    @GetMapping("/{id}")
    public Image getById(@PathVariable Long id){
        return imageService.getById(id);
    }

    @GetMapping("/product/{idProduct}")
    public List<Image> getByProductId(@PathVariable Long idProduct){
        return imageService.findByProduct(idProduct);
    }

    @PostMapping("/delete/{id}")
    public  String deleteImage(@PathVariable Long id){
        return imageService.deleteImage(id);
    }
}
