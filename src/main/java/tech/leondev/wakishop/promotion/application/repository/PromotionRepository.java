package tech.leondev.wakishop.promotion.application.repository;

import tech.leondev.wakishop.promotion.domain.Promotion;

public interface PromotionRepository {

    Promotion save(Promotion promotion);
}
