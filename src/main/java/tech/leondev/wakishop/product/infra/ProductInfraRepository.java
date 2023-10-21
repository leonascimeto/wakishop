package tech.leondev.wakishop.product.infra;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
import tech.leondev.wakishop.product.application.repository.ProductRepository;
import tech.leondev.wakishop.product.domain.Product;

@Log4j2
@RequiredArgsConstructor
@Repository
public class ProductInfraRepository implements ProductRepository {
    private final ProductSpringDataJPARepsitory productSpringDataJPARepsitory;
    @Override
    public Product save(Product product) {
        log.info("[start] ProductInfraRepository - save");
        Product productSaved = productSpringDataJPARepsitory.save(product);
        log.info("[end] ProductInfraRepository - save");
        return productSaved;
    }
}
