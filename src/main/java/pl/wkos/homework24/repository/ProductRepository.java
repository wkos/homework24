package pl.wkos.homework24.repository;

import org.springframework.stereotype.Repository;
import pl.wkos.homework24.model.Product;

import java.util.HashSet;
import java.util.Set;

@Repository
public class ProductRepository {
    Set<Product> products;

    public ProductRepository() {
        products = new HashSet<>();
    }


    public Set<Product> getProducts() {
        return products;
    }
}
