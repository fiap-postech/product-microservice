package br.com.fiap.tech.challenge.application.usecase.product;

import br.com.fiap.tech.challenge.application.dto.UpdateProductDTO;
import br.com.fiap.tech.challenge.enterprise.entity.Product;

public interface UpdateProductUseCase {

    Product update(UpdateProductDTO request);

}
