package br.com.fiap.tech.challenge.rest.util;

import br.com.fiap.tech.challenge.enterprise.enums.ProductCategory;
import br.com.fiap.tech.challenge.rest.resource.request.CreateComboProductRequest;
import br.com.fiap.tech.challenge.rest.resource.request.CreateSingleProductRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.instancio.Instancio;
import org.instancio.Model;

import java.math.BigDecimal;
import java.util.UUID;

import static org.instancio.Select.field;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public abstract class CreateProductRequestFixture {

    public static Model<CreateSingleProductRequest> singleProductRequestModel() {
        return Instancio.of(CreateSingleProductRequest.class)
                .set(field(CreateSingleProductRequest::getName), "Bata Frita")
                .set(field(CreateSingleProductRequest::getDescription), "Uma bela porção de batata sequinha")
                .set(field(CreateSingleProductRequest::getPrice), BigDecimal.valueOf(5.00))
                .set(field(CreateSingleProductRequest::getImage), "http://localhost:8888/fritas.png")
                .set(field(CreateSingleProductRequest::getCategory), ProductCategory.SIDE_DISH)
                .toModel();
    }

    public static Model<CreateComboProductRequest> comboProductRequestModel() {
        return Instancio.of(CreateComboProductRequest.class)
                .set(field(CreateComboProductRequest::getName), "Combo Triplo X")
                .set(field(CreateComboProductRequest::getDescription), "Hamburguer Triplo X + Batata e Refri")
                .set(field(CreateComboProductRequest::getPrice), BigDecimal.valueOf(25.00))
                .set(field(CreateComboProductRequest::getImage), "http://localhost:8888/combo.png")
                .set(field(CreateComboProductRequest::getCategory), ProductCategory.COMBO)
                .set(field(CreateComboProductRequest::getBeverageId), UUID.randomUUID().toString())
                .set(field(CreateComboProductRequest::getSandwichId), UUID.randomUUID().toString())
                .set(field(CreateComboProductRequest::getSideDishId), UUID.randomUUID().toString())
                .toModel();
    }
}