package tech.leondev.wakishop.product.application.service;

import tech.leondev.wakishop.product.domain.Product;

import java.util.List;

public interface ProductService {
    Product save(Product product);

    List<Product> list();
}
