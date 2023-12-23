package br.com.fiap.tech.challenge.adapter.gateway.product.writer;

import br.com.fiap.tech.challenge.enterprise.entity.Product;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductWriterFactory {

    @SuppressWarnings({"unchecked"})
    public static <T extends Product> ProductWriter<T> getWriter(Product product){
        return switch (product.category()){
            case COMBO -> (ProductWriter<T>) new ComboWriter();
            case DESSERT -> (ProductWriter<T>) new DessertWriter();
            case BEVERAGE -> (ProductWriter<T>) new BeverageWriter();
            case SANDWICH -> (ProductWriter<T>) new SandwichWriter();
            case SIDE_DISH -> (ProductWriter<T>) new SideDishWriter();
        };
    }
}
