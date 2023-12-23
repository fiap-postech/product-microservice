package br.com.fiap.tech.challenge.adapter.gateway.product.writer;

import br.com.fiap.tech.challenge.adapter.dto.ProductDTO;
import br.com.fiap.tech.challenge.adapter.mapping.SandwichMapper;
import br.com.fiap.tech.challenge.enterprise.entity.Sandwich;

class SandwichWriter extends SingleProductWriter<Sandwich> {
    @Override
    ProductDTO toDTO(Sandwich product) {
        return SandwichMapper.INSTANCE.toDTO(product);
    }

    @Override
    Sandwich toDomain(ProductDTO dto) {
        return SandwichMapper.INSTANCE.toDomain(dto);
    }
}
