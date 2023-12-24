package br.com.fiap.tech.challenge.rest.resource;


import br.com.fiap.tech.challenge.rest.common.handler.ResourceExceptionHandler;
import br.com.fiap.tech.challenge.rest.mapping.ProductResponseMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.MockitoAnnotations.openMocks;

abstract class ResourceBaseTestSuite<T> {

    AutoCloseable openMocks;

    protected MockMvc mockMvc;
    protected T controller;

    abstract T createController();

    @BeforeEach
    void setUp() {
        openMocks = openMocks(this);
        controller = createController();
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setControllerAdvice(new ResourceExceptionHandler())
                .addFilter((request, response, chain) -> {
                    response.setCharacterEncoding("UTF-8");
                    chain.doFilter(request, response);
                }, "/*")
                .build();
    }

    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }
}
