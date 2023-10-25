package tech.leondev.wakishop.product.application.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Produtos", description = "Recurso relacionado ao gerenciamento de produtos.")
@RestController
@RequestMapping("v1/products")
public interface ProductAPI {
    @Operation(
            summary = "Registra produto",
            description = "Registra um novo produto no sistema. Para anexar a uma promoção já existente, basta informa o " +
                    "ID da promoção no campo idPromotion. Caso não queria anexar a uma promoção o campo idPromotion deve ser removido."
    )
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    ProductResponseDTO save(@RequestBody @Valid ProductRequestDTO productRequestDTO);

    @Operation(
            summary = "Lista produtos",
            description = "Retorna uma lista com todos os produtos registrados no sistema."
    )
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<ProductResponseDTO> list();

    @Operation(
            summary = "Bisca produto",
            description = "Busca um produto no sistema pelo ID."
    )
    @GetMapping("/{idProduct}")
    @ResponseStatus(HttpStatus.OK)
    ProductResponseDTO findById(@PathVariable UUID idProduct);

    @Operation(
            summary = "Altera produto",
            description = "Busca um produto pelo ID e realiza a alteração dos valores."
    )
    @PatchMapping("/{idProduct}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void update(@RequestBody @Valid ProductRequestDTO productRequestDTO, @PathVariable UUID idProduct);

    @Operation(
            summary = "Deleta produto",
            description = "Deleta um produto cadastrado no sistema pelo ID."
    )
    @DeleteMapping("/{idProduct}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable UUID idProduct);

    @Operation(
            summary = "Adicionar promoção ao produto",
            description = "Adiciona uma promoção a um produto."
    )
    @PatchMapping("/{idProduct}/promotions/insert")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void insertPromotion(@PathVariable UUID idProduct, @RequestBody @Valid ProductInsertPromotionRequestDTO productInsertPromotionRequestDTO);

    @Operation(
            summary = "Remove promoção do produto",
            description = "Remove uma promoção de um produto."
    )
    @PatchMapping("/{idProduct}/promotions/remove")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void removePromotion(@PathVariable UUID idProduct);
}
