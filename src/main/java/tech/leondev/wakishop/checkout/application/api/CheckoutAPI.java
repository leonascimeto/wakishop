package tech.leondev.wakishop.checkout.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/checkouts/carts/items")
public interface CheckoutAPI {
    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void addItem(@RequestBody @Valid CartItemRequestDTO cartItemRequestDTO);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<ShoppingCartResponseDTO> listShoppingCarts();

}
