package tech.leondev.wakishop.product.application.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.util.UUID;

@Value
public class ProductInsertPromotionRequestDTO {
    @NotNull
    private UUID idPromotion;

    @JsonCreator
    public ProductInsertPromotionRequestDTO(@JsonProperty("idPromotion") UUID idPromotion) {
        this.idPromotion = idPromotion;
    }
}
