package tech.leondev.wakishop.promotion.application.service;

import tech.leondev.wakishop.promotion.domain.Promotion;

import java.util.List;

public interface PromotionService {
    Promotion save(Promotion promotion);

    List<Promotion> list();
}
