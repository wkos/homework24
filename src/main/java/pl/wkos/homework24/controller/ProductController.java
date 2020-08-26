package pl.wkos.homework24.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.wkos.homework24.model.Product;
import pl.wkos.homework24.repository.ProductRepository;
import pl.wkos.homework24.service.ProductService;

import java.util.Optional;
import java.util.Set;

@Controller
public class ProductController {
    ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    public String getAddForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);

        return "home";
    }

    @PostMapping("/")
    public String add(Product product) {
        productRepository.add(product);
        return "redirect:/";
    }

    @GetMapping("/lista")
    public String getAllProducts(Model model) {
        Set<Product> products = productRepository.getAll();
        model.addAttribute("products", products);
        model.addAttribute("priceOfAll", ProductService.getPriceOfAllProducts(products));
        return "lista";
    }

    @GetMapping("/tabela")
    String getAllProductsIntoTable(Model model) {
        Set<Product> products = productRepository.getAll();
        model.addAttribute("products", products);
        model.addAttribute("priceOfAll", ProductService.getPriceOfAllProducts(products));
        return "tabela";
    }
}