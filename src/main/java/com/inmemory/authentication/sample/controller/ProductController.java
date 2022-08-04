package com.inmemory.authentication.sample.controller;

import com.inmemory.authentication.sample.entity.Product;
import com.inmemory.authentication.sample.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/login")
    public String login() {
        return "Hello Login Page!";
    }

    @GetMapping("/list")
    public ResponseEntity<List<Product>> findAll() {
        List<Product> productList = productService.findAll();
        return ResponseEntity.ok(productList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") Long id) {
        Product product = productService.findById(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping("/create")
    public ResponseEntity<Product> create(@Valid @RequestBody Product product) {
        Product savedProduct = productService.create(product);
        return ResponseEntity.ok(savedProduct);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> update(@PathVariable("id") Long id, Product product) {
        Product updatedProduct = productService.update(id, product);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        productService.delete(id);
        return ResponseEntity.ok(id + " deleted!");
    }
}
