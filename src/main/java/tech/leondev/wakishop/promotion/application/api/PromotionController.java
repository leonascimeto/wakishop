package tech.leondev.wakishop.promotion.application.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Log4j2
@RestController
public class PromotionController implements PromotionAPI {

    @Override
    public PromotionResponseDTO save(PromotionRequestDTO promotionRequestDTO) {
        log.info("[start] PromotionController - save");
        log.info("[end] PromotionController - save");
        return null;
    }
}
