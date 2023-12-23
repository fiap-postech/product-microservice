package br.com.fiap.tech.challenge.adapter.presenter;

import br.com.fiap.tech.challenge.adapter.dto.ProductDTO;
import br.com.fiap.tech.challenge.adapter.mapping.BeverageMapper;
import br.com.fiap.tech.challenge.adapter.mapping.ComboMapper;
import br.com.fiap.tech.challenge.adapter.mapping.DessertMapper;
import br.com.fiap.tech.challenge.adapter.mapping.SandwichMapper;
import br.com.fiap.tech.challenge.adapter.mapping.SideDishMapper;
import br.com.fiap.tech.challenge.enterprise.entity.Beverage;
import br.com.fiap.tech.challenge.enterprise.entity.Combo;
import br.com.fiap.tech.challenge.enterprise.entity.Dessert;
import br.com.fiap.tech.challenge.enterprise.entity.Product;
import br.com.fiap.tech.challenge.enterprise.entity.Sandwich;
import br.com.fiap.tech.challenge.enterprise.entity.SideDish;
import br.com.fiap.tech.challenge.application.util.ResponseList;

class ProductPresenterImpl implements ProductPresenter{
    @Override
    public ProductDTO present(Product product) {
        return switch (product.category()){
            case COMBO -> ComboMapper.INSTANCE.toDTO((Combo) product);
            case DESSERT -> DessertMapper.INSTANCE.toDTO((Dessert) product);
            case SIDE_DISH -> SideDishMapper.INSTANCE.toDTO((SideDish) product);
            case BEVERAGE -> BeverageMapper.INSTANCE.toDTO((Beverage) product);
            case SANDWICH -> SandwichMapper.INSTANCE.toDTO((Sandwich) product);
        };
    }

    @Override
    public ResponseList<ProductDTO> present(ResponseList<Product> list) {
        return ResponseList.from(list, this::present);
    }
}
