package com.ecommerce.productcatalog.service;

import com.ecommerce.productcatalog.dto.ProductDto;
import com.ecommerce.productcatalog.entity.Product;
import com.ecommerce.productcatalog.repository.ProductRepository;
import com.ecommerce.productcatalog.exception.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service @RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repo;

    @Override
    public ProductDto create(ProductDto dto) {
        Product entity = Product.builder()
                .name(dto.getName())
                .sku(dto.getSku())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .build();
        repo.save(entity);
        dto.setId(entity.getId());
        return dto;
    }

    @Override
    public List<ProductDto> findAll() {
        return repo.findAll().stream()
                .map(p -> ProductDto.builder()
                        .id(p.getId()).name(p.getName()).sku(p.getSku())
                        .description(p.getDescription()).price(p.getPrice())
                        .build())
                .toList();
    }

    @Override
    public ProductDto findBySku(String sku) {
        Product p = repo.findBySku(sku).orElseThrow(() -> new ProductNotFoundException("SKU not found: " + sku));
        return ProductDto.builder()
                .id(p.getId()).name(p.getName()).sku(p.getSku())
                .description(p.getDescription()).price(p.getPrice())
                .build();
    }
}
