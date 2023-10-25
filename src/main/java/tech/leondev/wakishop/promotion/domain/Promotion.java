package tech.leondev.wakishop.promotion.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tech.leondev.wakishop.promotion.application.api.PromotionRequestDTO;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "promotions")
@Entity(name = "promotions")
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", unique = true, nullable = false)
    private UUID idPromotion;
    @Column(unique = true)
    @Pattern(regexp = "^[A-Z0-9]{6}$", message = "The code must contain 6 alphanumeric characters")
    private String code;
    @NotBlank
    private String description;
    @Column(name = "type_promotion")
    @Enumerated(EnumType.STRING)
    private TypePromotion typePromotion;
    private int take;
    private int pay;
    @Column(name = "fixed_price")
    private BigDecimal fixedPrice = BigDecimal.ZERO;

    public Promotion(PromotionRequestDTO promotionRequestDTO){
        this.description = promotionRequestDTO.getDescription();
        this.code = promotionRequestDTO.getCode();
        this.pay = promotionRequestDTO.getPay();
        this.take = promotionRequestDTO.getTake();
        this.fixedPrice = promotionRequestDTO.getFixedPrice();
        this.typePromotion = promotionRequestDTO.getTypePromotion();
    }
}
