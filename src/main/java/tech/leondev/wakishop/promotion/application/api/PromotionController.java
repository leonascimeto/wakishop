package tech.leondev.wakishop.promotion.application.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;
import tech.leondev.wakishop.promotion.application.service.PromotionService;
import tech.leondev.wakishop.promotion.domain.Promotion;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Log4j2
@RestController
public class PromotionController implements PromotionAPI {
    private final PromotionService promotionService;
    @Override
    public PromotionResponseDTO save(PromotionRequestDTO promotionRequestDTO) {
        log.info("[start] PromotionController - save");
        PromotionResponseDTO promotion = promotionService.save(new Promotion(promotionRequestDTO));
        log.info("[end] PromotionController - save");
        return promotion;
    }

    @Override
    public List<PromotionResponseDTO> list() {
        log.info("[start] PromotionController - list");
        List<PromotionResponseDTO> promotions = promotionService.list();
        log.info("[end] PromotionController - list");
        return promotions;
    }

    @Override
    public PromotionResponseDTO findById(UUID idPromotion) {
        log.info("[start] PromotionController - findById");
        PromotionResponseDTO promotion = promotionService.findById(idPromotion);
        log.info("[end] PromotionController - findById");
        return promotion;
    }

    @Override
    public void delete(UUID idPromotion) {
        log.info("[start] PromotionController - delete");
        promotionService.delete(idPromotion);
        log.info("[end] PromotionController - delete");
    }
}
