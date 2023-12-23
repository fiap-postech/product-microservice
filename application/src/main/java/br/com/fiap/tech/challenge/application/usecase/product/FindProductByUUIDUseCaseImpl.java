package br.com.fiap.tech.challenge.application.usecase.product;

import br.com.fiap.tech.challenge.application.gateway.ProductReaderGateway;
import br.com.fiap.tech.challenge.enterprise.entity.Product;
import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
class FindProductByUUIDUseCaseImpl implements FindProductByUUIDUseCase {

    private ProductReaderGateway readerService;

    @Override
    public Product get(UUID uuid) {
        return readerService.readById(uuid);
    }
}
