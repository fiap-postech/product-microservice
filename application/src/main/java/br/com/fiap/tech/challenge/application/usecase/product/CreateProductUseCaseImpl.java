package br.com.fiap.tech.challenge.application.usecase.product;

import br.com.fiap.tech.challenge.application.dto.CreateComboProductDTO;
import br.com.fiap.tech.challenge.application.dto.CreateProductDTO;
import br.com.fiap.tech.challenge.application.dto.CreateSingleProductDTO;
import br.com.fiap.tech.challenge.application.gateway.ProductReaderGateway;
import br.com.fiap.tech.challenge.application.gateway.ProductWriterGateway;
import br.com.fiap.tech.challenge.application.mapper.CreateBeverageMapper;
import br.com.fiap.tech.challenge.application.mapper.CreateComboMapper;
import br.com.fiap.tech.challenge.application.mapper.CreateDessertMapper;
import br.com.fiap.tech.challenge.application.mapper.CreateSandwichMapper;
import br.com.fiap.tech.challenge.application.mapper.CreateSideDishMapper;
import br.com.fiap.tech.challenge.enterprise.entity.Beverage;
import br.com.fiap.tech.challenge.enterprise.entity.Product;
import br.com.fiap.tech.challenge.enterprise.entity.Sandwich;
import br.com.fiap.tech.challenge.enterprise.entity.SideDish;
import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
class CreateProductUseCaseImpl implements CreateProductUseCase {

    private ProductWriterGateway writerGateway;
    private ProductReaderGateway readerGateway;

    @Override
    public Product create(CreateProductDTO dto) {
        if (dto instanceof CreateComboProductDTO requestCombo) {
            return createComboProduct(requestCombo);
        }

        if (dto instanceof CreateSingleProductDTO requestSingle) {
            return createSingleProduct(requestSingle);
        }

        throw new IllegalStateException();
    }

    private Product createSingleProduct(CreateSingleProductDTO dto) {
        return writerGateway.write(mapProduct(dto));
    }

    private Product mapProduct(CreateSingleProductDTO dto) {
        return switch (dto.getCategory()){
            case SANDWICH -> CreateSandwichMapper.INSTANCE.toSandwich(dto);
            case BEVERAGE -> CreateBeverageMapper.INSTANCE.toBeverage(dto);
            case DESSERT -> CreateDessertMapper.INSTANCE.toDessert(dto);
            case SIDE_DISH -> CreateSideDishMapper.INSTANCE.toSideDish(dto);
            case COMBO -> throw new IllegalStateException();
        };
    }

    private Product createComboProduct(CreateComboProductDTO dto) {
        var product = CreateComboMapper.INSTANCE.toCombo(dto);

        product = product.toBuilder()
                .beverage((Beverage) readerGateway.readById(UUID.fromString(dto.getBeverageId())))
                .sandwich((Sandwich) readerGateway.readById(UUID.fromString(dto.getSandwichId())))
                .sideDish((SideDish) readerGateway.readById(UUID.fromString(dto.getSideDishId())))
                .build();

        product.validate();

        return writerGateway.write(product);
    }
}
