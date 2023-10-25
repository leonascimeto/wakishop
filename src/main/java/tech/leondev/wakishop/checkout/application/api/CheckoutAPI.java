package tech.leondev.wakishop.checkout.application.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Checkouts", description = "Recurso relacionado ao gerenciamento de carrinho de compra.")
@RestController
@RequestMapping("v1/checkouts/carts/items")
public interface CheckoutAPI {
    @Operation(
            summary = "Adiciona item ao carrinho",
            description = "Adiciona um produto ao carrinho, caso não exista um carrinho, um novo carrinho será criado" +
                    " já com o produto inserido."
    )
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void addItem(@RequestBody @Valid CartItemRequestDTO cartItemRequestDTO);

    @Operation(
            summary = "Remove item do carrinho",
            description = "remove um item do carrinho de compra."
    )
    @PatchMapping("/remove")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void removeItem(@RequestBody @Valid CartItemRequestDTO cartItemRequestDTO);

    @Operation(
            summary = "Lista carrinhos de compras",
            description = "Lista todos os carrinhos de compras registrados."
    )
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<ShoppingCartResponseDTO> listShoppingCarts();
}
