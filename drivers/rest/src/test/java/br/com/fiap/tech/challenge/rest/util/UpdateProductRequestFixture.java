package br.com.fiap.tech.challenge.rest.util;

import br.com.fiap.tech.challenge.adapter.dto.ProductDTO;
import br.com.fiap.tech.challenge.rest.resource.request.UpdateProductRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.instancio.Instancio;
import org.instancio.Model;

import java.math.BigDecimal;

import static org.instancio.Select.field;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public abstract class UpdateProductRequestFixture {

    public static Model<UpdateProductRequest> updateProductRequestModel() {
        return Instancio.of(UpdateProductRequest.class)
                .set(field(UpdateProductRequest::getId), "82736436-9ea5-45d1-81a4-31cba447566e")
                .set(field(UpdateProductRequest::getName), "Hamburguer Tripo X Atualizado")
                .set(field(UpdateProductRequest::getDescription), "Um belo sanduíche atualizado")
                .set(field(UpdateProductRequest::getImage), "http://localhost:8888/lanche-atualizado.png")
                .set(field(UpdateProductRequest::getPrice), BigDecimal.valueOf(6.00))
                .toModel();
    }
}