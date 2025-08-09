package com.mounir.ecomerce.Product;

import com.mounir.ecomerce.Category.Category;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    public Product toProduct(@Valid ProductRequest productRequest) {
        return Product.builder()
                .id(productRequest.id())
                .name(productRequest.name())
                .price(productRequest.price())
                .description(productRequest.description())
                .availableQuantity(productRequest.availableQuantity())
                .category(
                        Category.builder().id(
                                productRequest.categoryId())
                                .build()
                )
                .build();
    }

    public ProductResponse toProductResponse( Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getAvailableQuantity(),
                product.getPrice(),
                product.getCategory().getId(),
                product.getCategory().getName(),
                product.getCategory().getDescription()
        );
    }
}
