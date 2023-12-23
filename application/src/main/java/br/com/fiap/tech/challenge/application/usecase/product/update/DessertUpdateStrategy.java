package br.com.fiap.tech.challenge.application.usecase.product.update;

import br.com.fiap.tech.challenge.application.dto.UpdateProductDTO;
import br.com.fiap.tech.challenge.enterprise.entity.Dessert;
import br.com.fiap.tech.challenge.enterprise.valueobject.Image;
import br.com.fiap.tech.challenge.enterprise.valueobject.Price;

import static br.com.fiap.tech.challenge.util.Moneys.makeMoney;

class DessertUpdateStrategy extends AbstractProductUpdateStrategy<Dessert> {
    public DessertUpdateStrategy(UpdateProductDTO request) {
        super(Dessert.class, request);
    }

    @Override
    protected Dessert doUpdate(Dessert dessert) {
        var builder = dessert.toBuilder();

        updateName(builder::name);
        updateDescription(builder::description);
        updateEnabled(builder::enabled);
        updatePrice(price -> builder.price(Price.of(makeMoney(price))));
        updateImage(image -> builder.image(Image.of(image)));

        return builder.build();
    }
}
