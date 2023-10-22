package tech.leondev.wakishop.product.application.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.math.BigDecimal;

@Value
public class ProductRequestDTO {
    @NotBlank
    private String name;
    @NotNull
    private BigDecimal price;
}
