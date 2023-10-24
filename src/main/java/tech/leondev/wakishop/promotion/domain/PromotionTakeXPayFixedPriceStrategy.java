package tech.leondev.wakishop.promotion.domain;

import tech.leondev.wakishop.checkout.domain.CartItem;

import java.math.BigDecimal;

public class PromotionTakeXPayFixedPriceStrategy implements PromotionStrategy {
    @Override
    public BigDecimal applyPromotion(CartItem cartItem) {
        int take = cartItem.getProduct().getPromotion().getTake();
        BigDecimal fixedPrice = cartItem.getProduct().getPromotion().getFixedPrice();
        int takeGroup = cartItem.getQuantity() / take;
        int rest = cartItem.getQuantity() % take;
        return BigDecimal.valueOf(takeGroup * fixedPrice.doubleValue() + rest * cartItem.getProduct().getPrice().doubleValue());
    }
}
