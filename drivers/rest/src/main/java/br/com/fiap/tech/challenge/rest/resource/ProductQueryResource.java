package br.com.fiap.tech.challenge.rest.resource;

import br.com.fiap.tech.challenge.adapter.controller.product.FindAllAvailableProductByCategoryController;
import br.com.fiap.tech.challenge.adapter.controller.product.FindAllAvailableProductController;
import br.com.fiap.tech.challenge.adapter.controller.product.FindProductByUUIDController;
import br.com.fiap.tech.challenge.adapter.dto.ProductDTO;
import br.com.fiap.tech.challenge.application.util.ResponseList;
import br.com.fiap.tech.challenge.enterprise.enums.ProductCategory;
import br.com.fiap.tech.challenge.rest.mapping.ProductResponseMapper;
import br.com.fiap.tech.challenge.rest.resource.doc.ProductQueryResourceDoc;
import br.com.fiap.tech.challenge.rest.resource.response.ProductResponse;
import br.com.fiap.tech.challenge.rest.util.Pages;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductQueryResource implements ProductQueryResourceDoc {

    private final ProductResponseMapper productResponseMapper;

    private final FindAllAvailableProductController findAllAvailableProductController;
    private final FindAllAvailableProductByCategoryController findAllAvailableProductByCategoryController;
    private final FindProductByUUIDController findProductByUUIDController;


    @GetMapping
    public ResponseList<ProductResponse> getAllAvailable(@ParameterObject Pageable pageable,
                                                         @RequestParam(required = false, name = "category") ProductCategory category) {

        var result = Optional.ofNullable(category)
                .map(c -> findAllAvailableProductByCategoryController.list(c, Pages.of(pageable)))
                .orElseGet(() -> findAllAvailableProductController.list(Pages.of(pageable)));

        return ResponseList.from(result, this::toResponse);
    }

    @GetMapping("/{uuid}")
    public ProductResponse getByUUID(@PathVariable("uuid") String uuid) {
        return toResponse(findProductByUUIDController.get(uuid));
    }

    private ProductResponse toResponse(ProductDTO dto) {
        return productResponseMapper.toResponse(dto);
    }
}
