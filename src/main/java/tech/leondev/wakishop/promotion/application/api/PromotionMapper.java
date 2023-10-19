package tech.leondev.wakishop.promotion.application.api;

import org.modelmapper.ModelMapper;
import tech.leondev.wakishop.promotion.domain.Promotion;

public class PromotionMapper {
    private static Promotion toPromotion(PromotionRequestDTO promotionRequestDTO){
        return new ModelMapper().map(promotionRequestDTO, Promotion.class);
    }
}
