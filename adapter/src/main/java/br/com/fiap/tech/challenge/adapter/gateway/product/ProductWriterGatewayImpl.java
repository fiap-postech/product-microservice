package br.com.fiap.tech.challenge.adapter.gateway.product;

import br.com.fiap.tech.challenge.adapter.gateway.product.writer.ProductWriterFactory;
import br.com.fiap.tech.challenge.adapter.repository.ProductWriterRepository;
import br.com.fiap.tech.challenge.enterprise.entity.Product;
import br.com.fiap.tech.challenge.application.gateway.ProductWriterGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductWriterGatewayImpl implements ProductWriterGateway {

    private final ProductWriterRepository repository;

    @Override
    public Product write(Product product) {
        return ProductWriterFactory.getWriter(product).write(repository, product);
    }
}
