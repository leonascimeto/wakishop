package tech.leondev.wakishop.product.application.repository;

import tech.leondev.wakishop.product.domain.Product;

public interface ProductRepository {
    Product save(Product product);
}
