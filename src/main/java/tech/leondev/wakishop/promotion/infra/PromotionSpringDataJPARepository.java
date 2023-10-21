package tech.leondev.wakishop.promotion.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.leondev.wakishop.promotion.domain.Promotion;

import java.util.UUID;

public interface PromotionSpringDataJPARepository extends JpaRepository<Promotion, UUID> {
}
