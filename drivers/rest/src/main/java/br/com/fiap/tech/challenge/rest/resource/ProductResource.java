package br.com.fiap.tech.challenge.rest.resource;

import br.com.fiap.tech.challenge.adapter.controller.product.CreateProductController;
import br.com.fiap.tech.challenge.adapter.controller.product.FindAllAvailableProductByCategoryController;
import br.com.fiap.tech.challenge.adapter.controller.product.FindAllAvailableProductController;
import br.com.fiap.tech.challenge.adapter.controller.product.FindProductByUUIDController;
import br.com.fiap.tech.challenge.adapter.controller.product.ManageProductController;
import br.com.fiap.tech.challenge.adapter.controller.product.UpdateProductController;
import br.com.fiap.tech.challenge.adapter.dto.ProductDTO;
import br.com.fiap.tech.challenge.enterprise.enums.ProductCategory;
import br.com.fiap.tech.challenge.rest.mapping.CreateProductMapper;
import br.com.fiap.tech.challenge.rest.mapping.ProductResponseMapper;
import br.com.fiap.tech.challenge.rest.mapping.UpdateProductMapper;
import br.com.fiap.tech.challenge.rest.resource.doc.ProductResourceDoc;
import br.com.fiap.tech.challenge.rest.resource.request.CreateComboProductRequest;
import br.com.fiap.tech.challenge.rest.resource.request.CreateProductRequest;
import br.com.fiap.tech.challenge.rest.resource.request.CreateSingleProductRequest;
import br.com.fiap.tech.challenge.rest.resource.request.UpdateProductRequest;
import br.com.fiap.tech.challenge.rest.resource.response.ProductResponse;
import br.com.fiap.tech.challenge.rest.util.Pages;
import br.com.fiap.tech.challenge.application.util.ResponseList;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductResource implements ProductResourceDoc {

    private final CreateProductMapper createProductMapper;
    private final UpdateProductMapper updateProductMapper;
    private final ProductResponseMapper productResponseMapper;

    private final FindAllAvailableProductController findAllAvailableProductController;
    private final FindAllAvailableProductByCategoryController findAllAvailableProductByCategoryController;
    private final FindProductByUUIDController findProductByUUIDController;
    private final CreateProductController createProductController;
    private final UpdateProductController updateProductController;
    private final ManageProductController manageProductController;


    @GetMapping
    public ResponseList<ProductResponse> getAllAvailable(@ParameterObject Pageable pageable,
                                                         @RequestParam(required = false, name = "category") ProductCategory category) {

        var result = Optional.ofNullable(category)
                .map(c -> findAllAvailableProductByCategoryController.list(c, Pages.of(pageable)))
                .orElseGet(() -> findAllAvailableProductController.list(Pages.of(pageable)));

        return ResponseList.from(result, this::toResponse);
    }

    @GetMapping("/{uuid}")
    public ProductResponse getByUUID(@PathVariable String uuid) {
        return toResponse(findProductByUUIDController.get(uuid));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse create(@RequestBody @Valid CreateProductRequest request) {
        if (request instanceof CreateComboProductRequest comboRequest) {
            return toResponse(createProductController.create(createProductMapper.fromRequest(comboRequest)));
        }

        return toResponse(
                createProductController.create(createProductMapper.fromRequest((CreateSingleProductRequest) request))
        );
    }

    @PutMapping
    public ProductResponse update(@RequestBody @Valid UpdateProductRequest request) {
        return toResponse(updateProductController.update(updateProductMapper.toDTO(request)));
    }

    @PatchMapping("/{uuid}/enable")
    public ProductResponse enable(@PathVariable String uuid) {
        return toResponse(manageProductController.enable(uuid));
    }

    @PatchMapping("/{uuid}/disable")
    public ProductResponse disable(@PathVariable String uuid) {
        return toResponse(manageProductController.disable(uuid));
    }

    private ProductResponse toResponse(ProductDTO dto) {
        return productResponseMapper.toResponse(dto);
    }
}
