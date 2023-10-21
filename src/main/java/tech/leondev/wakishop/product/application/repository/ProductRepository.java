package tech.leondev.wakishop.product.application.repository;

import tech.leondev.wakishop.product.domain.Product;

import java.util.List;

public interface ProductRepository {
    Product save(Product product);

    List<Product> findAll();
}
