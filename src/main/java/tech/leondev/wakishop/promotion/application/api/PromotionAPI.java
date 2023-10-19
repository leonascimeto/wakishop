package tech.leondev.wakishop.promotion.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/promotions")
public interface PromotionAPI {
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    PromotionResponseDTO save(@RequestBody @Valid PromotionRequestDTO promotionRequestDTO);
}
