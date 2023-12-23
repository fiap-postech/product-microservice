package br.com.fiap.tech.challenge.application.usecase.product;

import br.com.fiap.tech.challenge.application.dto.CreateProductDTO;
import br.com.fiap.tech.challenge.enterprise.entity.Product;

public interface CreateProductUseCase {

    Product create(CreateProductDTO dto);

}
