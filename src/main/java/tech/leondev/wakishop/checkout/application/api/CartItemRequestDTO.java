package tech.leondev.wakishop.checkout.application.api;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.util.UUID;

@Value
public class CartItemRequestDTO {
    @NotNull
    private UUID productId;
    @Min(value = 1, message = "Quantity must be greater than 0")
    private int quantity;
}
