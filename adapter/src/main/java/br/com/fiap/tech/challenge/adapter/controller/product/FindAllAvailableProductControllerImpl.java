package br.com.fiap.tech.challenge.adapter.controller.product;

import br.com.fiap.tech.challenge.adapter.dto.ProductDTO;
import br.com.fiap.tech.challenge.adapter.presenter.ProductPresenter;
import br.com.fiap.tech.challenge.application.usecase.product.FindAllAvailableProductUseCase;
import br.com.fiap.tech.challenge.application.util.Page;
import br.com.fiap.tech.challenge.application.util.ResponseList;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class FindAllAvailableProductControllerImpl implements FindAllAvailableProductController{

    private final FindAllAvailableProductUseCase useCase;
    private final ProductPresenter presenter;

    @Override
    public ResponseList<ProductDTO> list(Page page) {
        return presenter.present(useCase.list(page));
    }
}
