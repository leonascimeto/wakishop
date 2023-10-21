package tech.leondev.wakishop.product.application.service;

import tech.leondev.wakishop.product.application.api.ProductInsertPromotionRequestDTO;
import tech.leondev.wakishop.product.application.api.ProductRequestDTO;
import tech.leondev.wakishop.product.domain.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    Product save(Product product);

    List<Product> list();

    Product findById(UUID idProduct);

    void update(ProductRequestDTO productRequestDTO, UUID idProduct);

    void delete(UUID idProduct);

    void insertPromotion(UUID idProduct, ProductInsertPromotionRequestDTO promotionRequestDTO);

    void removePromotion(UUID idProduct);
}
