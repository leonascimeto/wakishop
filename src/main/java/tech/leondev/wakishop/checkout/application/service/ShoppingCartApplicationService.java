package tech.leondev.wakishop.checkout.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import tech.leondev.wakishop.checkout.application.api.CartItemRequestDTO;
import tech.leondev.wakishop.checkout.application.api.ShoppingCartResponseDTO;
import tech.leondev.wakishop.checkout.application.repository.ShoppingCartRepository;
import tech.leondev.wakishop.checkout.domain.CartItem;
import tech.leondev.wakishop.checkout.domain.ShoppingCart;
import tech.leondev.wakishop.product.application.repository.ProductRepository;
import tech.leondev.wakishop.product.domain.Product;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Service
public class ShoppingCartApplicationService implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final ProductRepository productRepository;

    @Override
    public ShoppingCart saveShoppingCart(ShoppingCart shoppingCart) {
        log.info("[start] ShoppingCartApplicationService - saveShoppingCart");
        ShoppingCart shoppingCartSaved = shoppingCartRepository.saveShoppinCart(shoppingCart);
        log.info("[end] ShoppingCartApplicationService - saveShoppingCart");
        return shoppingCartSaved;
    }

    @Override
    public List<ShoppingCartResponseDTO> listShoppingCart() {
        log.info("[start] ShoppingCartApplicationService - listShoppingCart");
        List<ShoppingCart> shoppingCarts = shoppingCartRepository.listShoppingCarts();
        log.info("[end] ShoppingCartApplicationService - listShoppingCart");
        return ShoppingCartResponseDTO.convertList(shoppingCarts);
    }

    @Override
    public ShoppingCart getActiveShoppingCart(){
        List<ShoppingCart> shoppingCarts = shoppingCartRepository.listShoppingCarts();
        if(!shoppingCarts.isEmpty()) return shoppingCarts.get(0);
        return new ShoppingCart();
    }

    @Override
    public void addItem(CartItemRequestDTO cartItemRequestDTO) {
        log.info("[start] ShoppingCartApplicationService - addItem");
        ShoppingCart shoppingCart = this.getActiveShoppingCart();
        Product product = productRepository.findById(cartItemRequestDTO.getProductId());
        CartItem cartItem = new CartItem(cartItemRequestDTO, product, shoppingCart);
        shoppingCart.addItem(cartItem);
        log.info("[end] ShoppingCartApplicationService - addItem");
        this.saveShoppingCart(shoppingCart);
    }

    @Override
    public void removeItem(CartItemRequestDTO cartItemRequestDTO) {
        log.info("[start] ShoppingCartApplicationService - removeItem");
        ShoppingCart shoppingCart = this.getActiveShoppingCart();
        Product product = productRepository.findById(cartItemRequestDTO.getProductId());
        CartItem cartItem = new CartItem(cartItemRequestDTO, product, shoppingCart);
        shoppingCart.removeItem(cartItem);
        log.info("[end] ShoppingCartApplicationService - removeItem");
        this.saveShoppingCart(shoppingCart);
    }
}
