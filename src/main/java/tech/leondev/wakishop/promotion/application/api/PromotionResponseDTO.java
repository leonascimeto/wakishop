package tech.leondev.wakishop.promotion.application.api;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;
import tech.leondev.wakishop.promotion.domain.Promotion;

import java.util.UUID;

@Value
public class PromotionResponseDTO {
    private UUID idPromotion;
    private String code;
    private String description;

    public PromotionResponseDTO(Promotion promotion) {
        this.idPromotion = promotion.getIdPromotion();
        this.code = promotion.getCode();
        this.description = promotion.getDescription();
    }
}
