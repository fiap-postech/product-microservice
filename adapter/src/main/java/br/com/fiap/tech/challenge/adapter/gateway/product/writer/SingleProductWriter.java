package br.com.fiap.tech.challenge.adapter.gateway.product.writer;

import br.com.fiap.tech.challenge.adapter.dto.ProductDTO;
import br.com.fiap.tech.challenge.adapter.repository.ProductWriterRepository;
import br.com.fiap.tech.challenge.enterprise.entity.Product;

abstract class SingleProductWriter<T extends Product> implements ProductWriter<T> {

    abstract ProductDTO toDTO(T product);
    abstract T toDomain(ProductDTO dto);

    @Override
    public T write(ProductWriterRepository repository, T product) {
        var savedProduct = repository.save(toDTO(product));

        return toDomain(savedProduct);
    }
}
