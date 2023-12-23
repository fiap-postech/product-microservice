package br.com.fiap.tech.challenge.adapter.controller.product;

import br.com.fiap.tech.challenge.adapter.dto.ProductDTO;
import br.com.fiap.tech.challenge.adapter.presenter.ProductPresenter;
import br.com.fiap.tech.challenge.application.dto.UpdateProductDTO;
import br.com.fiap.tech.challenge.application.usecase.product.UpdateProductUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class UpdateProductControllerImpl implements UpdateProductController{

    private final UpdateProductUseCase useCase;
    private final ProductPresenter presenter;

    @Override
    public ProductDTO update(UpdateProductDTO request) {
        return presenter.present(useCase.update(request));
    }
}
