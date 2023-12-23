package br.com.fiap.tech.challenge.adapter.controller.product;

import br.com.fiap.tech.challenge.adapter.presenter.ProductPresenter;
import br.com.fiap.tech.challenge.application.usecase.product.CreateProductUseCase;
import br.com.fiap.tech.challenge.application.usecase.product.DisableProductUseCase;
import br.com.fiap.tech.challenge.application.usecase.product.EnableProductUseCase;
import br.com.fiap.tech.challenge.application.usecase.product.FindAllAvailableProductByCategoryUseCase;
import br.com.fiap.tech.challenge.application.usecase.product.FindAllAvailableProductUseCase;
import br.com.fiap.tech.challenge.application.usecase.product.FindProductByUUIDUseCase;
import br.com.fiap.tech.challenge.application.usecase.product.UpdateProductUseCase;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductControllerFactory {

    public static CreateProductController createProductController(CreateProductUseCase useCase, ProductPresenter presenter){
        return new CreateProductControllerImpl(useCase, presenter);
    }

    public static FindAllAvailableProductByCategoryController findAllAvailableProductByCategoryController(FindAllAvailableProductByCategoryUseCase useCase, ProductPresenter presenter) {
        return new FindAllAvailableProductByCategoryControllerImpl(useCase, presenter);
    }

    public static FindAllAvailableProductController findAllAvailableProductController(FindAllAvailableProductUseCase useCase, ProductPresenter presenter) {
        return new FindAllAvailableProductControllerImpl(useCase, presenter);
    }

    public static FindProductByUUIDController findProductByUUIDController(FindProductByUUIDUseCase useCase, ProductPresenter presenter) {
        return new FindProductByUUIDControllerImpl(useCase, presenter);
    }

    public static UpdateProductController updateProductController(UpdateProductUseCase useCase, ProductPresenter presenter) {
        return new UpdateProductControllerImpl(useCase, presenter);
    }

    public static ManageProductController manageProductController(EnableProductUseCase enableUseCase, DisableProductUseCase disableUseCase, ProductPresenter presenter) {
        return new ManageProductControllerImpl(enableUseCase, disableUseCase, presenter);
    }

}
