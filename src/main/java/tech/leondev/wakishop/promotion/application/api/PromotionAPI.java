package tech.leondev.wakishop.promotion.application.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Promoções", description = "Recurso relacionado ao gerenciamento de promoções.")
@RestController
@RequestMapping("v1/promotions")
public interface PromotionAPI {
    @Operation(
            summary = "Registra promoção",
            description = "Registra uma nova promoção no sistema"
    )
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    PromotionResponseDTO save(@RequestBody @Valid PromotionRequestDTO promotionRequestDTO);

    @Operation(
            summary = "Lista promoções",
            description = "Retorna uma lista com todas as promoções salvas no sistema."
    )
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<PromotionResponseDTO> list();

    @Operation(
            summary = "Busca promoção",
            description = "Busca uma promoção pelo ID."
    )
    @GetMapping("/{idPromotion}")
    @ResponseStatus(HttpStatus.OK)
    PromotionResponseDTO findById(@PathVariable UUID idPromotion);

    @Operation(
            summary = "Deleta promoção",
            description = "Deleta uma promoção pelo ID."
    )
    @DeleteMapping("/{idPromotion}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable UUID idPromotion);
}
