package pl.wkos.homework24.service;

import pl.wkos.homework24.model.Product;

import java.util.Set;

public class ProductService {
    public static double getPriceOfAllProducts(Set<Product> products){
        return products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }
}
