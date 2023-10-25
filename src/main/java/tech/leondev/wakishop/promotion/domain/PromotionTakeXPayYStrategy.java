package tech.leondev.wakishop.promotion.domain;

import lombok.RequiredArgsConstructor;
import tech.leondev.wakishop.checkout.domain.CartItem;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class PromotionTakeXPayYStrategy implements PromotionStrategy {
    @Override
    public BigDecimal applyPromotion(CartItem cartItem) {
        int take = cartItem.getProduct().getPromotion().getTake();
        int pay = cartItem.getProduct().getPromotion().getPay();
        int groupsTake = cartItem.getQuantity() / take;
        int rest = cartItem.getQuantity() % take;
        return BigDecimal.valueOf((groupsTake * pay + rest) * cartItem.getProduct().getPrice().doubleValue());
    }
}
