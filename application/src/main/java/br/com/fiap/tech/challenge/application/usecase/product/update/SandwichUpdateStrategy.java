package br.com.fiap.tech.challenge.application.usecase.product.update;

import br.com.fiap.tech.challenge.application.dto.UpdateProductDTO;
import br.com.fiap.tech.challenge.enterprise.entity.Sandwich;
import br.com.fiap.tech.challenge.enterprise.valueobject.Image;
import br.com.fiap.tech.challenge.enterprise.valueobject.Price;

import static br.com.fiap.tech.challenge.util.Moneys.makeMoney;

class SandwichUpdateStrategy extends AbstractProductUpdateStrategy<Sandwich> {
    public SandwichUpdateStrategy(UpdateProductDTO request) {
        super(Sandwich.class, request);
    }

    @Override
    protected Sandwich doUpdate(Sandwich sandwich) {
        var builder = sandwich.toBuilder();

        updateName(builder::name);
        updateDescription(builder::description);
        updateEnabled(builder::enabled);
        updatePrice(price -> builder.price(Price.of(makeMoney(price))));
        updateImage(image -> builder.image(Image.of(image)));

        return builder.build();
    }
}
