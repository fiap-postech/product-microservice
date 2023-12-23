package br.com.fiap.tech.challenge.application.usecase.product;

import br.com.fiap.tech.challenge.application.dto.UpdateProductDTO;
import br.com.fiap.tech.challenge.application.gateway.ProductReaderGateway;
import br.com.fiap.tech.challenge.application.gateway.ProductWriterGateway;
import br.com.fiap.tech.challenge.application.usecase.product.update.UpdateStrategyFactory;
import br.com.fiap.tech.challenge.enterprise.entity.Product;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
class UpdateProductUseCaseImpl implements UpdateProductUseCase {

    private final ProductReaderGateway readerService;
    private final ProductWriterGateway writerService;

    @Override
    public Product update(UpdateProductDTO request) {
        var storedProduct = readerService.readById(UUID.fromString(request.getId()));

        var strategy = UpdateStrategyFactory.getStrategy(storedProduct.category(), request);

        return writerService.write(strategy.update(storedProduct));
    }
}
