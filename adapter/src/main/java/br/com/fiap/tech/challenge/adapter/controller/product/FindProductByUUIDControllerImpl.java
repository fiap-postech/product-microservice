package br.com.fiap.tech.challenge.adapter.controller.product;

import br.com.fiap.tech.challenge.adapter.dto.ProductDTO;
import br.com.fiap.tech.challenge.adapter.presenter.ProductPresenter;
import br.com.fiap.tech.challenge.application.usecase.product.FindProductByUUIDUseCase;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
class FindProductByUUIDControllerImpl implements FindProductByUUIDController{

    private final FindProductByUUIDUseCase useCase;
    private final ProductPresenter presenter;

    @Override
    public ProductDTO get(String uuid) {
        return presenter.present(useCase.get(UUID.fromString(uuid)));
    }
}
