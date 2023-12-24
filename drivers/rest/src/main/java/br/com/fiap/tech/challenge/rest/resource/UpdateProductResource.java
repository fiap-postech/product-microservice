package br.com.fiap.tech.challenge.rest.resource;

import br.com.fiap.tech.challenge.adapter.controller.product.UpdateProductController;
import br.com.fiap.tech.challenge.adapter.dto.ProductDTO;
import br.com.fiap.tech.challenge.rest.mapping.ProductResponseMapper;
import br.com.fiap.tech.challenge.rest.mapping.UpdateProductMapper;
import br.com.fiap.tech.challenge.rest.resource.doc.UpdateProductResourceDoc;
import br.com.fiap.tech.challenge.rest.resource.request.UpdateProductRequest;
import br.com.fiap.tech.challenge.rest.resource.response.ProductResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class UpdateProductResource implements UpdateProductResourceDoc {

    private final UpdateProductMapper updateProductMapper;
    private final ProductResponseMapper productResponseMapper;

    private final UpdateProductController updateProductController;

    @PutMapping
    public ProductResponse update(@RequestBody @Valid UpdateProductRequest request) {
        return productResponseMapper.toResponse(updateProductController.update(updateProductMapper.toDTO(request)));
    }
}
