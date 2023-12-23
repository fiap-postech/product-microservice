package br.com.fiap.tech.challenge.adapter.controller.product;

import br.com.fiap.tech.challenge.adapter.dto.ProductDTO;
import br.com.fiap.tech.challenge.application.dto.UpdateProductDTO;

public interface UpdateProductController {

    ProductDTO update(UpdateProductDTO request);

}
