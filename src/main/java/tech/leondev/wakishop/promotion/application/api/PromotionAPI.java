package tech.leondev.wakishop.promotion.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/promotions")
public interface PromotionAPI {
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    PromotionResponseDTO save(@RequestBody @Valid PromotionRequestDTO promotionRequestDTO);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<PromotionResponseDTO> list();

    @GetMapping("/{idPromotion}")
    @ResponseStatus(HttpStatus.OK)
    PromotionResponseDTO findById(@PathVariable UUID idPromotion);

    @DeleteMapping("/{idPromotion}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable UUID idPromotion);
}
