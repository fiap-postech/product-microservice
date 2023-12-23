package br.com.fiap.tech.challenge.adapter.gateway.product.writer;

import br.com.fiap.tech.challenge.adapter.dto.ProductDTO;
import br.com.fiap.tech.challenge.adapter.mapping.DessertMapper;
import br.com.fiap.tech.challenge.enterprise.entity.Dessert;

class DessertWriter extends SingleProductWriter<Dessert> {

    @Override
    ProductDTO toDTO(Dessert product) {
        return DessertMapper.INSTANCE.toDTO(product);
    }

    @Override
    Dessert toDomain(ProductDTO dto) {
        return DessertMapper.INSTANCE.toDomain(dto);
    }
}
