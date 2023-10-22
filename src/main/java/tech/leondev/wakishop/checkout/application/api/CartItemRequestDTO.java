package tech.leondev.wakishop.checkout.application.api;

import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.util.UUID;

@Value
public class CartItemRequestDTO {
    @NotNull
    private UUID productId;
    private int quantity;
}
