package br.com.fiap.tech.challenge.adapter.gateway.product.writer;

import br.com.fiap.tech.challenge.adapter.dto.ProductDTO;
import br.com.fiap.tech.challenge.adapter.mapping.BeverageMapper;
import br.com.fiap.tech.challenge.enterprise.entity.Beverage;

class BeverageWriter extends SingleProductWriter<Beverage> {

    @Override
    ProductDTO toDTO(Beverage product) {
        return BeverageMapper.INSTANCE.toDTO(product);
    }

    @Override
    Beverage toDomain(ProductDTO dto) {
        return BeverageMapper.INSTANCE.toDomain(dto);
    }
}
