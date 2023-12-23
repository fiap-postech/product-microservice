package br.com.fiap.tech.challenge.adapter.controller.product;

import br.com.fiap.tech.challenge.adapter.dto.ProductDTO;
import br.com.fiap.tech.challenge.enterprise.enums.ProductCategory;
import br.com.fiap.tech.challenge.application.util.Page;
import br.com.fiap.tech.challenge.application.util.ResponseList;

public interface FindAllAvailableProductByCategoryController {

    ResponseList<ProductDTO> list(ProductCategory category, Page page);
}
