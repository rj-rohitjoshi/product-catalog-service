package com.ecommerce.productcatalog.controller;

import com.ecommerce.productcatalog.dto.ProductDto;
import com.ecommerce.productcatalog.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDto> create(@RequestBody ProductDto dto) {
        return ResponseEntity.ok(productService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> all() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/sku/{sku}")
    public ResponseEntity<ProductDto> bySku(@PathVariable String sku) {
        return ResponseEntity.ok(productService.findBySku(sku));
    }
}
