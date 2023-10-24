package tech.leondev.wakishop.promotion.application.service;

import tech.leondev.wakishop.promotion.application.api.PromotionResponseDTO;
import tech.leondev.wakishop.promotion.domain.Promotion;

import java.util.List;
import java.util.UUID;

public interface PromotionService {
    PromotionResponseDTO save(Promotion promotion);

    List<PromotionResponseDTO> list();

    PromotionResponseDTO findById(UUID idPromotion);

    void delete(UUID idPromotion);
}
