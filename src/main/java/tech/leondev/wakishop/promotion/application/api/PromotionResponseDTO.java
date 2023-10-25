package tech.leondev.wakishop.promotion.application.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import lombok.Value;
import tech.leondev.wakishop.promotion.domain.Promotion;
import tech.leondev.wakishop.promotion.domain.TypePromotion;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Value
public class PromotionResponseDTO {
    private UUID idPromotion;
    private String code;
    private String description;
    private TypePromotion typePromotion;
    private int take;
    private int pay;
    private BigDecimal fixedPrice;

    public PromotionResponseDTO(Promotion promotion) {
        this.idPromotion = promotion.getIdPromotion();
        this.code = promotion.getCode();
        this.description = promotion.getDescription();
        this.typePromotion = promotion.getTypePromotion();
        this.take = promotion.getTake();
        this.pay = promotion.getPay();
        this.fixedPrice = promotion.getFixedPrice();
    }

    public static List<PromotionResponseDTO> converList(List<Promotion> promotions) {
        return promotions.stream().map(PromotionResponseDTO::new).collect(Collectors.toList());
    }
}
