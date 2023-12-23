package br.com.fiap.tech.challenge.adapter.controller.product;

import br.com.fiap.tech.challenge.adapter.dto.ProductDTO;
import br.com.fiap.tech.challenge.adapter.presenter.ProductPresenter;
import br.com.fiap.tech.challenge.enterprise.enums.ProductCategory;
import br.com.fiap.tech.challenge.application.usecase.product.FindAllAvailableProductByCategoryUseCase;
import br.com.fiap.tech.challenge.application.util.Page;
import br.com.fiap.tech.challenge.application.util.ResponseList;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class FindAllAvailableProductByCategoryControllerImpl implements FindAllAvailableProductByCategoryController {

    private final FindAllAvailableProductByCategoryUseCase findAllAvailableProductByCategoryUseCase;
    private final ProductPresenter productPresenter;

    @Override
    public ResponseList<ProductDTO> list(ProductCategory category, Page page) {
        return productPresenter.present(findAllAvailableProductByCategoryUseCase.list(category, page));
    }
}
