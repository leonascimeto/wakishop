package tech.leondev.wakishop.promotion.application.service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import tech.leondev.wakishop.promotion.application.repository.PromotionRepository;
import tech.leondev.wakishop.promotion.domain.Promotion;

@Log4j2
@RequiredArgsConstructor
@Service
public class PromotionApplicationService implements PromotionService {
    private final PromotionRepository promotionRepository;

    @Override
    public Promotion save(Promotion promotion) {
        log.info("[start] PromotionApplicationService - save");
        Promotion promotionSaved = promotionRepository.save(promotion);
        log.info("[end] PromotionApplicationService - save");
        return promotionSaved;
    }
}
