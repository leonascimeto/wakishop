package tech.leondev.wakishop.promotion.application.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Value;

@Value
public class PromotionRequestDTO {
    @Pattern(regexp = "^[A-Z0-9]{6}$", message = "The code must contain 6 alphanumeric characters")
    private String code;
    @NotBlank
    private String description;
}
