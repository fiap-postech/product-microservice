package br.com.fiap.tech.challenge.adapter.gateway.product.writer;

import br.com.fiap.tech.challenge.adapter.dto.ComboDTO;
import br.com.fiap.tech.challenge.adapter.mapping.ComboMapper;
import br.com.fiap.tech.challenge.adapter.repository.ProductWriterRepository;
import br.com.fiap.tech.challenge.enterprise.entity.Combo;

class ComboWriter implements ProductWriter<Combo>{
    @Override
    public Combo write(ProductWriterRepository repository, Combo product) {
        var mapper = ComboMapper.INSTANCE;

        var savedProduct = repository.save(mapper.toDTO(product));

        return mapper.toDomain((ComboDTO) savedProduct);
    }
}
