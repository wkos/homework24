package pl.wkos.homework24.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wkos.homework24.model.Product;
import pl.wkos.homework24.repository.ProductRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Set<Product> getAll() {
        return new HashSet<>(productRepository.getProducts());
    }

    public void add(Product product) {
        productRepository.getProducts().add(product);
    }

    public double getPriceOfAllProducts() {
        return getAll().stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }
}
