package br.com.fiap.tech.challenge.launcher.configuration;

import br.com.fiap.tech.challenge.adapter.controller.product.CreateProductController;
import br.com.fiap.tech.challenge.adapter.controller.product.FindAllAvailableProductByCategoryController;
import br.com.fiap.tech.challenge.adapter.controller.product.FindAllAvailableProductController;
import br.com.fiap.tech.challenge.adapter.controller.product.FindProductByUUIDController;
import br.com.fiap.tech.challenge.adapter.controller.product.ManageProductController;
import br.com.fiap.tech.challenge.adapter.controller.product.ProductControllerFactory;
import br.com.fiap.tech.challenge.adapter.controller.product.UpdateProductController;
import br.com.fiap.tech.challenge.adapter.presenter.ProductPresenter;
import br.com.fiap.tech.challenge.application.usecase.product.CreateProductUseCase;
import br.com.fiap.tech.challenge.application.usecase.product.DisableProductUseCase;
import br.com.fiap.tech.challenge.application.usecase.product.EnableProductUseCase;
import br.com.fiap.tech.challenge.application.usecase.product.FindAllAvailableProductByCategoryUseCase;
import br.com.fiap.tech.challenge.application.usecase.product.FindAllAvailableProductUseCase;
import br.com.fiap.tech.challenge.application.usecase.product.FindProductByUUIDUseCase;
import br.com.fiap.tech.challenge.application.usecase.product.UpdateProductUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfiguration {

    @Bean
    public CreateProductController createProductController(CreateProductUseCase useCase, ProductPresenter presenter){
        return ProductControllerFactory.createProductController(useCase, presenter);
    }

    @Bean
    public UpdateProductController updateProductController(UpdateProductUseCase useCase, ProductPresenter presenter) {
        return ProductControllerFactory.updateProductController(useCase, presenter);
    }

    @Bean
    public ManageProductController manageProductController(EnableProductUseCase enableUseCase, DisableProductUseCase disableUseCase, ProductPresenter presenter) {
        return ProductControllerFactory.manageProductController(enableUseCase, disableUseCase, presenter);
    }

    @Bean
    public FindAllAvailableProductByCategoryController findAllAvailableProductByCategoryController(FindAllAvailableProductByCategoryUseCase useCase, ProductPresenter presenter) {
        return ProductControllerFactory.findAllAvailableProductByCategoryController(useCase, presenter);
    }

    @Bean
    public FindAllAvailableProductController findAllAvailableProductController(FindAllAvailableProductUseCase useCase, ProductPresenter presenter){
        return ProductControllerFactory.findAllAvailableProductController(useCase, presenter);
    }

    @Bean
    public FindProductByUUIDController findProductByUUIDController(FindProductByUUIDUseCase useCase, ProductPresenter presenter) {
        return ProductControllerFactory.findProductByUUIDController(useCase, presenter);
    }
}
