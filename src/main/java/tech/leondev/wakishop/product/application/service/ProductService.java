package tech.leondev.wakishop.product.application.service;

import tech.leondev.wakishop.product.application.api.ProductRequestDTO;
import tech.leondev.wakishop.product.application.api.ProductResponseDTO;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    ProductResponseDTO save(ProductRequestDTO productRequestDTO);

    List<ProductResponseDTO> list();

    ProductResponseDTO findById(UUID idProduct);

    void update(ProductRequestDTO productRequestDTO, UUID idProduct);

    void delete(UUID idProduct);

    void insertPromotion(UUID idProduct, UUID idPromotion);

    void removePromotion(UUID idProduct);
}
