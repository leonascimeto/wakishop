package tech.leondev.wakishop.product.application.api;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;
import tech.leondev.wakishop.product.application.service.ProductService;
import tech.leondev.wakishop.product.domain.Product;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Log4j2
@RestController
public class ProductController implements ProductAPI {
    private final ProductService productService;
    @Override
    public ProductResponseDTO save(ProductRequestDTO productRequestDTO) {
        log.info("[start] ProductController - save");
        ProductResponseDTO response = productService.save(productRequestDTO);
        log.info("[end] ProductController - save");
        return response;
    }

    @Override
    public List<ProductResponseDTO> list() {
        log.info("[start] ProductController - list");
        List<ProductResponseDTO> products = productService.list();
        log.info("[end] ProductController - list");
        return products;
    }

    @Override
    public ProductResponseDTO findById(UUID idProduct) {
        log.info("[start] ProductController - findById");
        ProductResponseDTO product = productService.findById(idProduct);
        log.info("[end] ProductController - findById");
        return product;
    }

    @Override
    public void update(ProductRequestDTO productRequestDTO, UUID idProduct) {
        log.info("[start] ProductController - findById");
        productService.update(productRequestDTO, idProduct);
        log.info("[end] ProductController - findById");
    }

    @Override
    public void delete(UUID idProduct) {
        log.info("[start] ProductController - delete");
        productService.delete(idProduct);
        log.info("[end] ProductController - delete");
    }

    @Override
    public void insertPromotion(UUID idProduct, ProductInsertPromotionRequestDTO productInsertPromotionRequestDTO) {
        log.info("[start] ProductController - insertPromotion");
        productService.insertPromotion(idProduct, productInsertPromotionRequestDTO.getIdPromotion());
        log.info("[end] ProductController - insertPromotion");
    }

    @Override
    public void removePromotion(UUID idProduct) {
        log.info("[start] ProductController - removePromotion");
        productService.removePromotion(idProduct);
        log.info("[end] ProductController - removePromotion");
    }
}
