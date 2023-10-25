package tech.leondev.wakishop.checkout.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import tech.leondev.wakishop.checkout.application.api.CartItemRequestDTO;
import tech.leondev.wakishop.handler.ApiException;
import tech.leondev.wakishop.product.domain.Product;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "cart_items")
@Entity(name = "cart_items")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, unique = true)
    private UUID idCartItem;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private int quantity;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "shopping_cart_id")
    private ShoppingCart shoppingCart;

    public CartItem(CartItemRequestDTO cartItemRequestDTO, Product product, ShoppingCart shoppingCart){
        this.product = product;
        this.quantity = cartItemRequestDTO.getQuantity();
        this.shoppingCart = shoppingCart;
        calculatePrice();
    }

    public void calculatePrice(){
        if(haveValidPromotion()){
            this.price =  this.product.getPromotion().getTypePromotion().applyPromotion(this);
            return;
        }
        this.price = this.product.getPrice().multiply(BigDecimal.valueOf(this.quantity));
    }

    public void incrementQuantity(int quantityToAdd){
        this.quantity += quantityToAdd;
    }

    public void decrementQuantity(int quantityToRemove){
        if(quantityToRemove > this.getQuantity()) this.quantity = 0;
        this.quantity -= quantityToRemove;
    }

    private boolean haveValidPromotion(){
        return this.product.getPromotion() != null &&
                this.quantity >= this.product.getPromotion().getTake();
    }
}
