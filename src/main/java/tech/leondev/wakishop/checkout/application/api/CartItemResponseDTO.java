package tech.leondev.wakishop.checkout.application.api;

import lombok.Value;
import tech.leondev.wakishop.checkout.domain.CartItem;
import tech.leondev.wakishop.product.application.api.ProductResponseDTO;
import tech.leondev.wakishop.product.domain.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Value
public class CartItemResponseDTO {
    private ProductResponseDTO product;
    private int quantity;
    private BigDecimal price;

    public CartItemResponseDTO(CartItem cartItem){
        this.product = new ProductResponseDTO(cartItem.getProduct());
        this.quantity = cartItem.getQuantity();
        this.price = cartItem.getPrice();
    }

    public static List<CartItemResponseDTO> convertList(List<CartItem> cartItems){
        return cartItems.stream().map(CartItemResponseDTO::new).collect(Collectors.toList());
    }
}
