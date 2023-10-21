package tech.leondev.wakishop.product.application.repository;

import tech.leondev.wakishop.product.domain.Product;

import java.util.List;
import java.util.UUID;

public interface ProductRepository {
    Product save(Product product);

    List<Product> findAll();

    Product findById(UUID idProduct);

    void delete(Product product);
}
