package com.mounir.ecomerce.Product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductRequest(
         Integer id,
         @NotNull(message = "Name should not be null")
         String name,
         @NotNull(message = "Name should not be null")
         String description,
         @Positive(message = "available quantity should be positive")
         double availableQuantity,
         @Positive(message = "price should be positive")
         BigDecimal price,
         @NotNull(message = "product category should not be null")
         Integer categoryId
) {
}
