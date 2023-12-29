package br.com.fiap.tech.challenge.rest.resource;

import br.com.fiap.tech.challenge.adapter.controller.product.CreateProductController;
import br.com.fiap.tech.challenge.application.dto.CreateProductDTO;
import br.com.fiap.tech.challenge.rest.mapping.CreateProductMapper;
import br.com.fiap.tech.challenge.rest.mapping.ProductResponseMapper;
import br.com.fiap.tech.challenge.rest.util.Fixture;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static br.com.fiap.tech.challenge.rest.util.CreateProductRequestFixture.comboProductRequestModel;
import static br.com.fiap.tech.challenge.rest.util.CreateProductRequestFixture.singleProductRequestModel;
import static br.com.fiap.tech.challenge.rest.util.ProductDTOFixture.comboProductModel;
import static br.com.fiap.tech.challenge.rest.util.ProductDTOFixture.sandwichModel;
import static br.com.fiap.tech.challenge.rest.util.Products.asJsonString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


class CreateProductResourceTest extends ResourceBaseTestSuite<CreateProductResource> {

    @Mock
    private CreateProductController productController;

    @Test
    void testCreatingSingleProduct() throws Exception {
        var request = Fixture.create(singleProductRequestModel());
        var response = Fixture.create(sandwichModel());

        when(productController.create(any(CreateProductDTO.class))).thenReturn(response);

        var requestBuilder = post("/product")
                .contentType(APPLICATION_JSON)
                .content(asJsonString(request));

        mockMvc.perform(requestBuilder)
                .andExpect(status().isCreated());

        verify(productController).create(any(CreateProductDTO.class));
    }

    @Test
    void testCreatingComboProduct() throws Exception {
        var request = Fixture.create(comboProductRequestModel());
        var response = Fixture.create(comboProductModel());

        when(productController.create(any(CreateProductDTO.class))).thenReturn(response);

        var requestBuilder = post("/product")
                .contentType(APPLICATION_JSON)
                .content(asJsonString(request));

        mockMvc.perform(requestBuilder)
                .andExpect(status().isCreated());

        verify(productController).create(any(CreateProductDTO.class));
    }

    @Override
    CreateProductResource createController() {
        return new CreateProductResource(
                CreateProductMapper.INSTANCE,
                ProductResponseMapper.INSTANCE,
                productController
        );
    }
}
