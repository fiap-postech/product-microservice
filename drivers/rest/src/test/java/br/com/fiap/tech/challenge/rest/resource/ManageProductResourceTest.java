package br.com.fiap.tech.challenge.rest.resource;

import br.com.fiap.tech.challenge.adapter.controller.product.ManageProductController;
import br.com.fiap.tech.challenge.rest.mapping.ProductResponseMapper;
import br.com.fiap.tech.challenge.rest.util.Fixture;
import br.com.fiap.tech.challenge.rest.util.ProductDTOFixture;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ManageProductResourceTest extends ResourceBaseTestSuite<ManageProductResource> {

    @Mock
    private ManageProductController manageProductController;

    @Test
    void testEnableProduct() throws Exception {
        var response = Fixture.create(ProductDTOFixture.sandwichModel());
        var uuid = response.getId();

        when(manageProductController.enable(any(String.class))).thenReturn(response);

        var requestBuilder = patch("/product/{uuid}/enable", uuid)
                .contentType(APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk());

        verify(manageProductController).enable(any(String.class));
    }

    @Test
    void testDisableProduct() throws Exception {
        var response = Fixture.create(ProductDTOFixture.sandwichModel());
        var uuid = response.getId();

        when(manageProductController.disable(any(String.class))).thenReturn(response);

        var requestBuilder = patch("/product/{uuid}/disable", uuid)
                .contentType(APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk());

        verify(manageProductController).disable(any(String.class));
    }

    @Override
    ManageProductResource createController() {
        return new ManageProductResource(
                ProductResponseMapper.INSTANCE,
                manageProductController
        );
    }
}
