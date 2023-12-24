package br.com.fiap.tech.challenge.rest.mapping;

import br.com.fiap.tech.challenge.application.dto.UpdateProductDTO;
import br.com.fiap.tech.challenge.rest.resource.request.UpdateProductRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface UpdateProductMapper {

    UpdateProductMapper INSTANCE = Mappers.getMapper(UpdateProductMapper.class);

    UpdateProductDTO toDTO(UpdateProductRequest request);
}
