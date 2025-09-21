package com.ecommerce.productcatalog.dto;

import lombok.*;
import java.math.BigDecimal;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ProductDto {
    private Long id;
    private String name;
    private String sku;
    private String description;
    private BigDecimal price;
}
