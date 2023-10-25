package tech.leondev.wakishop.checkout.application.api;

import lombok.Value;
import tech.leondev.wakishop.checkout.domain.ShoppingCart;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Value
public class ShoppingCartResponseDTO {
    private BigDecimal totalPrice;
    private List<CartItemResponseDTO> cartItems;

    public ShoppingCartResponseDTO(ShoppingCart shoppingCart){
        this.totalPrice = shoppingCart.getTotalPrice();
        this.cartItems = CartItemResponseDTO.convertList(shoppingCart.getCartItems());
    }

    public static List<ShoppingCartResponseDTO> convertList(List<ShoppingCart> shoppingCarts) {
        return shoppingCarts.stream().map(ShoppingCartResponseDTO::new).collect(Collectors.toList());
    }
}
