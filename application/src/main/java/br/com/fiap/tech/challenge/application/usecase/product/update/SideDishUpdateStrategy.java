package br.com.fiap.tech.challenge.application.usecase.product.update;

import br.com.fiap.tech.challenge.application.dto.UpdateProductDTO;
import br.com.fiap.tech.challenge.enterprise.entity.SideDish;
import br.com.fiap.tech.challenge.enterprise.valueobject.Image;
import br.com.fiap.tech.challenge.enterprise.valueobject.Price;

import static br.com.fiap.tech.challenge.util.Moneys.makeMoney;

class SideDishUpdateStrategy extends AbstractProductUpdateStrategy<SideDish> {
    public SideDishUpdateStrategy(UpdateProductDTO request) {
        super(SideDish.class, request);
    }

    @Override
    protected SideDish doUpdate(SideDish sideDish) {
        var builder = sideDish.toBuilder();

        updateName(builder::name);
        updateDescription(builder::description);
        updateEnabled(builder::enabled);
        updatePrice(price -> builder.price(Price.of(makeMoney(price))));
        updateImage(image -> builder.image(Image.of(image)));

        return builder.build();
    }
}
