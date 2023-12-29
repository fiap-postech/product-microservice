package br.com.fiap.tech.challenge.rest.resource;

import br.com.fiap.tech.challenge.adapter.controller.product.UpdateProductController;
import br.com.fiap.tech.challenge.application.dto.UpdateProductDTO;
import br.com.fiap.tech.challenge.rest.mapping.ProductResponseMapper;
import br.com.fiap.tech.challenge.rest.mapping.UpdateProductMapper;
import br.com.fiap.tech.challenge.rest.util.Fixture;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static br.com.fiap.tech.challenge.rest.util.JsonUtil.asJsonString;
import static br.com.fiap.tech.challenge.rest.util.ProductDTOFixture.sandwichUpdatedModel;
import static br.com.fiap.tech.challenge.rest.util.UpdateProductRequestFixture.updateProductRequestModel;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UpdateProductResourceTest extends ResourceBaseTestSuite<UpdateProductResource> {

    @Mock
    private UpdateProductController updateProductController;

    @Test
    void updateProduct() throws Exception {
        var request = Fixture.create(updateProductRequestModel());
        var response = Fixture.create(sandwichUpdatedModel());

        when(updateProductController.update(any(UpdateProductDTO.class))).thenReturn(response);

        var requestBuilder = put("/product")
                .contentType(APPLICATION_JSON)
                .content(asJsonString(request));

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk());

        verify(updateProductController).update(any(UpdateProductDTO.class));
    }

    @Override
    UpdateProductResource createController() {
        return new UpdateProductResource(
                UpdateProductMapper.INSTANCE,
                ProductResponseMapper.INSTANCE,
                updateProductController
        );
    }
}