package br.com.fiap.tech.challenge.adapter.repository;

import br.com.fiap.tech.challenge.adapter.dto.ProductDTO;
import br.com.fiap.tech.challenge.enterprise.enums.ProductCategory;
import br.com.fiap.tech.challenge.application.util.Page;
import br.com.fiap.tech.challenge.application.util.ResponseList;

public interface ProductReaderRepository {

    ResponseList<ProductDTO> readAll(Page page);

    ResponseList<ProductDTO> readAllByCategory(ProductCategory category, Page page);

    ProductDTO readById(String id);

}
