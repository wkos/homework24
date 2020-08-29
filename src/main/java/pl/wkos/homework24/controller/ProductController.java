package pl.wkos.homework24.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.wkos.homework24.model.Product;
import pl.wkos.homework24.service.ProductService;

import java.util.Set;

@Controller
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String getAddForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);

        return "home";
    }

    @PostMapping("/")
    public String add(Product product) {
        productService.add(product);
        return "redirect:/";
    }

    @GetMapping("/lista")
    public String getAllProducts(Model model) {
        Set<Product> products = productService.getAll();
        model.addAttribute("products", products);
        model.addAttribute("priceOfAll", productService.getPriceOfAllProducts());
        return "lista";
    }

    @GetMapping("/tabela")
    String getAllProductsIntoTable(Model model) {
        Set<Product> products = productService.getAll();
        model.addAttribute("products", products);
        model.addAttribute("priceOfAll", productService.getPriceOfAllProducts());
        return "tabela";
    }
}