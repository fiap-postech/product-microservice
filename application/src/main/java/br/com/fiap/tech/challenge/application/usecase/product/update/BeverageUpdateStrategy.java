package br.com.fiap.tech.challenge.application.usecase.product.update;

import br.com.fiap.tech.challenge.application.dto.UpdateProductDTO;
import br.com.fiap.tech.challenge.enterprise.entity.Beverage;
import br.com.fiap.tech.challenge.enterprise.valueobject.Image;
import br.com.fiap.tech.challenge.enterprise.valueobject.Price;

import static br.com.fiap.tech.challenge.util.Moneys.makeMoney;

class BeverageUpdateStrategy extends AbstractProductUpdateStrategy<Beverage> {
    public BeverageUpdateStrategy(UpdateProductDTO request) {
        super(Beverage.class, request);
    }

    @Override
    protected Beverage doUpdate(Beverage beverage) {
        var builder = beverage.toBuilder();

        updateName(builder::name);
        updateDescription(builder::description);
        updateEnabled(builder::enabled);
        updatePrice(price -> builder.price(Price.of(makeMoney(price))));
        updateImage(image -> builder.image(Image.of(image)));

        return builder.build();
    }
}
