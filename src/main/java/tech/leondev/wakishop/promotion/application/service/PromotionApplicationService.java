package tech.leondev.wakishop.promotion.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import tech.leondev.wakishop.promotion.application.api.PromotionResponseDTO;
import tech.leondev.wakishop.promotion.application.repository.PromotionRepository;
import tech.leondev.wakishop.promotion.domain.Promotion;

import java.util.List;
import java.util.UUID;

@Log4j2
@RequiredArgsConstructor
@Service
public class PromotionApplicationService implements PromotionService {
    private final PromotionRepository promotionRepository;

    @Override
    public PromotionResponseDTO save(Promotion promotion) {
        log.info("[start] PromotionApplicationService - save");
        Promotion promotionSaved = promotionRepository.save(promotion);
        log.info("[end] PromotionApplicationService - save");
        return new PromotionResponseDTO(promotionSaved);
    }

    @Override
    public List<PromotionResponseDTO> list() {
        log.info("[start] PromotionApplicationService - list");
        List<Promotion> promotions = promotionRepository.list();
        log.info("[end] PromotionApplicationService - list");
        return PromotionResponseDTO.converList(promotions);
    }

    @Override
    public PromotionResponseDTO findById(UUID idPromotion) {
        log.info("[start] PromotionApplicationService - findById");
        Promotion promotion = promotionRepository.findById(idPromotion);
        log.info("[end] PromotionApplicationService - findById");
        return new PromotionResponseDTO(promotion);
    }

    @Override
    public void delete(UUID idPromotion) {
        log.info("[start] PromotionApplicationService - delete");
        Promotion promotion = promotionRepository.findById(idPromotion);
        promotionRepository.delete(promotion);
        log.info("[end] PromotionApplicationService - delete");

    }
}
