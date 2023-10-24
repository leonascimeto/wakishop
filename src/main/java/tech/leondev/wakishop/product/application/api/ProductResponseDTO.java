package tech.leondev.wakishop.product.application.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Value;
import tech.leondev.wakishop.product.domain.Product;
import tech.leondev.wakishop.promotion.domain.Promotion;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductResponseDTO {
    private UUID idProduct;
    private String name;
    private BigDecimal price;
    private Promotion promotion;

    public ProductResponseDTO(Product product) {
        this.idProduct = product.getIdProduct();
        this.name = product.getName();
        this.price = product.getPrice();
        this.promotion = product.getPromotion();
    }

    public static List<ProductResponseDTO> convertList(List<Product> products) {
        return products.stream().map(ProductResponseDTO::new).collect(Collectors.toList());
    }
}
