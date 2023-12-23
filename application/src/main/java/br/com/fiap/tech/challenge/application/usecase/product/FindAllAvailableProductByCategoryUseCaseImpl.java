package br.com.fiap.tech.challenge.application.usecase.product;

import br.com.fiap.tech.challenge.application.gateway.ProductReaderGateway;
import br.com.fiap.tech.challenge.enterprise.entity.Product;
import br.com.fiap.tech.challenge.enterprise.enums.ProductCategory;
import br.com.fiap.tech.challenge.application.util.Page;
import br.com.fiap.tech.challenge.application.util.ResponseList;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class FindAllAvailableProductByCategoryUseCaseImpl implements FindAllAvailableProductByCategoryUseCase {

    private final ProductReaderGateway readerService;

    @Override
    public ResponseList<Product> list(ProductCategory category, Page page) {
        return readerService.readAllByCategory(category, page);
    }
}
