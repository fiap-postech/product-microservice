package br.com.fiap.tech.challenge.adapter.gateway.product;

import br.com.fiap.tech.challenge.adapter.mapping.util.ProductMappers;
import br.com.fiap.tech.challenge.adapter.repository.ProductReaderRepository;
import br.com.fiap.tech.challenge.enterprise.entity.Product;
import br.com.fiap.tech.challenge.enterprise.enums.ProductCategory;
import br.com.fiap.tech.challenge.application.gateway.ProductReaderGateway;
import br.com.fiap.tech.challenge.application.util.Page;
import br.com.fiap.tech.challenge.application.util.ResponseList;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

import static br.com.fiap.tech.challenge.adapter.mapping.util.ProductMappers.toProductDomain;

@RequiredArgsConstructor
class ProductReaderGatewayImpl implements ProductReaderGateway {

    private final ProductReaderRepository repository;

    @Override
    public ResponseList<Product> readAll(Page page) {
        return ResponseList.from(repository.readAll(page), ProductMappers::toProductDomain);
    }

    @Override
    public ResponseList<Product> readAllByCategory(ProductCategory category, Page page) {
        return ResponseList.from(repository.readAllByCategory(category, page), ProductMappers::toProductDomain);
    }

    @Override
    public Product readById(UUID id) {
        return toProductDomain(repository.readById(id.toString()));
    }
}
