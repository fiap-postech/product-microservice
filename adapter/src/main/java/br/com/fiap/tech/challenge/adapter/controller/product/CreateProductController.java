package br.com.fiap.tech.challenge.adapter.controller.product;

import br.com.fiap.tech.challenge.adapter.dto.ProductDTO;
import br.com.fiap.tech.challenge.application.dto.CreateProductDTO;

public interface CreateProductController {

    ProductDTO create(CreateProductDTO productDTO);

}
