package tech.leondev.wakishop.promotion.application.repository;

import tech.leondev.wakishop.promotion.domain.Promotion;

import java.util.List;
import java.util.UUID;

public interface PromotionRepository {

    Promotion save(Promotion promotion);

    List<Promotion> list();

    Promotion findById(UUID idPromotion);
}
