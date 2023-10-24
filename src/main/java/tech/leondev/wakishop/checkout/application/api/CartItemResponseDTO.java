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
    private String item;
    private int quantity;
    private BigDecimal unitPrice;
    private BigDecimal totalPrice;
    private String promotion;

    public CartItemResponseDTO(CartItem cartItem){
        this.item = cartItem.getProduct().getName();
        this.quantity = cartItem.getQuantity();
        this.unitPrice = cartItem.getProduct().getPrice();
        this.totalPrice = cartItem.getPrice();
        this.promotion = cartItem.getProduct().getPromotion().getDescription();
    }

    public static List<CartItemResponseDTO> convertList(List<CartItem> cartItems){
        return cartItems.stream().map(CartItemResponseDTO::new).collect(Collectors.toList());
    }
}
