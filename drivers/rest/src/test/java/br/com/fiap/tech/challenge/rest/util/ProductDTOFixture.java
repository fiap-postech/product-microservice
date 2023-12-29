package br.com.fiap.tech.challenge.rest.util;


import br.com.fiap.tech.challenge.adapter.dto.ComboDTO;
import br.com.fiap.tech.challenge.adapter.dto.ProductDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.instancio.Instancio;
import org.instancio.Model;

import java.math.BigDecimal;

import static br.com.fiap.tech.challenge.enterprise.enums.ProductCategory.BEVERAGE;
import static br.com.fiap.tech.challenge.enterprise.enums.ProductCategory.COMBO;
import static br.com.fiap.tech.challenge.enterprise.enums.ProductCategory.SANDWICH;
import static br.com.fiap.tech.challenge.enterprise.enums.ProductCategory.SIDE_DISH;
import static org.instancio.Select.field;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public abstract class ProductDTOFixture {
    public static Model<ProductDTO> sideDishModel() {
        return Instancio.of(ProductDTO.class)
                .set(field(ProductDTO::getName), "Bata Frita")
                .set(field(ProductDTO::getDescription), "Uma bela porção de batata sequinha")
                .set(field(ProductDTO::getImage), "http://localhost:8888/fritas.png")
                .set(field(ProductDTO::getCategory), SIDE_DISH)
                .toModel();
    }

    public static Model<ProductDTO> sandwichModel() {
        return Instancio.of(ProductDTO.class)
                .set(field(ProductDTO::getName), "Hamburguer Tripo X")
                .set(field(ProductDTO::getImage), "http://localhost:8888/lanche.png")
                .set(field(ProductDTO::getCategory), SANDWICH)
                .toModel();
    }

    public static Model<ProductDTO> beverageModel() {
        return Instancio.of(ProductDTO.class)
                .set(field(ProductDTO::getName), "Coca Cola")
                .set(field(ProductDTO::getImage), "http://localhost:8888/bebida.png")
                .set(field(ProductDTO::getCategory), BEVERAGE)
                .toModel();
    }

    public static Model<ComboDTO> comboProductModel() {
        return Instancio.of(ComboDTO.class)
                .set(field(ComboDTO::getName), "Bata Frita")
                .set(field(ComboDTO::getDescription), "Uma bela porção de batata sequinha")
                .set(field(ComboDTO::getPrice), BigDecimal.valueOf(5.00))
                .set(field(ComboDTO::getImage), "http://localhost:8888/fritas.png")
                .set(field(ComboDTO::getCategory), COMBO)
                .set(field(ComboDTO::getBeverage), Instancio.of(beverageModel()).create())
                .set(field(ComboDTO::getSideDish), Instancio.of(sideDishModel()).create())
                .set(field(ComboDTO::getSandwich), Instancio.of(sandwichModel()).create())
                .toModel();
    }

}
