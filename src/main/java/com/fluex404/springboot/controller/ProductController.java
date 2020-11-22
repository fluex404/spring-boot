package com.fluex404.springboot.controller;

import com.fluex404.springboot.exception.ProductNotFoundException;
import com.fluex404.springboot.response.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ProductController {
    private static Map<String, Object> productRepo = new HashMap<>();

    static {
        Product honey = new Product();
        honey.setId("101");
        honey.setName("Honey");
        productRepo.put(honey.getId(), honey);

        Product almond = new Product();
        almond.setId("102");
        almond.setName("Almond");
        productRepo.put(almond.getId(), almond);
    };

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id){
        if(!productRepo.containsKey(id)) throw new ProductNotFoundException("tidak ketemu");
        Object result = productRepo.get(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping(value = "/product/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadFile(@RequestParam("file")MultipartFile file) throws IOException {
        return new ResponseEntity<>("file "+file.getOriginalFilename()+" upload successfully!", HttpStatus.OK);
    }

 }
