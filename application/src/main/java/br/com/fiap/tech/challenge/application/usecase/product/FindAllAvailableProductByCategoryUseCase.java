package br.com.fiap.tech.challenge.application.usecase.product;

import br.com.fiap.tech.challenge.enterprise.entity.Product;
import br.com.fiap.tech.challenge.enterprise.enums.ProductCategory;
import br.com.fiap.tech.challenge.application.util.Page;
import br.com.fiap.tech.challenge.application.util.ResponseList;

public interface FindAllAvailableProductByCategoryUseCase {
    ResponseList<Product> list(ProductCategory category, Page page);
}
