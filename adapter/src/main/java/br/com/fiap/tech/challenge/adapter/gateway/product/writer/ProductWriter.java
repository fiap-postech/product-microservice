package br.com.fiap.tech.challenge.adapter.gateway.product.writer;

import br.com.fiap.tech.challenge.adapter.repository.ProductWriterRepository;

public interface ProductWriter<T> {

    T write(ProductWriterRepository repository, T product);

}
