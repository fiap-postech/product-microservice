package br.com.fiap.tech.challenge.adapter.controller.product;

import br.com.fiap.tech.challenge.adapter.dto.ProductDTO;

public interface FindProductByUUIDController {
    ProductDTO get(String uuid);
}
