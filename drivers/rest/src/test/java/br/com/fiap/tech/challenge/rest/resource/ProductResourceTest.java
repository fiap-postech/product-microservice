package br.com.fiap.tech.challenge.rest.resource;

import br.com.fiap.tech.challenge.adapter.controller.product.CreateProductController;
import br.com.fiap.tech.challenge.adapter.controller.product.FindAllAvailableProductByCategoryController;
import br.com.fiap.tech.challenge.adapter.controller.product.FindAllAvailableProductController;
import br.com.fiap.tech.challenge.adapter.controller.product.FindProductByUUIDController;
import br.com.fiap.tech.challenge.adapter.controller.product.ManageProductController;
import br.com.fiap.tech.challenge.adapter.controller.product.UpdateProductController;
import br.com.fiap.tech.challenge.application.util.Page;
import br.com.fiap.tech.challenge.application.util.ResponseList;
import br.com.fiap.tech.challenge.rest.mapping.CreateProductMapper;
import br.com.fiap.tech.challenge.rest.mapping.ProductResponseMapper;
import br.com.fiap.tech.challenge.rest.mapping.UpdateProductMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration
@AutoConfigureMockMvc
class ProductResourceTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CreateProductMapper createProductMapper;

    @MockBean
    private UpdateProductMapper updateProductMapper;

    @MockBean
    private ProductResponseMapper productResponseMapper;

    @MockBean
    private FindAllAvailableProductController findAllAvailableProductController;

    @MockBean
    private FindAllAvailableProductByCategoryController findAllAvailableProductByCategoryController;

    @MockBean
    private FindProductByUUIDController findProductByUUIDController;

    @MockBean
    private CreateProductController createProductController;

    @MockBean
    private UpdateProductController updateProductController;

    @MockBean
    private ManageProductController manageProductController;

    @Test
    void shouldReturnWhenGetAllProducts() throws Exception {
        when(findAllAvailableProductController.list(any(Page.class)))
                .thenReturn(ResponseList.empty());

        mvc.perform(get("/product"))
                .andExpect(status().isOk());

        verify(findAllAvailableProductController).list(any(Page.class));
    }


}
