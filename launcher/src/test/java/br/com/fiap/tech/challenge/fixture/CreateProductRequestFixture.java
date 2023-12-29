package br.com.fiap.tech.challenge.fixture;

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
                .set(field(CreateComboProductRequest::getBeverageId), "e122debc-28ed-4475-a4e3-e1ad14468381")
                .set(field(CreateComboProductRequest::getSandwichId), "69874a3f-b76e-4ac5-ba18-a19b979504cb")
                .set(field(CreateComboProductRequest::getSideDishId), "ade7f71c-5642-4fff-9385-4b983a0f9a7d")
                .toModel();
    }
}