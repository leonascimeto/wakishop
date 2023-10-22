package tech.leondev.wakishop.checkout.application.service;

import tech.leondev.wakishop.checkout.application.api.CartItemRequestDTO;
import tech.leondev.wakishop.checkout.application.api.ShoppingCartResponseDTO;
import tech.leondev.wakishop.checkout.domain.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    ShoppingCart saveShoppingCart(ShoppingCart shoppingCart);
    List<ShoppingCart> listShoppingCart();
    public ShoppingCart getActiveShoppingCart();
    void addItem(CartItemRequestDTO cartItemRequestDTO);
}
