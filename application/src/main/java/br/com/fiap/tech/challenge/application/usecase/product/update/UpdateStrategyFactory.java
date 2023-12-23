package br.com.fiap.tech.challenge.application.usecase.product.update;

import br.com.fiap.tech.challenge.application.dto.UpdateProductDTO;
import br.com.fiap.tech.challenge.enterprise.enums.ProductCategory;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UpdateStrategyFactory {
    public static UpdateStrategy getStrategy(ProductCategory category, UpdateProductDTO request){
        return switch (category){
            case COMBO -> new ComboUpdateStrategy(request);
            case DESSERT -> new DessertUpdateStrategy(request);
            case BEVERAGE -> new BeverageUpdateStrategy(request);
            case SANDWICH -> new SandwichUpdateStrategy(request);
            case SIDE_DISH -> new SideDishUpdateStrategy(request);
        };
    }
}
