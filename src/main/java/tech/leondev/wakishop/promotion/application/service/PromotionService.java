package tech.leondev.wakishop.promotion.application.service;

import tech.leondev.wakishop.promotion.domain.Promotion;

import java.util.List;
import java.util.UUID;

public interface PromotionService {
    Promotion save(Promotion promotion);

    List<Promotion> list();

    Promotion findById(UUID idPromotion);

    void delete(UUID idPromotion);
}
