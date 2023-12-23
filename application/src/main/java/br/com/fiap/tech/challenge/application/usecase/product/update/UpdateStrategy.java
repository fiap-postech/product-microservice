package br.com.fiap.tech.challenge.application.usecase.product.update;

import br.com.fiap.tech.challenge.enterprise.entity.Product;

public interface UpdateStrategy {
    Product update(Product product);
}
