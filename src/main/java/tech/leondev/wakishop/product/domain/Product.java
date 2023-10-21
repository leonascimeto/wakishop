package tech.leondev.wakishop.product.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tech.leondev.wakishop.product.application.api.ProductRequestDTO;
import tech.leondev.wakishop.promotion.domain.Promotion;

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
    private double price;

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
}
