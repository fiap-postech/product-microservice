package br.com.fiap.tech.challenge.rest.util;

import br.com.fiap.tech.challenge.application.dto.CreateSingleProductDTO;
import br.com.fiap.tech.challenge.enterprise.enums.ProductCategory;
import br.com.fiap.tech.challenge.enterprise.valueobject.Price;
import org.instancio.Instancio;
import org.instancio.Model;

import static org.instancio.Select.field;

public class CreateSingleProductDTOInstance {

    private CreateSingleProductDTOInstance() {}

    private static Model<CreateSingleProductDTO> defaultModel() {
        return Instancio.of(CreateSingleProductDTO.class)
                .set(field(CreateSingleProductDTO::getName), "Bata Frita")
                .set(field(CreateSingleProductDTO::getDescription), "Uma bela porção de batata sequinha")
                .set(field(CreateSingleProductDTO::getPrice), Price.min())
                .set(field(CreateSingleProductDTO::getImage), "http://localhost:8888/fritas.png")
                .set(field(CreateSingleProductDTO::getCategory), ProductCategory.SIDE_DISH)
                .toModel();
    }

    public static CreateSingleProductDTO getDefault() {
        return Instancio.of(defaultModel())
                .create();
    }
}