package br.com.fiap.tech.challenge.launcher.configuration;

import br.com.fiap.tech.challenge.application.gateway.ProductReaderGateway;
import br.com.fiap.tech.challenge.application.gateway.ProductWriterGateway;
import br.com.fiap.tech.challenge.application.usecase.product.CreateProductUseCase;
import br.com.fiap.tech.challenge.application.usecase.product.DisableProductUseCase;
import br.com.fiap.tech.challenge.application.usecase.product.EnableProductUseCase;
import br.com.fiap.tech.challenge.application.usecase.product.FindAllAvailableProductByCategoryUseCase;
import br.com.fiap.tech.challenge.application.usecase.product.FindAllAvailableProductUseCase;
import br.com.fiap.tech.challenge.application.usecase.product.FindProductByUUIDUseCase;
import br.com.fiap.tech.challenge.application.usecase.product.ProductUseCaseFactory;
import br.com.fiap.tech.challenge.application.usecase.product.UpdateProductUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {
    @Bean
    public FindAllAvailableProductUseCase findAllAvailableProductService(ProductReaderGateway reader) {
        return ProductUseCaseFactory.findAllAvailableProductService(reader);
    }

    @Bean
    public FindAllAvailableProductByCategoryUseCase findAllAvailableProductByCategory(ProductReaderGateway reader) {
        return ProductUseCaseFactory.findAllAvailableProductByCategory(reader);
    }

    @Bean
    public FindProductByUUIDUseCase findProductByUUIDService(ProductReaderGateway reader) {
        return ProductUseCaseFactory.findProductByUUIDService(reader);
    }

    @Bean
    public CreateProductUseCase createProductService(ProductWriterGateway writerGateway, ProductReaderGateway readerGateway) {
        return ProductUseCaseFactory.createProductService(writerGateway, readerGateway);
    }

    @Bean
    public UpdateProductUseCase updateProductService(ProductWriterGateway writer, ProductReaderGateway reader) {
        return ProductUseCaseFactory.updateProductService(reader, writer);
    }

    @Bean
    public EnableProductUseCase enableProductService(ProductWriterGateway writer, ProductReaderGateway reader) {
        return ProductUseCaseFactory.enableProductService(writer, reader);
    }

    @Bean
    public DisableProductUseCase disableProductService(ProductWriterGateway writer, ProductReaderGateway reader) {
        return ProductUseCaseFactory.disableProductService(writer, reader);
    }
}