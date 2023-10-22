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
        Optional<CartItem> existingItem = findItemByProduct(cartItem.getProduct());
        if (existingItem.isPresent()) {
            existingItem.get().incrementQuantity(cartItem.getQuantity());
            existingItem.get().calculatePrice();
        } else {
            cartItems.add(cartItem);
            cartItem.calculatePrice();
        }
        calculateTotalPrice();
    }

    public void removeItem(CartItem cartItem){
        Optional<CartItem> existingItem = findItemByProduct(cartItem.getProduct());

        existingItem.ifPresent(item -> {
            item.decrementQuantity(cartItem.getQuantity());
            if (item.getQuantity() == 0) cartItems.remove(item);
            item.calculatePrice();
        });
        calculateTotalPrice();
    }

    private void calculateTotalPrice(){
        this.totalPrice = cartItems.stream()
                .map(item -> item.getPrice())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Optional<CartItem> findItemByProduct(Product product) {
        return cartItems.stream()
                .filter(item -> item.getProduct().equals(product))
                .findFirst();
    }
}
