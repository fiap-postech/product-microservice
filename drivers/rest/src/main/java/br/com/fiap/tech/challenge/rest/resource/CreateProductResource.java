package br.com.fiap.tech.challenge.rest.resource;

import br.com.fiap.tech.challenge.adapter.controller.product.CreateProductController;
import br.com.fiap.tech.challenge.rest.mapping.CreateProductMapper;
import br.com.fiap.tech.challenge.rest.mapping.ProductResponseMapper;
import br.com.fiap.tech.challenge.rest.resource.doc.CreateProductResourceDoc;
import br.com.fiap.tech.challenge.rest.resource.request.CreateComboProductRequest;
import br.com.fiap.tech.challenge.rest.resource.request.CreateProductRequest;
import br.com.fiap.tech.challenge.rest.resource.request.CreateSingleProductRequest;
import br.com.fiap.tech.challenge.rest.resource.response.ProductResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class CreateProductResource implements CreateProductResourceDoc {

    private final CreateProductMapper createProductMapper;
    private final ProductResponseMapper productResponseMapper;

    private final CreateProductController createProductController;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse create(@RequestBody @Valid CreateProductRequest request) {
        if (request instanceof CreateComboProductRequest comboRequest) {
            return productResponseMapper.toResponse(createProductController.create(createProductMapper.fromRequest(comboRequest)));
        }

        return productResponseMapper.toResponse(
                createProductController.create(createProductMapper.fromRequest((CreateSingleProductRequest) request))
        );
    }
}
