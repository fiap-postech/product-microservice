package br.com.fiap.tech.challenge.adapter.controller.product;

import br.com.fiap.tech.challenge.adapter.dto.ProductDTO;
import br.com.fiap.tech.challenge.adapter.presenter.ProductPresenter;
import br.com.fiap.tech.challenge.application.usecase.product.DisableProductUseCase;
import br.com.fiap.tech.challenge.application.usecase.product.EnableProductUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class ManageProductControllerImpl implements ManageProductController {

    private final EnableProductUseCase enableProductUseCase;
    private final DisableProductUseCase disableProductUseCase;
    private final ProductPresenter presenter;

    @Override
    public ProductDTO enable(String uuid) {
        return presenter.present(enableProductUseCase.enable(uuid));
    }

    @Override
    public ProductDTO disable(String uuid) {
        return presenter.present(disableProductUseCase.disable(uuid));
    }
}
