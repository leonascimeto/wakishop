package tech.leondev.wakishop.product.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import tech.leondev.wakishop.product.application.api.ProductRequestDTO;
import tech.leondev.wakishop.product.application.repository.ProductRepository;
import tech.leondev.wakishop.product.domain.Product;

import java.util.List;
import java.util.UUID;

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

    @Override
    public List<Product> list() {
        log.info("[start] ProductApplicationService - list");
        List<Product> products = productRepository.findAll();
        log.info("[end] ProductApplicationService - list");
        return products;
    }

    @Override
    public Product findById(UUID idProduct) {
        log.info("[start] ProductApplicationService - findById");
        Product product = productRepository.findById(idProduct);
        log.info("[end] ProductApplicationService - findById");
        return product;
    }

    @Override
    public void update(ProductRequestDTO productRequestDTO, UUID idProduct) {
        log.info("[start] ProductApplicationService - update");
        Product product = this.findById(idProduct);
        product.update(productRequestDTO);
        this.save(product);
        log.info("[end] ProductApplicationService - update");
    }
}
