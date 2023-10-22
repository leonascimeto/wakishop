package tech.leondev.wakishop.checkout.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tech.leondev.wakishop.checkout.application.api.ShoppingCartResponseDTO;
import tech.leondev.wakishop.product.domain.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Getter
@Table(name = "shopping_carts")
@Entity(name = "shopping_carts")
public class ShoppingCart{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, unique = true)
    private UUID idShoppingCart;
    @Column(name = "total_price")
    private BigDecimal totalPrice = BigDecimal.ZERO;

    @OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> cartItems = new ArrayList<>();

    public void addItem(CartItem cartItem) {
        for(CartItem item : this.cartItems){
            if(item.getProduct().equals(cartItem.getProduct())){
                item.incrementQuantity(cartItem.getQuantity());
                return;
            }
        }
        this.cartItems.add(cartItem);
    }
}
