package br.com.fiap.tech.challenge.application.usecase.product.update;

import br.com.fiap.tech.challenge.application.dto.UpdateProductDTO;
import br.com.fiap.tech.challenge.enterprise.entity.Product;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.function.Consumer;

@RequiredArgsConstructor
abstract class AbstractProductUpdateStrategy<T extends Product> implements UpdateStrategy {

    protected final Class<T> type;
    protected final UpdateProductDTO request;

    protected void updateName(Consumer<String> nameConsumer){
        Optional.ofNullable(request.getName()).ifPresent(nameConsumer);
    }

    protected void updateDescription(Consumer<String> descriptionConsumer){
        Optional.ofNullable(request.getDescription()).ifPresent(descriptionConsumer);
    }

    protected void updateImage(Consumer<String> imageConsumer){
        Optional.ofNullable(request.getImage()).ifPresent(imageConsumer);
    }

    protected void updatePrice(Consumer<BigDecimal> priceConsumer){
        Optional.ofNullable(request.getPrice()).ifPresent(priceConsumer);
    }

    protected void updateEnabled(Consumer<Boolean> enabledConsumer){
        Optional.ofNullable(request.getEnabled()).ifPresent(enabledConsumer);
    }

    protected abstract T doUpdate(T product);

    @Override
    @SuppressWarnings({"unchecked"})
    public Product update(Product product) {
        if (type.isAssignableFrom(product.getClass())){
            return doUpdate((T) product);
        }


        return product;
    }
}
