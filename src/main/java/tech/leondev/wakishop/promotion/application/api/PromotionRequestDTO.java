package tech.leondev.wakishop.promotion.application.api;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Value;
import tech.leondev.wakishop.promotion.domain.TypePromotion;

import java.math.BigDecimal;

@Value
public class PromotionRequestDTO {
    @Pattern(regexp = "^[A-Z0-9]{6}$", message = "The code must contain 6 alphanumeric characters")
    private String code;
    @NotBlank
    private String description;
    @Enumerated(EnumType.STRING)
    private TypePromotion typePromotion;
    private int take;
    private int pay;
    private BigDecimal fixedPrice;
}
