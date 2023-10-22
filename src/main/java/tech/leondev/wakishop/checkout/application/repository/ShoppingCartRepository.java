package tech.leondev.wakishop.checkout.application.repository;

import tech.leondev.wakishop.checkout.domain.ShoppingCart;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartRepository {

    List<ShoppingCart> listShoppingCarts();

    ShoppingCart saveShoppinCart(ShoppingCart shoppingCart);
}
