package com.ecommerce.productcatalog.service;

import com.ecommerce.productcatalog.dto.ProductDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    void createAndFindProduct() {
        ProductDto dto = ProductDto.builder()
                .name("Test Product")
                .sku("TEST123")
                .description("A product for unit testing")
                .price(BigDecimal.valueOf(99.99))
                .build();

        ProductDto created = productService.create(dto);

        assertThat(created.getId()).isNotNull();

        ProductDto found = productService.findBySku("TEST123");
        assertThat(found.getName()).isEqualTo("Test Product");
    }

    @Test
    void findAllProductsIsEmptyAtStart() {
        List<ProductDto> products = productService.findAll();
        assertThat(products).isEmpty();
    }
}
