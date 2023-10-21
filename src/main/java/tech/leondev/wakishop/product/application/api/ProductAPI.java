package tech.leondev.wakishop.product.application.api;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/products")
public interface ProductAPI {
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    ProductResponseDTO save(@RequestBody @Valid ProductRequestDTO productRequestDTO);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<ProductResponseDTO> list();
}
