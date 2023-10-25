package tech.leondev.wakishop.promotion.domain;

import tech.leondev.wakishop.checkout.domain.CartItem;

import java.math.BigDecimal;

public interface PromotionStrategy {
    BigDecimal applyPromotion(CartItem cartItem);
}
