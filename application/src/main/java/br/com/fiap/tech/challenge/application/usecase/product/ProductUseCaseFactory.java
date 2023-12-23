package br.com.fiap.tech.challenge.application.usecase.product;

import br.com.fiap.tech.challenge.application.gateway.ProductReaderGateway;
import br.com.fiap.tech.challenge.application.gateway.ProductWriterGateway;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductUseCaseFactory {

    public static FindAllAvailableProductUseCase findAllAvailableProductService(ProductReaderGateway reader) {
        return new FindAllAvailableProductUseCaseImpl(reader);
    }

    public static FindAllAvailableProductByCategoryUseCase findAllAvailableProductByCategory(ProductReaderGateway reader) {
        return new FindAllAvailableProductByCategoryUseCaseImpl(reader);
    }

    public static FindProductByUUIDUseCase findProductByUUIDService(ProductReaderGateway reader) {
        return new FindProductByUUIDUseCaseImpl(reader);
    }

    public static CreateProductUseCase createProductService(ProductWriterGateway writerGateway, ProductReaderGateway readerGateway) {
        return new CreateProductUseCaseImpl(writerGateway, readerGateway);
    }

    public static UpdateProductUseCase updateProductService(ProductReaderGateway reader, ProductWriterGateway writer) {
        return new UpdateProductUseCaseImpl(reader, writer);
    }

    public static EnableProductUseCase enableProductService(ProductWriterGateway writer, ProductReaderGateway reader) {
        return new EnableProductUseCaseImpl(reader, writer);
    }

    public static DisableProductUseCase disableProductService(ProductWriterGateway writer, ProductReaderGateway reader) {
        return new DisableProductUseCaseImpl(reader, writer);
    }
}