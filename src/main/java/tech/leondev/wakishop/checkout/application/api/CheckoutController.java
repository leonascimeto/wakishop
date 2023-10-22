package tech.leondev.wakishop.checkout.application.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;
import tech.leondev.wakishop.checkout.application.service.ShoppingCartService;
import tech.leondev.wakishop.checkout.domain.ShoppingCart;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@RestController
public class CheckoutController implements CheckoutAPI{
    private final ShoppingCartService shoppingCartService;
    @Override
    public void addItem(CartItemRequestDTO cartItemRequestDTO) {
        log.info("[start] CheckoutController - addItem");
        shoppingCartService.addItem(cartItemRequestDTO);
        log.info("[end] CheckoutController - addItem");
    }

    @Override
    public void removeItem(CartItemRequestDTO cartItemRequestDTO) {
        log.info("[start] CheckoutController - removeItem");
        shoppingCartService.removeItem(cartItemRequestDTO);
        log.info("[end] CheckoutController - removeItem");
    }

    @Override
    public List<ShoppingCartResponseDTO> listShoppingCarts() {
        log.info("[start] CheckoutController - listShoppingCarts");
        List<ShoppingCart> shoppingCarts =  shoppingCartService.listShoppingCart();
        log.info("[end] CheckoutController - listShoppingCarts");
        return ShoppingCartResponseDTO.convertList(shoppingCarts);
    }
}
