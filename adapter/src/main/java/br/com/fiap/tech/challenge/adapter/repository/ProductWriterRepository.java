package br.com.fiap.tech.challenge.adapter.repository;

import br.com.fiap.tech.challenge.adapter.dto.ProductDTO;

public interface ProductWriterRepository {
    ProductDTO save(ProductDTO dto);
}
