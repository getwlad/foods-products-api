package com.wladmir.productsapi.controller;

import com.wladmir.productsapi.model.Product;
import com.wladmir.productsapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService service;

    @GetMapping
    public ResponseEntity<Iterable<Product>> getProducts() {
        return ResponseEntity.ok(service.getProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.getProductById(id));
    }

    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        return ResponseEntity.ok((service.addProduct(product)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return ResponseEntity.ok(service.updateProduct(id, product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.deleteProduct(id));
    }


    @PostMapping("/{idProduct}/category/{idCategory}")
    public ResponseEntity<Product> addCategory(@PathVariable("idProduct") Long idProduct, @PathVariable("idCategory") Long idCategory) {
        return ResponseEntity.ok(service.setProductCategory(idProduct, idCategory));
    }


}
