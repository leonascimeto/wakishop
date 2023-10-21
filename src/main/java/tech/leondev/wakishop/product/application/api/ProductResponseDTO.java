package tech.leondev.wakishop.product.application.api;

import lombok.Value;
import tech.leondev.wakishop.product.domain.Product;
import tech.leondev.wakishop.promotion.domain.Promotion;

import java.util.UUID;

@Value
public class ProductResponseDTO {
    private UUID idProduct;
    private String name;
    private double price;
    private Promotion promotion;

    public ProductResponseDTO(Product product) {
        this.idProduct = product.getIdProduct();
        this.name = product.getName();
        this.price = product.getPrice();
        this.promotion = product.getPromotion();
    }
}
