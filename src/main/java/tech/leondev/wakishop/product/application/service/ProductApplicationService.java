package tech.leondev.wakishop.product.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import tech.leondev.wakishop.product.application.repository.ProductRepository;
import tech.leondev.wakishop.product.domain.Product;

@Log4j2
@RequiredArgsConstructor
@Service
public class ProductApplicationService implements ProductService{
    private final ProductRepository productRepository;
    @Override
    public Product save(Product product) {
        log.info("[start] ProductApplicationService - save");
        Product productSaved = productRepository.save(product);
        log.info("[end] ProductApplicationService - save");
        return productSaved;
    }
}
