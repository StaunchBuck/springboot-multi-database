package com.multi.database.app.controller;

import com.multi.database.app.entity.Student;
import com.multi.database.app.model.Product;
import com.multi.database.app.service.ProductService;
import com.multi.database.app.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getStudent(@PathVariable("id") Long id) {
        return ResponseEntity
                .status(HttpStatus.OK.value())
                .body(productService.getProductById(id));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getStudent() {
        return ResponseEntity
                .status(HttpStatus.OK.value())
                .body(productService.getProducts());
    }
}