package tech.leondev.wakishop.promotion.application.api;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;
import tech.leondev.wakishop.promotion.domain.Promotion;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

    public static List<PromotionResponseDTO> converList(List<Promotion> promotions) {
        return promotions.stream().map(PromotionResponseDTO::new).collect(Collectors.toList());
    }
}
