package tech.leondev.wakishop.product.application.api;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;
import tech.leondev.wakishop.product.application.service.ProductService;
import tech.leondev.wakishop.product.domain.Product;

import java.util.List;

@RequiredArgsConstructor
@Log4j2
@RestController
public class ProductController implements ProductAPI {
    private final ProductService productService;
    @Override
    public ProductResponseDTO save(ProductRequestDTO productRequestDTO) {
        log.info("[start] ProductController - save");
        Product product = productService.save(new Product(productRequestDTO));
        log.info("[end] ProductController - save");
        return new ProductResponseDTO(product);
    }

    @Override
    public List<ProductResponseDTO> list() {
        log.info("[start] ProductController - list");
        List<Product> products = productService.list();
        log.info("[end] ProductController - list");
        return ProductResponseDTO.convertList(products);
    }
}
