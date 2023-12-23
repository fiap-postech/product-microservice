package br.com.fiap.tech.challenge.application.usecase.product;

import br.com.fiap.tech.challenge.application.gateway.ProductReaderGateway;
import br.com.fiap.tech.challenge.application.gateway.ProductWriterGateway;
import br.com.fiap.tech.challenge.enterprise.entity.Product;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
class EnableProductUseCaseImpl implements EnableProductUseCase {

    private final ProductReaderGateway readerGateway;
    private final ProductWriterGateway writerGateway;

    @Override
    public Product enable(String uuid) {
        var product = readerGateway.readById(UUID.fromString(uuid));
        return writerGateway.write(product.enable());
    }
}
