package tech.leondev.wakishop.checkout.infra;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
import tech.leondev.wakishop.checkout.application.repository.ShoppingCartRepository;
import tech.leondev.wakishop.checkout.domain.ShoppingCart;

import java.util.List;
import java.util.Optional;

@Log4j2
@RequiredArgsConstructor
@Repository
public class ShoppingCartInfraRepository implements ShoppingCartRepository {
    private final ShoppingCartSpringDataJPARepository shoppingCartSpringDataJPARepository;

    @Override
    public List<ShoppingCart> listShoppingCarts() {
        log.info("[start] ShoppingCartInfraRepository - listShoppingCarts");
        List<ShoppingCart> shoppingCarts = shoppingCartSpringDataJPARepository.findAll();
        log.info("[start] ShoppingCartInfraRepository - listShoppingCarts");
        return shoppingCarts;
    }

    @Override
    public ShoppingCart saveShoppinCart(ShoppingCart shoppingCart) {
        log.info("[start] ShoppingCartInfraRepository - saveShoppinCart");
        ShoppingCart shoppingCartSaved = shoppingCartSpringDataJPARepository.save(shoppingCart);
        log.info("[end] ShoppingCartInfraRepository - saveShoppinCart");
        return shoppingCartSaved;
    }
}
