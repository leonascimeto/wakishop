package tech.leondev.wakishop.promotion.application.api;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

import java.util.UUID;

@Value
public class PromotionResponseDTO {
    private UUID idPromotion;
    private String code;
    private String description;
}
