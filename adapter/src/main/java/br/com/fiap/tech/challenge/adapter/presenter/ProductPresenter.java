package br.com.fiap.tech.challenge.adapter.presenter;

import br.com.fiap.tech.challenge.adapter.dto.ProductDTO;
import br.com.fiap.tech.challenge.enterprise.entity.Product;
import br.com.fiap.tech.challenge.application.util.ResponseList;

public interface ProductPresenter {

    ProductDTO present(Product product);

    ResponseList<ProductDTO> present(ResponseList<Product> list);

}
