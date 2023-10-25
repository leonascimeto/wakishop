package tech.leondev.wakishop.product.application.api;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.math.BigDecimal;
import java.util.UUID;

@Value
public class ProductRequestDTO {
    @NotBlank
    private String name;
    @NotNull
    @DecimalMin(value = "0.05", message = "Price must be greater than 0.05")
    private BigDecimal price;
    @Nullable
    private UUID idPromotion;
}
