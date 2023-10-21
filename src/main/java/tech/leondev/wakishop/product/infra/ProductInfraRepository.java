package tech.leondev.wakishop.product.infra;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
import tech.leondev.wakishop.product.application.repository.ProductRepository;
import tech.leondev.wakishop.product.domain.Product;

import java.util.List;
import java.util.UUID;

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

    @Override
    public List<Product> findAll() {
        log.info("[start] ProductInfraRepository - findAll");
        List<Product> products = productSpringDataJPARepsitory.findAll();
        log.info("[end] ProductInfraRepository - findAll");
        return products;
    }

    @Override
    public Product findById(UUID idProduct) {
        log.info("[start] ProductInfraRepository - findById");
        Product product = productSpringDataJPARepsitory.findById(idProduct)
                        .orElseThrow(() -> new RuntimeException("Product not found"));
        log.info("[end] ProductInfraRepository - findById");
        return product;
    }
}
