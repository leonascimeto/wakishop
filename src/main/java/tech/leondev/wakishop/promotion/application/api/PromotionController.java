package tech.leondev.wakishop.promotion.application.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;
import tech.leondev.wakishop.promotion.application.service.PromotionService;
import tech.leondev.wakishop.promotion.domain.Promotion;

@RequiredArgsConstructor
@Log4j2
@RestController
public class PromotionController implements PromotionAPI {
    private final PromotionService promotionService;
    @Override
    public PromotionResponseDTO save(PromotionRequestDTO promotionRequestDTO) {
        log.info("[start] PromotionController - save");
        Promotion promotion = promotionService.save(new Promotion(promotionRequestDTO));
        log.info("[end] PromotionController - save");
        return new PromotionResponseDTO(promotion);
    }
}
