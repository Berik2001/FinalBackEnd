package com.example.finaldiploma.controllers;


import com.example.finaldiploma.model.Product;
import com.example.finaldiploma.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    private List<Product> findAllProductByCategoryId(@PathVariable("id") Long id) {
        return productService.findAllProductByCategoryId(id);
    }

    @GetMapping
    private List<Product> getAll() {
        return productService.getAll();
    }
    @PostMapping
    private Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping
    private ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Product newProduct = productService.updateProduct(product);
        return ResponseEntity.ok(newProduct);
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<String> deleteProduct(@PathVariable("id") int id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("deleted");
    }
}
