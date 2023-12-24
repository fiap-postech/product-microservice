package br.com.fiap.tech.challenge.rest.resource;

import br.com.fiap.tech.challenge.adapter.controller.product.ManageProductController;
import br.com.fiap.tech.challenge.rest.mapping.ProductResponseMapper;
import br.com.fiap.tech.challenge.rest.resource.doc.ManageProductResourceDoc;
import br.com.fiap.tech.challenge.rest.resource.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ManageProductResource implements ManageProductResourceDoc {

    private final ProductResponseMapper productResponseMapper;

    private final ManageProductController manageProductController;

    @PatchMapping("/{uuid}/enable")
    public ProductResponse enable(@PathVariable(name = "uuid") String uuid) {
        return productResponseMapper.toResponse(manageProductController.enable(uuid));
    }

    @PatchMapping("/{uuid}/disable")
    public ProductResponse disable(@PathVariable(name = "uuid") String uuid) {
        return productResponseMapper.toResponse(manageProductController.disable(uuid));
    }
}
