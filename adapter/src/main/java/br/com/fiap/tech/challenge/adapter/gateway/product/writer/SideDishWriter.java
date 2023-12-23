package br.com.fiap.tech.challenge.adapter.gateway.product.writer;

import br.com.fiap.tech.challenge.adapter.dto.ProductDTO;
import br.com.fiap.tech.challenge.adapter.mapping.SideDishMapper;
import br.com.fiap.tech.challenge.enterprise.entity.SideDish;

class SideDishWriter extends SingleProductWriter<SideDish> {

    @Override
    ProductDTO toDTO(SideDish product) {
        return SideDishMapper.INSTANCE.toDTO(product);
    }

    @Override
    SideDish toDomain(ProductDTO dto) {
        return SideDishMapper.INSTANCE.toDomain(dto);
    }
}
