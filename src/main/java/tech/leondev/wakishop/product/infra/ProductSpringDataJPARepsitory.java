package tech.leondev.wakishop.product.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.leondev.wakishop.product.domain.Product;

import java.util.UUID;

public interface ProductSpringDataJPARepsitory extends JpaRepository<Product, UUID> {
}
