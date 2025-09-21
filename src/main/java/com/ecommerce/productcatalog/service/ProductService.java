package com.ecommerce.productcatalog.service;

import com.ecommerce.productcatalog.dto.ProductDto;
import java.util.List;

public interface ProductService {
    ProductDto create(ProductDto productDto);
    List<ProductDto> findAll();
    ProductDto findBySku(String sku);
}
