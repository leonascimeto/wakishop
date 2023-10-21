package tech.leondev.wakishop.promotion.infra;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
import tech.leondev.wakishop.promotion.application.repository.PromotionRepository;
import tech.leondev.wakishop.promotion.domain.Promotion;

import java.util.List;
import java.util.UUID;

@Log4j2
@RequiredArgsConstructor
@Repository
public class PromotionInfraRepository implements PromotionRepository {
    private final PromotionSpringDataJPARepository promotionSpringDataJPARepository;
    @Override
    public Promotion save(Promotion promotion) {
        log.info("[start] PromotionInfraRepository - save");
        Promotion promotionSaved = promotionSpringDataJPARepository.save(promotion);
        log.info("[start] PromotionInfraRepository - save");
        return promotionSaved;
    }

    @Override
    public List<Promotion> list() {
        log.info("[start] PromotionInfraRepository - list");
        List<Promotion> promotions = promotionSpringDataJPARepository.findAll();
        log.info("[end] PromotionInfraRepository - list");
        return promotions;
    }

    @Override
    public Promotion findById(UUID idPromotion) {
        log.info("[start] PromotionInfraRepository - findById");
        Promotion promotion = promotionSpringDataJPARepository.findById(idPromotion)
                        .orElseThrow(() -> new RuntimeException("Promotion not found"));
        log.info("[end] PromotionInfraRepository - findById");
        return promotion;
    }
}
