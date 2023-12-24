package br.com.fiap.tech.challenge.rest.util;

import br.com.fiap.tech.challenge.enterprise.enums.ProductCategory;
import br.com.fiap.tech.challenge.enterprise.valueobject.Price;
import br.com.fiap.tech.challenge.rest.resource.request.CreateSingleProductRequest;
import org.instancio.Instancio;
import org.instancio.Model;

import static org.instancio.Select.field;

public abstract class CreateSingleProductRequestInstance {

    private CreateSingleProductRequestInstance() {}

    private static Model<CreateSingleProductRequest> defaultModel() {
        return Instancio.of(CreateSingleProductRequest.class)
                .set(field(CreateSingleProductRequest::getName), "Bata Frita")
                .set(field(CreateSingleProductRequest::getDescription), "Uma bela porção de batata sequinha")
                .set(field(CreateSingleProductRequest::getPrice), Price.min())
                .set(field(CreateSingleProductRequest::getImage), "http://localhost:8888/fritas.png")
                .set(field(CreateSingleProductRequest::getCategory), ProductCategory.SIDE_DISH)
                .toModel();
    }

    public static CreateSingleProductRequest deafult() {
        return Instancio.of(defaultModel())
                .create();
    }
}