package tech.leondev.wakishop.product.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import tech.leondev.wakishop.product.application.api.ProductRequestDTO;
import tech.leondev.wakishop.product.application.api.ProductResponseDTO;
import tech.leondev.wakishop.product.application.repository.ProductRepository;
import tech.leondev.wakishop.product.domain.Product;
import tech.leondev.wakishop.promotion.application.repository.PromotionRepository;
import tech.leondev.wakishop.promotion.domain.Promotion;

import java.util.List;
import java.util.UUID;

@Log4j2
@RequiredArgsConstructor
@Service
public class ProductApplicationService implements ProductService{
    private final ProductRepository productRepository;
    private final PromotionRepository promotionRepository;
    @Override
    public ProductResponseDTO save(ProductRequestDTO productRequestDTO) {
        log.info("[start] ProductApplicationService - save");
        Product product = new Product(productRequestDTO);
        if(productRequestDTO.getIdPromotion() != null) {
            Promotion promotion = promotionRepository.findById(productRequestDTO.getIdPromotion());
            product.insertPromotion(promotion);
        }
        log.info("[end] ProductApplicationService - save");
        Product productSaved = productRepository.save(product);
        return new ProductResponseDTO(productSaved);
    }

    @Override
    public List<ProductResponseDTO> list() {
        log.info("[start] ProductApplicationService - list");
        List<Product> products = productRepository.findAll();
        log.info("[end] ProductApplicationService - list");
        return ProductResponseDTO.convertList(products);
    }

    @Override
    public ProductResponseDTO findById(UUID idProduct) {
        log.info("[start] ProductApplicationService - findById");
        Product product = productRepository.findById(idProduct);
        log.info("[end] ProductApplicationService - findById");
        return new ProductResponseDTO(product);
    }

    @Override
    public void update(ProductRequestDTO productRequestDTO, UUID idProduct) {
        log.info("[start] ProductApplicationService - update");
        Product product = productRepository.findById(idProduct);
        product.update(productRequestDTO);
        productRepository.save(product);
        log.info("[end] ProductApplicationService - update");
    }

    @Override
    public void delete(UUID idProduct) {
        log.info("[start] ProductApplicationService - delete");
        Product product = productRepository.findById(idProduct);
        productRepository.delete(product);
        log.info("[end] ProductApplicationService - delete");
    }

    @Override
    public void insertPromotion(UUID idProduct, UUID idPromotion) {
        log.info("[start] ProductApplicationService - insertPromotion");
        Promotion promotion = promotionRepository.findById(idPromotion);
        Product product = productRepository.findById(idProduct);
        product.insertPromotion(promotion);
        productRepository.save(product);
        log.info("[end] ProductApplicationService - insertPromotion");
    }

    @Override
    public void removePromotion(UUID idProduct) {
        log.info("[start] ProductApplicationService - removePromotion");
        Product product = productRepository.findById(idProduct);
        product.removePromotion();
        productRepository.save(product);
        log.info("[end] ProductApplicationService - removePromotion");
    }
}
