package br.com.fiap.tech.challenge.adapter.controller.product;

import br.com.fiap.tech.challenge.adapter.dto.ProductDTO;
import br.com.fiap.tech.challenge.adapter.presenter.ProductPresenter;
import br.com.fiap.tech.challenge.application.dto.CreateProductDTO;
import br.com.fiap.tech.challenge.application.usecase.product.CreateProductUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class CreateProductControllerImpl implements CreateProductController {

    private final CreateProductUseCase createProductUseCase;
    private final ProductPresenter productPresenter;

    @Override
    public ProductDTO create(CreateProductDTO dto) {
        return productPresenter.present(createProductUseCase.create(dto));
    }
}
