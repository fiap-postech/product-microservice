package br.com.fiap.tech.challenge.application.usecase.product.update;

import br.com.fiap.tech.challenge.application.dto.UpdateProductDTO;
import br.com.fiap.tech.challenge.enterprise.entity.Combo;
import br.com.fiap.tech.challenge.enterprise.valueobject.Image;
import br.com.fiap.tech.challenge.enterprise.valueobject.Price;

import static br.com.fiap.tech.challenge.util.Moneys.makeMoney;

class ComboUpdateStrategy extends AbstractProductUpdateStrategy<Combo> {
    public ComboUpdateStrategy(UpdateProductDTO request) {
        super(Combo.class, request);
    }

    @Override
    protected Combo doUpdate(Combo combo) {
        var builder = combo.toBuilder();

        updateName(builder::name);
        updateDescription(builder::description);
        updateEnabled(builder::enabled);
        updatePrice(price -> builder.price(Price.of(makeMoney(price))));
        updateImage(image -> builder.image(Image.of(image)));

        return builder.build();
    }
}
