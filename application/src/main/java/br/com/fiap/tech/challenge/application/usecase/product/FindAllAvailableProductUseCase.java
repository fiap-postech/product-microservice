package br.com.fiap.tech.challenge.application.usecase.product;

import br.com.fiap.tech.challenge.enterprise.entity.Product;
import br.com.fiap.tech.challenge.application.util.Page;
import br.com.fiap.tech.challenge.application.util.ResponseList;

public interface FindAllAvailableProductUseCase {

    ResponseList<Product> list(Page page);

}
