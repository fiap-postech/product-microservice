package br.com.fiap.tech.challenge.rest.resource;

import br.com.fiap.tech.challenge.adapter.controller.product.FindAllAvailableProductByCategoryController;
import br.com.fiap.tech.challenge.adapter.controller.product.FindAllAvailableProductController;
import br.com.fiap.tech.challenge.adapter.controller.product.FindProductByUUIDController;
import br.com.fiap.tech.challenge.adapter.dto.ProductDTO;
import br.com.fiap.tech.challenge.application.util.ResponseList;
import br.com.fiap.tech.challenge.enterprise.enums.ProductCategory;
import br.com.fiap.tech.challenge.rest.mapping.ProductResponseMapper;
import br.com.fiap.tech.challenge.rest.util.Pages;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.data.domain.Pageable;

import java.util.function.Function;

import static br.com.fiap.tech.challenge.rest.util.Fixture.create;
import static br.com.fiap.tech.challenge.rest.util.ProductDTOFixture.sandwichModel;
import static java.util.Collections.singletonList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ProductQueryResourceTest extends ResourceBaseTestSuite<ProductQueryResource> {

    @Mock
    private FindAllAvailableProductController findAllAvailableProductController;
    @Mock
    private FindAllAvailableProductByCategoryController findAllAvailableProductByCategoryController;
    @Mock
    private FindProductByUUIDController findProductByUUIDController;

    @Test
    void testQueryProductByPageAndSizeAndCategory() throws Exception {
        var category = ProductCategory.SANDWICH;
        var pageSize = 1;
        var pageNumber = 0;
        var numberOfElements = 1;
        var totalElements = 1L;

        var productDTO = create(sandwichModel());
        Function<ProductDTO, ProductDTO> parser = dto -> productDTO;
        var responseList = new ResponseList<ProductDTO>(
                pageNumber,
                pageSize,
                numberOfElements,
                totalElements,
                singletonList(productDTO)
        );

        when(findAllAvailableProductByCategoryController.list(category, Pages.of(Pageable.ofSize(pageSize))))
                .thenReturn(responseList);

        var requestBuilder = get("/product?page=" + pageNumber + "&size=" + pageSize + "&category=" + category.name())
                .contentType(APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk());

        verify(findAllAvailableProductByCategoryController).list(category, Pages.of(Pageable.ofSize(pageSize)));
    }

    @Test
    void testQueryProductByPageAndSize() throws Exception {
        var pageSize = 1;
        var pageNumber = 0;
        var numberOfElements = 1;
        var totalElements = 1L;

        var productDTO = create(sandwichModel());
        Function<ProductDTO, ProductDTO> parser = dto -> productDTO;
        var responseList = new ResponseList<ProductDTO>(
                pageNumber,
                pageSize,
                numberOfElements,
                totalElements,
                singletonList(productDTO)
        );

        when(findAllAvailableProductController.list(Pages.of(Pageable.ofSize(pageSize))))
                .thenReturn(responseList);

        var requestBuilder = get("/product?page=" + pageNumber + "&size=" + pageSize)
                .contentType(APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk());

        verify(findAllAvailableProductController).list(Pages.of(Pageable.ofSize(pageSize)));
    }

    @Test
    void testQueryUUID() throws Exception {
        var productDTO = create(sandwichModel());
        var uuid = productDTO.getId();

        when(findProductByUUIDController.get(uuid)).thenReturn(productDTO);

        var requestBuilder = get("/product/" + uuid)
                .contentType(APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk());

        verify(findProductByUUIDController).get(uuid);
    }

    @Override
    ProductQueryResource createController() {
        return new ProductQueryResource(
                ProductResponseMapper.INSTANCE,
                findAllAvailableProductController,
                findAllAvailableProductByCategoryController,
                findProductByUUIDController
        );
    }
}