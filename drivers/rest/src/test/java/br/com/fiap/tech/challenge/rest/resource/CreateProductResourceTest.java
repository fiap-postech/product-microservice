package br.com.fiap.tech.challenge.rest.resource;

import br.com.fiap.tech.challenge.adapter.controller.product.CreateProductController;
import br.com.fiap.tech.challenge.application.dto.CreateProductDTO;
import br.com.fiap.tech.challenge.application.dto.CreateSingleProductDTO;
import br.com.fiap.tech.challenge.application.util.Page;
import br.com.fiap.tech.challenge.application.util.ResponseList;
import br.com.fiap.tech.challenge.rest.mapping.CreateProductMapper;
import br.com.fiap.tech.challenge.rest.mapping.ProductResponseMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CreateProductResourceTest extends ResourceBaseTestSuite<CreateProductResource> {

    @Mock
    private CreateProductMapper createProductMapper;

    @Mock
    private CreateProductController productController;


    @Test
    void shouldReturnWhenGetAllProducts() throws Exception {
        var requestDTO = new CreateSingleProductDTO();

//        when(productController.create(any(CreateProductDTO.class)))
//                .thenReturn(ResponseList.empty());
//
//        mvc.perform(get("/product"))
//                .andExpect(status().isOk());
//
//        verify(findAllAvailableProductController).list(any(Page.class));
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
