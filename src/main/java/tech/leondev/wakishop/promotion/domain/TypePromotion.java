package tech.leondev.wakishop.promotion.domain;

import tech.leondev.wakishop.checkout.domain.CartItem;

import java.math.BigDecimal;

public enum TypePromotion {
    TAKE_X_PAY_Y(new PromotionTakeXPayYStrategy()),
    TAKE_X_PAY_FIXED_PRICE(new PromotionTakeXPayFixedPriceStrategy());

    private final PromotionStrategy strategy;

    TypePromotion(PromotionStrategy strategy){
        this.strategy = strategy;
    }

    public BigDecimal applyPromotion(CartItem cartItem){
        return strategy.applyPromotion(cartItem);
    }
}
