package tech.leondev.wakishop.product.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tech.leondev.wakishop.product.application.api.ProductRequestDTO;
import tech.leondev.wakishop.promotion.domain.Promotion;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "products")
@Entity(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, unique = true)
    private UUID idProduct;
    @NotBlank
    private String name;
    @NotNull
    @DecimalMin(value = "0.05", message = "Price must be greater than 0.05")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "promotion_id")
    private Promotion promotion;

    public Product(ProductRequestDTO productRequestDTO) {
        this.name = productRequestDTO.getName();
        this.price = productRequestDTO.getPrice();
    }

    public void update(ProductRequestDTO productRequestDTO) {
        this.name = productRequestDTO.getName();
        this.price = productRequestDTO.getPrice();
    }

    public void insertPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public void removePromotion() {
        this.promotion = null;
    }
}
