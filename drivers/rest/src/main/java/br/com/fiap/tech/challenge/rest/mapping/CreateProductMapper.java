package br.com.fiap.tech.challenge.rest.mapping;

import br.com.fiap.tech.challenge.application.dto.CreateComboProductDTO;
import br.com.fiap.tech.challenge.application.dto.CreateSingleProductDTO;
import br.com.fiap.tech.challenge.rest.resource.request.CreateComboProductRequest;
import br.com.fiap.tech.challenge.rest.resource.request.CreateSingleProductRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface CreateProductMapper {

    CreateProductMapper INSTANCE = Mappers.getMapper(CreateProductMapper.class);

    CreateSingleProductDTO fromRequest(CreateSingleProductRequest request);

    CreateComboProductDTO fromRequest(CreateComboProductRequest request);
}
