package tech.leondev.wakishop.checkout.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.leondev.wakishop.checkout.domain.ShoppingCart;

import java.util.UUID;

public interface ShoppingCartSpringDataJPARepository extends JpaRepository<ShoppingCart, UUID> {
}
