package br.com.fiap.tech.challenge.adapter.controller.product;

import br.com.fiap.tech.challenge.adapter.dto.ProductDTO;

public interface ManageProductController {

    ProductDTO enable(String uuid);

    ProductDTO disable(String uuid);

}
