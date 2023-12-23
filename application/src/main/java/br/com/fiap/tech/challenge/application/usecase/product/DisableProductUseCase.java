package br.com.fiap.tech.challenge.application.usecase.product;

import br.com.fiap.tech.challenge.enterprise.entity.Product;

public interface DisableProductUseCase {
    Product disable(String uuid);
}
